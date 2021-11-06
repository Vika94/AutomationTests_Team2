import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.webPages.FeedbackPage;
import pageObject.webPages.NotebookPage;

public class FeedbackPageTest extends BaseTest {
    @Test
    public void uploadFileTest() throws InterruptedException {
        get(NotebookPage.class)
                .checkProductTitle();
        get(FeedbackPage.class)
                .moveToFeedback()
                .uploadFile()
                .moveToNotebookPage();
    }
}
