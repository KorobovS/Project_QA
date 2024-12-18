package ru.korobovs.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ProjectUtils {

    static final ChromeOptions chromeOptions = new ChromeOptions();

    static WebDriver createDriver() {

        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--lang=en");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    public static void get(WebDriver driver) {
        driver.get("https://duckduckgo.com/");
    }

    public static void log(String str) {
        System.out.println(str);
    }

    public static void logf(String str, Object... arr) {
        log(String.format(str, arr));
    }
}
