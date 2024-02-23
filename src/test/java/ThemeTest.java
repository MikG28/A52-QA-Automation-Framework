import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest {

    @Test
    public void changeThemeTest() {
        String themeName = "Classic";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        HomePage homePage = new HomePage(driver);
        homePage.getAvatar().click();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.chooseThemByName(themeName);
        Assert.assertTrue(profilePage.isThemeSelected(themeName));
    }
}
