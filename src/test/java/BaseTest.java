import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;
    protected WebDriverWait wait = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters("baseUrl")
    public void setUpDriver(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String url = "https://qa.koel.app/";
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}