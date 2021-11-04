import baseTest.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class VerifyLoginPageTest extends BaseTest {


    @Test
    public void loginPageTest() {
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail("wfqwf")
                .enterPassword("qefqe")
                .clickLoginBtn()
                .verifyErrorText();
    }
}
