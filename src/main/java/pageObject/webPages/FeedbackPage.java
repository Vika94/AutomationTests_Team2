package pageObject.webPages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.openqa.selenium.By.xpath;

public class FeedbackPage extends BasketPage {
    SelenideElement feedback = $("[class='button button_green button_small offers-description__button']");
    SelenideElement uploadBtn = $( "input[class='drop-style__link-real']");
    SelenideElement fileUploaded = $("[class='drop-style__upload-item drop-style__upload-item_primary js-move']");
    SelenideElement notebookBtn = $(xpath("//span[contains(text(), 'Описание и фото')]"));

    public FeedbackPage moveToFeedback() {
        feedback.click();
        return this;
    }
    public FeedbackPage uploadFile() throws InterruptedException {
        feedback.shouldBe(exist);
        actions().moveToElement(uploadBtn).perform();
        File M8AetwJrpJ = new File("src/test/resources/M8AetwJrpJ.jpg");
        uploadBtn.uploadFile(M8AetwJrpJ);
        fileUploaded.shouldBe(exist);
        return this;
    }
    public FeedbackPage moveToNotebookPage() {
        actions().moveToElement(notebookBtn).perform();
        notebookBtn.click();
        return this;
    }
}
