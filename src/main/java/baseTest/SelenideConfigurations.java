package baseTest;

import com.codeborne.selenide.Configuration;
import utils.PropertyReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SelenideConfigurations {
    public SelenideConfigurations(PropertyReader propertiesReader) {
        setSelenideConfiguration(propertiesReader);
    }

    private void setSelenideConfiguration(PropertyReader propertiesReader) {
        Map<String, String> properties = new HashMap<>();
        Arrays.asList(propertiesReader.getProperties().getProperty("selenide.configs").split(":")).forEach(property -> {
            if (!property.isEmpty()) properties.put(property.split("=")[0], property.split("=")[1]);
        });
        properties.forEach((property, value) -> {
            Configuration.browserSize = property.equals("browserSize") ? value : Configuration.browserSize;
            Configuration.headless = property.equals("headless") ? Boolean.parseBoolean(value) : Configuration.headless;
            Configuration.baseUrl = property.equals("baseUrl") ? value : Configuration.baseUrl;
            Configuration.timeout = property.equals("timeout") ? Long.parseLong( value) : Configuration.timeout;
            Configuration.pageLoadTimeout = property.equals("pageLoadTimeout") ? Long.parseLong( value) : Configuration.pageLoadTimeout;
        });
    }
}
