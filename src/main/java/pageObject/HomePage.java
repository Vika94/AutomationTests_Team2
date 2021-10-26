package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "(//div[@id='userbar']//div)[6]")
    SelenideElement loginBtn;

    public HomePage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

}
