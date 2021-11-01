import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.BasketPage;

public class BasketPageTest extends BaseTest {
    @Test
    public void checkProductsByPriseTest() throws InterruptedException {
        get(BasketPage.class)
                .checkNotebooksInBasket()
                .checkMaxNumberNotebook()
                .deleteNotebooksFromBasket()
                .changeCityForDelivery("Брест");
    }
}
