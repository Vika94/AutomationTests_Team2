package pageObject.forms.menuProducts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum MenuProducts {
    COMPUTERS($(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Компьютеры и')]")));

    protected SelenideElement element;

    MenuProducts(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }

}

