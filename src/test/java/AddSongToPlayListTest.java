import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void
    addSongToPlayListTest() throws InterruptedException {
        LoginPage page = new LoginPage(driver);
        String songName = "Riqui-Riqui";
        page.login("demo@class.com", "te$t$tudent");
        WebElement searchInput = driver.findElement(By.cssSelector("#searchForm>input"));
        searchInput.sendKeys(songName);
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement likeButton = driver.findElement(By.xpath("//section[@id='searchExcerptsWrapper']//button[contains(@title, 'Riqui-Riqui')]/i[@data-test='btn-like-unliked']"));
        likeButton.click();
        WebElement favoritePlayListLink = driver.findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
        String favoriteSong = "//section[@id='favoritesWrapper']//td[contains(text(), '%s')]";
        WebElement favoriteSongElement = driver.findElement(By.xpath(String.format(favoriteSong, songName)));
        Assert.assertTrue(favoriteSongElement.isDisplayed());
    }
}
