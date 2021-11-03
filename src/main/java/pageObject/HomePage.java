package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//div[(text()='Вход')]")
    SelenideElement loginBtn;

    public HomePage clickLoginBtn(){
        loginBtn.click();
        return this;
    }


}
