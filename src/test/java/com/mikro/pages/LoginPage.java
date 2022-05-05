package com.mikro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    //driver.findElement=@FindBy
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsStoreMannager() {

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storesmanager_password");


        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsDriver() {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");


        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }
}
