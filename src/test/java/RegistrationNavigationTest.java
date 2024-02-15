import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationNavigationTest extends BaseTest {

    @Test(groups = "Smoke")
    public void registrationNavigationTest() {
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();
        WebElement registrationText = driver.findElement(By.xpath("//h2[contains(text(), 'Register new account or')]"));
        Assert.assertTrue(registrationText.isDisplayed());
        closeBrowser();
    }
}
