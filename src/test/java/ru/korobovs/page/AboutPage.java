package ru.korobovs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.korobovs.project.BasePage;

public class AboutPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement title;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        return title.getText();
    }
}
