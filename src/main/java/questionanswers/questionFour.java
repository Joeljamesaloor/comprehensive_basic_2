package questionanswers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class questionFour {
    private WebDriver driver;
    private WebDriverWait wait;
    private Map<String, By> links;

    public questionFour() {
        // Setting up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, 10);

        // Initialize the links map
        links = new HashMap<>();
        links.put("Products", By.xpath("//a[text()='Products']"));
        links.put("Solutions", By.xpath("//a[text()='Solutions']"));
        links.put("Resources", By.xpath("//a[text()='Resources']"));
        links.put("Beyond RPA", By.xpath("//a[contains(text(),'Beyond RPA')]"));
        links.put("Company", By.xpath("//a[text()='Company']"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie alert not found or not clickable.");
        }
    }

    public boolean clickLinkAndVerifyURL(String linkName, String expectedUrl) throws InterruptedException {
        try {
            WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(links.get(linkName)));
            linkElement.click();

            // Wait for navigation and page load
            Thread.sleep(5000); // Note: Using Thread.sleep is not recommended, consider using WebDriverWait

            return driver.getCurrentUrl().equals(expectedUrl);
        } catch (Exception e) {
            System.out.println("Error clicking on link '" + linkName + "': " + e.getMessage());
            return false;
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
