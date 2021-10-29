package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ParsUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    @FindBy(xpath = "//img[contains(@alt,'X515MA-BR414')]")
    SelenideElement product;

    ElementsCollection productsByPrice = $$(By.xpath("//span[contains(@data-bind,'minPrice')]"));

    ElementsCollection productsByName = $$(By.xpath("//span[contains(@data-bind,'extended_name')]"));

    public ProductsPage clickProduct() {
        product.click();
        return this;
    }

    public ProductsPage verifyProductsPrice() {
        List<String> list = new ArrayList<>();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsByPrice.forEach(product -> list.add(product.getText()));
        List<Double> listOfPrices = list.stream()
                .map(ParsUtils::parseStringToDouble)
                .sorted()
                .collect(Collectors.toList());
        Assert.assertTrue(listOfPrices.get(0) > 499);
        List<Double> listOfPricesReverse = list.stream()
                .map(ParsUtils::parseStringToDouble)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assert.assertTrue(listOfPrices.get(0) < 901);
        return this;
    }

    public List<String> listProductsByName() {
        List<String> list = new ArrayList<>();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsByName.forEach(product -> list.add(product.getText()));
        list.forEach(System.out::println);
        return list;
    }
}
