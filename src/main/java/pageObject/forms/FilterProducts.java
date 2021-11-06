package pageObject.forms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Values;

import static com.codeborne.selenide.Selenide.$$;

public class FilterProducts {
    @FindBy(xpath = "//input[@placeholder='от']")
    SelenideElement minPrice;

    @FindBy(xpath = "(//input[contains(@class,'input_price')])[2]")
    SelenideElement maxPrice;


    public FilterProducts enterMinPrice(Values text) {
        minPrice.setValue(text.getMinPrice());
        return this;
    }

    public FilterProducts enterMaxPrice(Values text) {
        maxPrice.setValue(text.getMaxPrice());
        return this;
    }
}
