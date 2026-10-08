package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    private final By addButton = By.xpath("//button[normalize-space()='Add Element']");
    private final By addedElements = By.cssSelector("#elements .added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void addElement() {
        click(addButton);
    }

    public int elementCount() {
        return driver.findElements(addedElements).size();
    }

    public List<WebElement> elements() {
        return driver.findElements(addedElements);
    }

    /** Удаляет последний добавленный элемент. */
    public void deleteLastElement() {
        List<WebElement> elements = elements();
        if (!elements.isEmpty()) {
            elements.get(elements.size() - 1).click();
        }
    }
}
