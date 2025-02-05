package ru.korobovs.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.korobovs.project.BaseTest;
import ru.korobovs.page.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testTitle() {

        String title = new HomePage(getDriver())
                .getTitle();

        Assert.assertEquals(title, "Switch to DuckDuckGo. It’s private and free!");
        //Assert.assertEquals(title, "Switch to DuckDuckGo.");
    }

    @Test
    public void testUrlAboutPage() {
        String title = new HomePage(getDriver())
                .clickLogo()
                .getTitle();

        Assert.assertEquals(title, "Your personal data is\nnobody's business.");
    }
}
