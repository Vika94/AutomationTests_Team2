package pageObject.forms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObject.HomePage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class FilterProducts {
    @FindBy(xpath = "//input[@placeholder='от']")
    SelenideElement minPrice;

    @FindBy(xpath = "(//input[contains(@class,'input_price')])[2]")
    SelenideElement maxPrice;


    public FilterProducts enterMinPrice(String text) {
        minPrice.setValue(text);
        return this;
    }

    public FilterProducts enterMaxPrice(String text) {
        maxPrice.setValue(text);
        return this;
    }
}
