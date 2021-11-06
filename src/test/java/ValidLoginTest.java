import baseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Values;
import pageObject.webPages.LoginPage;

public class ValidLoginTest extends BaseTest {
    Values values;

    @BeforeTest
    public void precondition() {
        values = new Values();
        values.setEmail("qa07qa@mail.ru");
        values.setPassword("qa07qa07");
    }

    @Test
    public void checkValidLoginTest() {

        get(LoginPage.class)
                .enterEmail(values)
                .enterPassword(values)
                .clickLoginBtn();
    }
}
