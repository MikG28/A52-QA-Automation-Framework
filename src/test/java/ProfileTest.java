import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test(groups = "Smoke")
    public void changeProfileNameTest() throws InterruptedException {
        String newName = UUID.randomUUID().toString();
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        avatar.click();
        WebElement currentPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currentPasswordField.sendKeys("te$t$tudent");
        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.clear();
        nameInput.sendKeys(newName);
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
        Thread.sleep(3000);
        WebElement userNameLabel = driver.findElement(By.cssSelector("#userBadge span[class=name]"));
        Assert.assertEquals(newName, userNameLabel.getText());
    }
}
