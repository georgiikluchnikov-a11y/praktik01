package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagesPage;

public class NotificationMessagesTest extends TestBase {

    @Test
    public void notificationAppearsAfterClick() {
        open("/notification-message");
        NotificationMessagesPage page = new NotificationMessagesPage(driver);

        page.clickHere();
        String text = page.notificationText();

        Assert.assertTrue(
                text.contains("Action successful") || text.contains("Action unsuccessful"),
                "Неожиданное уведомление: " + text
        );
    }
}
