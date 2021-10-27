import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.CatalogPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductsPage;
import pageObject.forms.FilterProducts;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;

public class Tests extends BaseTest {

    @Test
    public void loginPageTest() {
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
        get(FilterProducts.class)
                .enterMinPrice("500")
                .enterMaxPrice("900");
        get(ProductsPage.class)
                .verifyProductsPrice()
                .clickProduct();
    }
}
