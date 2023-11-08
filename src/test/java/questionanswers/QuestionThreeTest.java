package questionanswers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class QuestionThreeTest {

    private questionThree tester;

    @BeforeClass
    public void setUp() {
        tester = new questionThree();
        tester.navigateTo("https://www.automationanywhere.com/");
        tester.acceptCookiesIfPresent();
    }

    @Test(priority = 1, enabled = true, timeOut = 30000)
    public void testLogoPresence() {
        assertTrue("Automation Anywhere logo should be present", tester.isLogoPresent());
    }

    @Test(priority = 1, enabled = true, timeOut = 30000)
    public void testRequestDemoButtonPresenceAndClickability() {
        boolean[] results = tester.isRequestDemoButtonPresentAndClickable();
        assertTrue("Request demo button should be present", results[0]);
        assertTrue("Request demo button should be clickable", results[1]);
    }

    @AfterClass
    public void tearDown() {
        tester.closeBrowser();
    }
}
