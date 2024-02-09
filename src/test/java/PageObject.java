public class PageObject {
}

package org.example.pages;

import org.example.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    WebDriver pageDriver = null;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    WebElement successMessageLocator;

    public BasePage(WebDriver existDriver) {
        this.pageDriver = existDriver;
        // add for finding all @FindBy
        PageFactory.initElements(pageDriver, this);
    }

    public WebElement findElement(By locator) {
        return pageDriver.findElement(locator);
    }

    public WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClickByElement(WebElement element) {
        Actions actions = new Actions(pageDriver);
        actions.contextClick(element).perform();
    }

    public WebElement getSuccessMessage() {
        return successMessageLocator;
    }

    public void waitUntilSuccessMessageIsDisappear() {
        WaitUtils.waitUntilInvisibilityOfElement(pageDriver, getSuccessMessage());
    }
}

package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#userBadge img")
    WebElement avatar;
    @FindBy(css = "#playlists i[role='button']")
    WebElement addPlayListButton;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement createPlayListButton;
    @FindBy(css = "[name='create-simple-playlist-form']>input")
    WebElement playListNameInput;
    String playListLocator = "//section[@id='playlists']//li/a[text()='%s']";
    @FindBy(xpath = "//li[contains(@data-testid, 'playlist-context-menu-edit')]")
    WebElement editButton;
    @FindBy(xpath = "//ul/li//input[@type='text']")
    WebElement renamePlaylistInput;
    @FindBy(css = "#playlists li")
    List<WebElement> playLists;

    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getAddPlaylistButton() {
        return addPlayListButton;
    }

    public WebElement getCreatePlaylistButton() {
        return createPlayListButton;
    }

    public WebElement getPlaylistNameInput() {
        return playListNameInput;
    }

    public void createPlaylist(Actions actions,String playlistName) throws InterruptedException {
        actions.moveToElement(getAddPlaylistButton()).perform();
        getAddPlaylistButton().click();
        Thread.sleep(3000);
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(playlistName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);
    }

    public WebElement getPlaylistByName(String playlistName) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s']", playlistName)));
    }

    public void openPlayList(String playlistName) {
        getPlaylistByName(playlistName).click();
    }

    public WebElement getPlayListByName(String playListName) {
        return waitAndFindWebElement(By.xpath(String.format(playListLocator, playListName)));
    }

    public void renamePlayList(String currentPlayListName, String newPlayListName) throws InterruptedException {
        contextClickByElement(getPlayListByName(currentPlayListName));
        Thread.sleep(3000);
        editButton.click();
        for (int i = 0; i < currentPlayListName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        getSuccessMessage();
    }

    public List<WebElement> getAllPlayLists() {
        return playLists;
    }

    public void createPlayList(String playListName) throws InterruptedException {
        Thread.sleep(3000);
        getAddPlaylistButton().click();
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(playListName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);
        waitUntilSuccessMessageIsDisappear();
    }
}

package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='email']")
    WebElement emailInput;
    @FindBy(css = "[type='password']")
    WebElement passwordInput;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;
    @FindBy(css = ".logo")
    WebElement logo;

    public LoginPage(WebDriver existDriver) {
        super(existDriver);
    }

    public void login(String email, String password) {
        provideEmail(email).providePassword(password).clickSubmit();
    }

    private LoginPage provideEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    private LoginPage providePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private void clickSubmit() {
        loginButton.click();
    }

    public WebElement getLogo() {
        return logo;
    }
}

package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'btn-delete-playlist')]")
    WebElement deleteButton;


    public PlaylistPage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getDeletePlaylistButton() {
        return deleteButton;
    }

    public void deletePlayList(WebDriverWait wait) {
        getDeletePlaylistButton().click();
    }
}
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-testid, 'theme-card')]")
    List<WebElement> themes;

    public ProfilePage(WebDriver existDriver) {
        super(existDriver);
    }

    public List<WebElement> getAllThemes() {
        return themes;
    }

    public void chooseThemByName(String themeName) {
        for (WebElement element : getAllThemes()) {
            if (element.getText().equals(themeName)) {
                element.click();
            }
        }
    }

    public boolean isThemeSelected(String themeName) {
        for (WebElement element: getAllThemes()) {
            if (element.getAttribute("class").contains("selected")) {
                return true;
            }
        }
        return false;
    }