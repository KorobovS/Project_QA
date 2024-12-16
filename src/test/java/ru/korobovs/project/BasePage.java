package ru.korobovs.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public WebDriver driver;

    protected WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        driver = ProjectUtils.createDriver();
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
