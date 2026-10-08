package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortableDataTablesPage extends BasePage {

    private final String table1Cell = "//table[@id='table1']/tbody/tr[%d]/td[%d]";

    public SortableDataTablesPage(WebDriver driver) {
        super(driver);
    }

    /** Текст ячейки первой таблицы. Нумерация строк и столбцов начинается с 1. */
    public String cell(int row, int column) {
        return textOf(By.xpath(String.format(table1Cell, row, column)));
    }

    public int rowCount() {
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
    }
}
