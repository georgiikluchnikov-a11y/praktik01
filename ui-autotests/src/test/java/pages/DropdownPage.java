package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By simpleDropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    /** Простой выпадающий список: "Please select an option", "Option 1", "Option 2". */
    public Select simpleDropdown() {
        return new Select(visible(simpleDropdown));
    }

    public void selectOption(String visibleText) {
        simpleDropdown().selectByVisibleText(visibleText);
    }

    public String selectedOptionText() {
        return simpleDropdown().getFirstSelectedOption().getText();
    }
}
