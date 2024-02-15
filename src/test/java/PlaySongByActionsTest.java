import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongByActionsTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void playSongByContextClickTest() {
        String songLocator = "//section[@id='songsWrapper']//td[text()='%s']";
        String songName = "M33 Project - Emotional Soundtrack";
        loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        WebElement allSongsMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sidebar'] .songs")));
        allSongsMenuItem.click();
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(songLocator, songName))));
        actions.contextClick(song).perform();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ data-testid='song-context-menu'] .playback")));
        playButton.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    @Test
    public void playSongByHoverMouseTest() {
        loginPage.login("demo@class.com", "te$t$tudent");
        WebElement allSongsMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sidebar'] .songs")));
        allSongsMenuItem.click();
        WebElement mediaPlayer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .play")));
        actions.moveToElement(mediaPlayer).click().perform();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .play i")));
        playButton.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}
