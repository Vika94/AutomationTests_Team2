import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.webPages.ProductsPage;
import pageObject.forms.FilterProducts;

public class ProductsPageTest extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setMinPrice("500");
        values.setMaxPrice("900");
    }

    @Test
    public void checkProductsByPriseTest (){
        get(FilterProducts.class)
                .enterMinPrice(values)
                .enterMaxPrice(values);
        get(ProductsPage.class)
                .verifyProductsPrice(values)
                .clickProduct();
    }
}
