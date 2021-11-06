package restApi;

import baseTest.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;
import pageObject.webPages.*;
import restApi.delete.Position;
import restApi.delete.Root;
import restApi.post.Authorization;
import restApi.post.NewProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestApiTests extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setEmail("qa07qa@mail.ru");
        values.setPassword("qa07qa07");
    }
    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Authorization authorization = new Authorization() {{
        setLogin("qa07qa@mail.ru");
        setPassword("qa07qa07");
    }};
    NewProduct newProduct = new NewProduct() {{
        setQuantity(1);
        setPosition_id("3886:138648");
        setShop_id(3886);
        setProduct_id(2683572);
        setProduct_key("82ku00b3rk");
    }};
    Position position = new Position() {{
        setPosition_id("3886:138648");
        setShop_id(3886);
        setProduct_id(2683572);
    }};
    List<Position> list = Arrays.asList(position);
    Root root = new Root() {{
        setPositions(list);
    }};


    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://www.onliner.by";
        String response = given().when().body(mapper.writeValueAsString(authorization))
                .and().contentType(ContentType.JSON)
                .when().post("/sdapi/user.api/login")
                .getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("access_token").getAsString();
    }

    @Test
    public void checkProductNameUiAndApi() {
        get(CatalogPage.class)
                .clickMenu(MenuProducts.COMPUTERS)
                .moveToElement(ComputersMenu.NOTEBOOKS)
                .clickNotebook(NotebookMenu.NOTEBOOK);
        String endpoint = "/sdapi/catalog.api/search/notebook";
        Gson gson = new Gson();
        String json = given().when().get(endpoint).asPrettyString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        List<String> listOfProductName = new ArrayList<>();
        jsonObject.get("products").getAsJsonArray()
                .forEach(product -> listOfProductName.add(product.getAsJsonObject()
                        .get("extended_name")
                        .toString()
                        .replace("\"", "").replace("\\", "\"")));
        Assert.assertEquals(get(ProductsPage.class).listProductsByName(), listOfProductName);
        closeWebDriver();
    }

    @Test(priority = 1)
    public void CheckProfileData() throws JsonProcessingException {
        baseURI = "https://profile.onliner.by/";
        String endpoint = "sdapi/user.api/me";
        String json = given()
                .when()
                .body(mapper.writeValueAsString(authorization))
                .and().header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON)
                .get(endpoint).asPrettyString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        Assert.assertEquals(jsonObject.get("email").toString().replace("\"", ""), "qa07qa@mail.ru");
    }

    @Test(priority = 2)
    public void checkProductInBasket() throws JsonProcessingException, InterruptedException {
        baseURI = "https://cart.onliner.by/";
        Response response = given().when().body(mapper.writeValueAsString(newProduct))
                .header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON)
                .when().post("sdapi/cart.api/positions");
        JsonObject jsonObject = gson.fromJson(response.asPrettyString(), JsonObject.class);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(jsonObject.get("shop_id").toString().replace("\"", ""), "3886");
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail(values)
                .enterPassword(values)
                .clickLoginBtn();
        get(CatalogPage.class).clickBasketBtn();
        get(BasketPage.class).checkNotebooksInBasket();
        closeWebDriver();
    }

    @Test(dependsOnMethods = "checkProductInBasket")
    public void getProductFromBasket() {
        baseURI = "https://cart.onliner.by";
        String endpoint = "sdapi/cart.api/v2/positions?include=position";
        String json = given().when().header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON)
                .get(endpoint).asPrettyString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        List<String> listOfShops = new ArrayList<>();
        jsonObject.get("position_groups").getAsJsonArray()
                .forEach(product -> listOfShops.add(product.getAsJsonObject()
                        .get("shop").getAsJsonObject().get("id")
                        .toString()
                        .replace("\"", "")));
        Response response = given().when().header("Authorization", "Bearer " + token).and().header("Content-Type", "application/json").get(endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(listOfShops.get(0), "3886");
    }

    @Test(dependsOnMethods = "getProductFromBasket")
    public void deleteProductFromBasket() throws JsonProcessingException {
        baseURI = "https://cart.onliner.by";
        String endpoint = "sdapi/cart.api/positions";
        Response response = given().when().body(mapper.writeValueAsString(root))
                .and().header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON).delete(endpoint);
        Assert.assertEquals(response.statusCode(), 204);
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail(values)
                .enterPassword(values)
                .clickLoginBtn();
        get(CatalogPage.class).clickBasketBtn();
        get(BasketPage.class).elementNotDisplayed();
        closeWebDriver();
    }
}

