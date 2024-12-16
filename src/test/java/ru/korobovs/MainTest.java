package ru.korobovs;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.korobovs.project.BaseTest;
import ru.korobovs.page.MainPage;

public class MainTest extends BaseTest {

    @Test
    public void testTitle() {
        String title = new MainPage(getDriver())
                .getTitle();

        Assert.assertEquals(title, "Переходите на DuckDuckGo. Бесплатно и надежно.");
    }
}
