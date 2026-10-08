package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagesPage extends BasePage {

    private final By clickHereLink = By.linkText("Click here");
    private final By flash = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        super(driver);
    }

    public void clickHere() {
        click(clickHereLink);
    }

    public String notificationText() {
        return visible(flash).getText();
    }
}
