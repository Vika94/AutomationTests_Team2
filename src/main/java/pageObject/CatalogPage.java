package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;

public class CatalogPage {

    public CatalogPage clickMenu(MenuProducts menuProducts) {
        menuProducts.getElement().click();
        return this;
    }

    public CatalogPage moveToElement(ComputersMenu computersMenu) {
        Selenide.actions().moveToElement(computersMenu.getElement()).perform();
        return this;
    }

    public CatalogPage clickNotebook(NotebookMenu notebookMenu) {
        notebookMenu.getElement().click();
        return this;
    }
}
