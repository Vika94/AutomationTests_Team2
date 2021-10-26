package pageObject.forms.menuProducts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum NotebookMenu {
    NOTEBOOKS($(By.xpath("//a[contains(@href,'notebook')]")));

    protected SelenideElement element;

    NotebookMenu(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }
}
