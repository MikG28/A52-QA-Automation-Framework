+ import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
+ import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testing.Assert;

public class LoginTests exntends BaseTest {
@Test
public void loginEmptyEmailPassword()
    public void login() {

ChromeOptions options = new ChromeOptions();

String url = "https://qa. koel.app/";
driver-get(url):
        Assert.assertEquals(driver.getCurrentUrl), url):
WebElement emailInput = driver.findElement(By.cssSelector("[type='email']")):
WebElement passwordInput = driver. findElement (By.cssSelector (" [type='password']")):
WebElement loginButton = driver. findElement(By-cssSelector("[type=' submit']"));
emailInput. sendKeys ("demo@class.com") ; passwordInput. sendKeys ("te$t$tudent"); loginButton.clickO;
WebElement avatar = driver.findElement(By.cssSelector ("#userBadge img")) :Assert.assertTrue(avatar.isDisplayed)):

@Test
public void loginWithEmptyCredentials() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments ("—remote-allow-origins=*");
    WebDriver driver = new ChromeDriver (options) ;
    driver-manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
    String url = "https://qa. koel.app/";
    driver.get(url);
    WebElement logo = driver.findElement(By. cssSelector (". logo*)) ; WebElement emailInput = driver. findElement(By.cssSelector (" [type='email']")):
    WebElement loginButton = driver. findElement (By-cssSelector (" [type='submit ']"));
    emailInput. sendKeys ("demo@class.com"); loginButton.click():
    Assert.assertTrue(logo. isDisplayed());driver.quit();

        }
    }