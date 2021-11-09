package pageObject.webPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement loginBtn = $("[class='auth-bar__item auth-bar__item--text']");

    public HomePage clickLoginBtn(){
        loginBtn.click();
        return this;
    }


}
