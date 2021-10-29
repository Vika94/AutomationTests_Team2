package restApi;

import baseTest.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CatalogPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductsPage;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestApiTests extends BaseTest {
    Gson gson = new Gson();

    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://www.onliner.by";
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail("qa07qa@mail.ru")
                .enterPassword("qa07qa07")
                .clickLoginBtn();
        get(CatalogPage.class)
                .clickMenu(MenuProducts.COMPUTERS)
                .moveToElement(ComputersMenu.NOTEBOOKS)
                .clickNotebook(NotebookMenu.NOTEBOOK);
    }

    @Test
    public void checkProductNameUiAndApi() {
        String endpoint = "/sdapi/catalog.api/search/notebook";
        String json = given().when().get(endpoint).asPrettyString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        List<String> listOfProductName = new ArrayList<>();
        jsonObject.get("products").getAsJsonArray()
                .forEach(product -> listOfProductName.add(product.getAsJsonObject()
                        .get("extended_name")
                        .toString()
                        .replace("\"", "").replace("\\", "\"")));
        Assert.assertEquals(get(ProductsPage.class).listProductsByName(), listOfProductName);
    }
}
