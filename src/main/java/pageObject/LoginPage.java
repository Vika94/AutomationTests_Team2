package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginPage enterEmail(String text){
        email.setValue(text);
        return this;
    }

    public LoginPage enterPassword(String text){
        password.setValue(text);
        return this;
    }

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

    public LoginPage verifyText(){
        errorText.shouldBe(matchText("Неверный логин или пароль"));
        return this;
    }
}
