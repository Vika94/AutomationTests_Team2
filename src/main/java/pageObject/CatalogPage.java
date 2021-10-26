package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageObject.forms.menuProducts.ComputersMenu;
import pageObject.forms.menuProducts.MenuProducts;
import pageObject.forms.menuProducts.NotebookMenu;

public class CatalogPage {

    private SelenideElement getLink(MenuProducts menuProducts) {
        return menuProducts.getElement();
    }

    public CatalogPage clickMenu(MenuProducts menuProducts) {
        getLink(menuProducts).click();
        return this;
    }


    public CatalogPage moveToElement(ComputersMenu computersMenu) {
        Selenide.actions().moveToElement(computersMenu.getElement()).perform();
        return this;
    }

    private SelenideElement getLink(NotebookMenu notebookMenu) {
        return notebookMenu.getElement();
    }

    public CatalogPage clickNotebooks(NotebookMenu notebookMenu) {
        getLink(notebookMenu).click();
        return this;
    }
}
