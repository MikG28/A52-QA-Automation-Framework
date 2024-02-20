import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.WaitUtils.waitUntilVisibilityOfElementLocatedBy;

public class DeletePlayListTest extends BaseTest {

    LoginPage loginPage = null;
    HomePage homePage = null;

    @Test
    public void deletePlayListTest() throws InterruptedException {
        String playListName = "TestPlayListForDeleting";
        loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        homePage = new HomePage(driver);

        homePage.createPlaylist(actions, playListName);
        homePage.openPlayList(playListName);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.deletePlayList(wait);
        waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"));
        Assert.assertTrue(homePage.getPlaylistByName(playListName).isDisplayed());
    }

    @Test
    public void addPlayListTest() throws InterruptedException {
        String playListName = "TestPlayListForDeleting";
        loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        homePage = new HomePage(driver);
        int previousSize = homePage.getAllPlayLists().size();
        homePage.createPlayList(playListName);
        int actualSize = homePage.getAllPlayLists().size();
        Assert.assertNotEquals(actualSize, previousSize); // previousSize != actualSize
    }
}
