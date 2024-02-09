import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest {

    @Test
    public void playSongTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement favoritePlayListLink = driver.findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
        WebElement song =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='favoritesWrapper']//td[text()='Riqui-Riqui']")));
        song.click();
        song.sendKeys(Keys.ENTER);
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}
