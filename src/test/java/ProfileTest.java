import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test(groups = "Smoke")
    public void changeProfileNameTest() {
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
        WebElement userNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge span[class=name]")));
        Assert.assertEquals(newName, userNameLabel.getText());
    }
}
