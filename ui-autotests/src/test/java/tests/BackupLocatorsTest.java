package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Проверка устойчивости локаторов: те же элементы находятся CSS-селекторами,
 * а не только через By.id/By.xpath. Если разметка страницы изменится так, что
 * один из вариантов перестанет работать, эти тесты это покажут.
 */
public class BackupLocatorsTest extends TestBase {

    @Test(description = "Checkboxes: CSS-селектор находит те же два чекбокса")
    public void checkboxesFoundByCss() {
        open("/checkboxes");

        Assert.assertEquals(driver.findElements(By.cssSelector("input[type=checkbox]")).size(), 2);
        Assert.assertFalse(driver.findElement(By.cssSelector("#checkbox1")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkbox2")).isSelected());
    }

    @Test(description = "Dropdown: CSS-селектор select#dropdown и состав списка")
    public void dropdownFoundByCss() {
        open("/dropdown");

        Select select = new Select(wait.until(d -> d.findElement(By.cssSelector("select#dropdown"))));
        Assert.assertEquals(select.getOptions().size(), 3);
        Assert.assertEquals(select.getOptions().get(1).getText(), "Option 1");
    }

    @Test(description = "Inputs: CSS-селектор input#input-number принимает значение")
    public void inputsFoundByCss() {
        open("/inputs");

        WebElement number = wait.until(d -> d.findElement(By.cssSelector("input#input-number")));
        number.sendKeys("321");
        Assert.assertEquals(number.getAttribute("value"), "321");
    }

    @Test(description = "Tables: ячейка находится CSS-селектором по строке и столбцу")
    public void tablesFoundByCss() {
        open("/tables");

        String firstCell = wait.until(d -> d.findElement(
                By.cssSelector("#table1 tbody tr:nth-child(1) td:nth-child(1)"))).getText();
        Assert.assertEquals(firstCell, "Smith");
    }

    @Test(description = "Add/Remove Elements: кнопка и добавленный элемент находятся CSS-селекторами")
    public void addRemoveFoundByCss() {
        open("/add-remove-elements");

        wait.until(d -> d.findElement(By.cssSelector("button[onclick='addElement()']"))).click();
        Assert.assertEquals(driver.findElements(By.cssSelector("#elements .added-manually")).size(), 1);
    }

    @Test(description = "Hovers: карточки профилей находятся CSS-селекторами")
    public void hoversFoundByCss() {
        open("/hovers");

        wait.until(d -> d.findElements(By.cssSelector("div.figure")).size() >= 3);
        Assert.assertEquals(driver.findElements(By.cssSelector("div.figure")).size(), 3);
    }

    @Test(description = "Notification Messages: ссылка и уведомление находятся CSS-селекторами")
    public void notificationFoundByCss() {
        open("/notification-message");

        wait.until(d -> d.findElement(By.cssSelector("#core a"))).click();
        String text = wait.until(d -> d.findElement(By.cssSelector("#flash"))).getText();

        Assert.assertTrue(text.contains("Action successful") || text.contains("Action unsuccessful"),
                "Неожиданное уведомление: " + text);
    }

    @Test(description = "Form Validation: поля формы находятся CSS-селекторами по name")
    public void formValidationFoundByCss() {
        open("/form-validation");

        WebElement contactName = wait.until(d -> d.findElement(By.cssSelector("input[name='ContactName']")));
        contactName.clear();
        contactName.sendKeys("Ivan Petrov");
        Assert.assertEquals(contactName.getAttribute("value"), "Ivan Petrov");

        WebElement contactNumber = driver.findElement(By.cssSelector("input[name='contactnumber']"));
        contactNumber.clear();
        contactNumber.sendKeys("123-4567890");
        Assert.assertTrue(contactNumber.getAttribute("value").matches("[0-9]{3}-[0-9]{7}"));
    }
}
