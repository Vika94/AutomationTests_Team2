import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.webPages.HomePage;
import pageObject.webPages.LoginPage;

public class VerifyLoginPageTest extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setEmail("wfqwf");
        values.setPassword("qefqe");
    }

    @Test
    public void loginPageTest() {
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .enterEmail(values)
                .enterPassword(values)
                .clickLoginBtn()
                .verifyErrorText();
    }
}
