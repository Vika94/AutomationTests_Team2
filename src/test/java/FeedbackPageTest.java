import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.FeedbackPage;
import pageObject.NotebookPage;

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
