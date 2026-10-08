package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePage {

    private final By checkbox1 = By.id("checkbox1");
    private final By checkbox2 = By.id("checkbox2");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkbox1() {
        return visible(checkbox1);
    }

    public WebElement checkbox2() {
        return visible(checkbox2);
    }
}
