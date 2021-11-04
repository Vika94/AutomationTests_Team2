package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;


public class NotebookPage extends BasketPage{

    SelenideElement titleProduct = $ (xpath ("//h1[@class='catalog-masthead__title']"));
    SelenideElement priceChart = $("a[class*='button_white button_big']");
    SelenideElement PopupPriceChart = $("div[class='popup-style__content']");
    SelenideElement titleInPopup = $("div[class='offers-form__title offers-form__title_middle-alter']");
    SelenideElement popupClose = $("span[class='popup-style__close']");
    SelenideElement basketBtn = $("[class='product-aside__box'] [class*='button-style_expletive']");
    SelenideElement chooseAnotherNotebook = $( "[class='offers-description-filter-control__item']");
    ElementsCollection notebooksList = $$("[class='offers-description-configurations__title']");
    SelenideElement basket = $("[class='b-top-profile__cart']");


    public NotebookPage checkProductTitle() {
        titleProduct.shouldBe(visible);
        return this;
    }


    public NotebookPage checkPopupPriceChart() {
        priceChart.click();
        PopupPriceChart.shouldBe(exist).shouldHave(text(titleInPopup.getText()));
        popupClose.click();
        return this;
    }

    public NotebookPage addProductsToBasket() throws InterruptedException {
        basketBtn.click();
        chooseAnotherNotebook.click();
       for (int i =1; i<3; i++){
           Thread.sleep(5000);
           notebooksList.get(i).click();
            titleProduct.shouldBe(exist);
            basketBtn.click();
            chooseAnotherNotebook.click();}
        return this;
    }
    public NotebookPage moveToBasket() throws InterruptedException {
        Thread.sleep(5000);
        basket.click();
        return this;
    }

}
