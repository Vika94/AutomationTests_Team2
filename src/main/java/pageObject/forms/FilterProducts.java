package pageObject.forms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObject.LoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.screenshot;

public class FilterProducts {
    @FindBy(xpath = "//input[@placeholder='от']")
    SelenideElement minPrice;

    @FindBy(xpath = "(//input[contains(@class,'input_price')])[2]")
    SelenideElement maxPrice;

    ElementsCollection products = $$(By.xpath("//span[contains(@data-bind,'minPrice')]"));

    public FilterProducts enterMinPrice(String text){
        minPrice.setValue(text);
        return this;
    }

    public FilterProducts enterMaxPrice(String text){
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
        list.stream()
                .map(product -> product.replace("р.", ""))
                .map(Double::parseDouble)
                .sorted().collect(Collectors.toList());
        System.out.println(list);


       // products.forEach(product-> System.out.println(Long.parseLong(product.getText())));
       // products.forEach(product -> list.add(product.getText()));
        //System.out.println(list);
        //Assert.assertEquals(list.stream().sorted().collect(Collectors.toList()).get(0), "552,09");
        return this;
       // ^(0|[1-9]\d*)([.,]\d+)?

    }
}
