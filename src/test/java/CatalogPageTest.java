import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.CatalogPage;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;

public class CatalogPageTest extends BaseTest {
    @Test
    public void checkCatalogPageTest() {
        get(CatalogPage.class)
                .clickMenu(MenuProducts.COMPUTERS)
                .moveToElement(ComputersMenu.NOTEBOOKS)
                .clickNotebook(NotebookMenu.NOTEBOOK);
    }
}
