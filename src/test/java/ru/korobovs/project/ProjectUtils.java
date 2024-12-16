package ru.korobovs.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ProjectUtils {

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(new ChromeOptions());
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
