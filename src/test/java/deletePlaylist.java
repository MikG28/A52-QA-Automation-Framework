import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deletePlaylist {
}
@Test
public void deletePlayListTest()
@Parameters
        
login("demo@class.com", "te$t$tudent");
WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertFalse(avatar.isDisplayed()); // true
        }

@Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
public void loginWithEmptyCredentials(String email, String password) {
    WebElement logo = driver.findElement(By.cssSelector(".logo"));
    login(email, password);
    Assert.assertTrue(logo.isDisplayed());


}
}

