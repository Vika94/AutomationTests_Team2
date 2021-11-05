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
    SelenideElement basket = $("[class='b-top-profile__cart']");
    SelenideElement notebookBtn = $("[class='breadcrumbs__list'] :nth-child(2)");
    //SelenideElement product = $(xpath ("//div[@class='schema-product__part schema-product__part_1']"));
    ElementsCollection searchNotebook = $$ ("[class='schema-product__title']");




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

    public NotebookPage addProductsToBasket()  {
        basketBtn.click();
        for (int i = 1; i < 3; i++) {
            notebookBtn.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            searchNotebook.get(i).click();
            basketBtn.click();

        }
        return this;
    }
    public NotebookPage moveToBasket()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.click();
        return this;
    }

}
