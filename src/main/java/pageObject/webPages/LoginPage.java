package pageObject.webPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Values;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    SelenideElement email = $(xpath ("//input[@placeholder='Ник или e-mail']"));

    @FindBy(xpath = "//input[@type='password']")
    SelenideElement password;

    @FindBy(xpath = "//div[contains(@class,'description_error')]")
    SelenideElement errorText;

    @FindBy(xpath = "//button[contains(@class,'button_primary')]")
    SelenideElement loginBtn;

    public LoginPage enterEmail(Values text){
        email.setValue(text.getEmail());
        return this;
    }

    public LoginPage enterPassword(Values text){
        password.setValue(text.getPassword());
        return this;
    }

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

    public LoginPage verifyErrorText(){
        errorText.shouldBe(matchText("Неверный логин или пароль"));
        return this;
    }
}
