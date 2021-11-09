package pageObject.forms.menuProducts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public enum ComputersMenu {
    NOTEBOOKS($(xpath("//div[contains(text(),'Ноутбуки')]")));

    protected SelenideElement element;

    ComputersMenu(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }
    }
