package ru.korobovs.project;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        driver = ProjectUtils.createDriver();
        return driver;
    }

    private void startDriver() {
        ProjectUtils.log("Браузер открыт");

        driver = getDriver();
    }

    private void getWeb() {
        ProjectUtils.log("Страница открыта");

        ProjectUtils.get(driver);
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        ProjectUtils.logf("Запускается %s.%s", this.getClass().getName(), method.getName());
        try {
            startDriver();
            getWeb();
        } catch (Exception e) {
            closeDriver();
        }
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        closeDriver();

        ProjectUtils.logf("Время выполнения %.3f sec", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0);
    }

    protected void closeDriver() {
        if (driver != null) {
            driver.quit();

            ProjectUtils.log("Браузер закрыт");
        }
    }
}
