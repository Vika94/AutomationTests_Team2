package pageObject.forms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(xpath = "//img[contains(@alt,'X515MA-BR414')]")
    SelenideElement product;

    ElementsCollection products = $$(By.xpath("//span[contains(@data-bind,'minPrice')]"));

    public FilterProducts clickProduct() {
        product.click();
        return this;
    }

    public FilterProducts enterMinPrice(String text) {
        minPrice.setValue(text);
        return this;
    }

    public FilterProducts enterMaxPrice(String text) {
        maxPrice.setValue(text);
        return this;
    }

    public FilterProducts verifyFilterPrice() {
        List<String> list = new ArrayList<>();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        products.forEach(product -> list.add(product.getText()));
        List<Double> listOfPrices = list.stream()
                .map(this::parseStringToDouble)
                .sorted()
                .collect(Collectors.toList());
        listOfPrices.forEach(System.out::println);
        Assert.assertTrue(listOfPrices.get(0) > 499);
        List<Double> listOfPricesReverse = list.stream()
                .map(this::parseStringToDouble)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assert.assertTrue(listOfPrices.get(0) < 901);
        return this;

    }

    public double parseStringToDouble(String str) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        double value = 0;
        try {
            value = format.parse(str).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
