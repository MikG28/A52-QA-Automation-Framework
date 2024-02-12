import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = null;

    @Test(description = "Check if user login with correct credentials", priority = 1, groups = "Smoke")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.getAvatar().isDisplayed()); // true
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginWithEmptyCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }
}
