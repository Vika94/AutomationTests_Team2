package smoke;

import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;
import pageObject.webPages.*;

public class SmokeTests extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setEmail("qa07qa@mail.ru");
        values.setPassword("qa07qa07");
    }
    @Test
    public void checkSmokeTests() {
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail(values)
                .enterPassword(values)
                .clickLoginBtn();
        get(CatalogPage.class)
                .clickMenu(MenuProducts.COMPUTERS)
                .moveToElement(ComputersMenu.NOTEBOOKS)
                .clickNotebook(NotebookMenu.NOTEBOOK);
        get(ProductsPage.class)
                .clickProduct();
        get(NotebookPage.class)
                .addProductsToBasket()
                .moveToBasket();
        get(BasketPage.class)
                .deleteNotebooksFromBasket();

    }
}
