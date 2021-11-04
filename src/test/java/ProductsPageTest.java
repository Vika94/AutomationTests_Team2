import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.ProductsPage;
import pageObject.forms.FilterProducts;

public class ProductsPageTest extends BaseTest {

    @Test
    public void checkProductsByPriseTest (){
        get(FilterProducts.class)
                .enterMinPrice("500")
                .enterMaxPrice("900");
        get(ProductsPage.class)
                .verifyProductsPrice()
                .clickProduct();
    }
}
