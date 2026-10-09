package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends BasePage {

    private final By figures = By.cssSelector(".figure");
    private final By caption = By.cssSelector(".figcaption h5");
    private final By profileLink = By.cssSelector(".figcaption a");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> figures() {
        wait.until(d -> d.findElements(figures).size() >= 3);
        return driver.findElements(figures);
    }

    public int figureCount() {
        return figures().size();
    }

    /** Наводит курсор на карточку профиля и возвращает текст подписи. */
    public String hoverAndGetName(WebElement figure) {
        new Actions(driver).moveToElement(figure).perform();
        wait.until(d -> figure.findElement(caption).isDisplayed());
        return figure.findElement(caption).getText();
    }

    public void openProfile(WebElement figure) {
        new Actions(driver).moveToElement(figure).perform();
        figure.findElement(profileLink).click();
    }
}
