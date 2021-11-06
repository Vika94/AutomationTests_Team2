package pageObject.webPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Values;

import static com.codeborne.selenide.Condition.matchText;

public class LoginPage {
    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    SelenideElement email;

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
