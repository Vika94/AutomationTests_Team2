import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.NotebookPage;

public class NotebookPageTest extends BaseTest {

    @Test
    public void checkNotebookPageTest()  {
        get(NotebookPage.class)
                .checkPopupPriceChart()
                .addProductsToBasket()
                .moveToBasket();
    }
}
