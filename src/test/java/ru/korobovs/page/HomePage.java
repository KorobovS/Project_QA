package ru.korobovs.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.korobovs.project.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[@class='homepage-cta-section_title__Lovig heading_heading2__oEFPn heading_heading__IiMSV']")
    private WebElement title;

    @FindBy(xpath = "//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW']/a")
    private WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public AboutPage clickLogo() {
        logo.click();

        return new AboutPage(getDriver());
    }
}
