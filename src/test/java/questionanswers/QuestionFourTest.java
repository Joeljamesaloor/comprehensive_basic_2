package questionanswers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class QuestionFourTest {

    private WebDriver driver;
    private questionFour questionFour;
    private Map<String, String> expectedURLs;

    @BeforeClass
    public void setUp() {
        questionFour = new questionFour(); // Assuming this initializes the WebDriver
        driver = questionFour.getDriver(); // Assuming there's a method to get the driver from QuestionFour

        // Initialize expected URLs
        expectedURLs = new HashMap<>();
        expectedURLs.put("Products", "https://www.automationanywhere.com/products");
        expectedURLs.put("Solutions", "https://www.automationanywhere.com/solutions");
        expectedURLs.put("Resources", "https://www.automationanywhere.com/resources");
        expectedURLs.put("Beyond RPA", "https://www.automationanywhere.com/rpa/robotic-process-automation");
        expectedURLs.put("Company", "https://www.automationanywhere.com/company/about-us");

        // Navigate to the initial page
        questionFour.navigateTo("https://www.automationanywhere.com/");
        questionFour.acceptCookiesIfPresent();
    }

    @Test(priority = 2, enabled = true, timeOut = 300000)
    public void testLinkNavigation() throws InterruptedException {
        for (Map.Entry<String, String> entry : expectedURLs.entrySet()) {
            String linkName = entry.getKey();
            String expectedUrl = entry.getValue();

            // Perform the click and verify the URL, assuming these methods are implemented in QuestionFour
            Assert.assertTrue(questionFour.clickLinkAndVerifyURL(linkName, expectedUrl),
                    "Failed to navigate to the correct page for link: " + linkName);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            questionFour.closeBrowser();
        }
    }
}
