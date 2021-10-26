package pageObject.forms.menuProducts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum ComputersMenu {
    NOTEBOOK($(By.xpath("//div[contains(text(),'Ноутбуки')]")));

    protected SelenideElement element;

    ComputersMenu(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }
    }
