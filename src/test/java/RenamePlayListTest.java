import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RenamePlayListTest extends BaseTest {
    String newPlayListName = "New playlist";
    String currentPlayListName = "TestPro Playlist";
    HomePage homePage = null;

    @Test
    public void renamePlayListTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        homePage = new HomePage(driver);
        homePage.renamePlayList(currentPlayListName, newPlayListName);

        Assert.assertEquals(newPlayListName, homePage.getPlayListByName(newPlayListName).getText());
        //Assert.assertTrue(homePage.getPlaylistByName(newPlayListName).isDisplayed());
    }

    @AfterMethod
    public void rollBackChanges() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.renamePlayList(newPlayListName, currentPlayListName);
    }
}
