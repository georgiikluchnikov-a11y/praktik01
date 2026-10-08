package tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

import java.util.List;

public class HoversTest extends TestBase {

    @Test
    public void hoverEachUserAndOpenProfile() {
        open("/hovers");
        HoversPage page = new HoversPage(driver);

        Assert.assertEquals(page.figureCount(), 3, "На странице должно быть три профиля");

        for (int i = 1; i <= 3; i++) {
            List<WebElement> figures = page.figures();
            WebElement figure = figures.get(i - 1);
            String expectedProfileUrl = "/users/" + i;

            String caption = page.hoverAndGetName(figure);
            Assert.assertTrue(caption.startsWith("name: user"),
                    "Неожиданная подпись профиля: " + caption);

            page.openProfile(figure);
            wait.until(d -> d.getCurrentUrl().contains(expectedProfileUrl));
            Assert.assertFalse(driver.getPageSource().contains("Not Found"),
                    "Страница профиля не должна возвращать 404");

            driver.navigate().back();
            wait.until(d -> d.getCurrentUrl().contains("/hovers"));
        }
    }
}
