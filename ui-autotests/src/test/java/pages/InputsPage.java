package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputsPage extends BasePage {

    private final By numberInput = By.id("input-number");
    private final By textInput = By.id("input-text");
    private final By passwordInput = By.id("input-password");
    private final By dateInput = By.id("input-date");
    private final By displayButton = By.id("btn-display-inputs");
    private final By clearButton = By.id("btn-clear-inputs");
    private final By result = By.id("result");

    public InputsPage(WebDriver driver) {
        super(driver);
    }

    public void enterNumber(String value) {
        type(numberInput, value);
    }

    public void enterText(String value) {
        type(textInput, value);
    }

    public void enterPassword(String value) {
        type(passwordInput, value);
    }

    public void enterDate(String value) {
        type(dateInput, value);
    }

    public String numberValue() {
        return visible(numberInput).getAttribute("value");
    }

    public String textValue() {
        return visible(textInput).getAttribute("value");
    }

    public String passwordValue() {
        return visible(passwordInput).getAttribute("value");
    }

    public String dateValue() {
        return visible(dateInput).getAttribute("value");
    }

    public void pressArrowUp() {
        visible(numberInput).sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        visible(numberInput).sendKeys(Keys.ARROW_DOWN);
    }

    /** Нажимает "Display Inputs" и возвращает показанный блоком результат текст. */
    public String displayInputs() {
        click(displayButton);
        return textOf(result);
    }

    public void clearInputs() {
        click(clearButton);
    }
}
