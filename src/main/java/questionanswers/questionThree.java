package questionanswers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class questionThree {

    private WebDriver driver;
    private WebDriverWait wait;

    public questionThree() {
        // Setting up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
            System.out.println("Cookie alert not found");
        }
    }

    public boolean isLogoPresent() {
        By logoXPath = By.xpath("//div[@class='coh-container nav-logo-wrap']//a[@class='coh-link header-logo']/img[@alt='Automation Anywhere']");
        return driver.findElement(logoXPath).isDisplayed();
    }

    public boolean[] isRequestDemoButtonPresentAndClickable() {
        By requestDemoBtnXPath = By.xpath("//a[@class='coh-link coh-style-solid-orange-button btn-link' and @title='Request demo']");
        WebElement requestDemoBtn = driver.findElement(requestDemoBtnXPath);
        return new boolean[]{requestDemoBtn.isDisplayed(), requestDemoBtn.isEnabled()};
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
