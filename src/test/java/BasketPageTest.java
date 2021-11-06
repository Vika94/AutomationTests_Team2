import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.webPages.BasketPage;

public class BasketPageTest extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setCityForDelivery("Брест");

    }
    @Test
    public void checkProductsByPriseTest()  {
        get(BasketPage.class)
                .checkNotebooksInBasket()
                .checkMaxNumberNotebook()
                .deleteNotebooksFromBasket()
               .changeCityForDelivery(values);
    }
}
