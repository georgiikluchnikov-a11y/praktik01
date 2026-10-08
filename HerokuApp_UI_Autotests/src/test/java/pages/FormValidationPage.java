package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormValidationPage extends BasePage {

    private final By contactName = By.id("validationCustom01");
    private final By contactNumber = By.cssSelector("input[name='contactnumber']");
    private final By pickupDate = By.cssSelector("input[name='pickupdate']");
    private final By payment = By.cssSelector("select[name='payment']");
    private final By submitButton = By.cssSelector("form button[type='submit']");

    public FormValidationPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactName(String value) {
        type(contactName, value);
    }

    public void fillContactNumber(String value) {
        type(contactNumber, value);
    }

    public void fillPickupDate(String value) {
        type(pickupDate, value);
    }

    public void selectPayment(String value) {
        new Select(visible(payment)).selectByValue(value);
    }

    public void submit() {
        click(submitButton);
    }

    /** Заполняет форму корректными данными и отправляет её. */
    public void submitValidForm(String name, String number, String date, String paymentValue) {
        fillContactName(name);
        fillContactNumber(number);
        fillPickupDate(date);
        selectPayment(paymentValue);
        submit();
    }

    /** Проверка средствами браузера: валидно ли поле. */
    public boolean isValid(By field) {
        return (Boolean) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].checkValidity();", visible(field));
    }

    public boolean isContactNumberValid() {
        return isValid(contactNumber);
    }
}
