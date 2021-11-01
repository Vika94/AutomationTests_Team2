import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class ValidLoginTest extends BaseTest {

    @Test
     public void checkValidLoginTest() {

        get(LoginPage.class)
                .enterEmail("qa07qa@mail.ru")
                .enterPassword("qa07qa07")
                .clickLoginBtn();
    }
}
