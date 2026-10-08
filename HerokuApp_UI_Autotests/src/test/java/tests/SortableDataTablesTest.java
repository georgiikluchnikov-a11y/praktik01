package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SortableDataTablesPage;

public class SortableDataTablesTest extends TestBase {

    @Test
    public void verifyTableCells() {
        open("/tables");
        SortableDataTablesPage page = new SortableDataTablesPage(driver);

        Assert.assertEquals(page.rowCount(), 4, "В первой таблице должно быть четыре строки");

        Assert.assertEquals(page.cell(1, 1), "Smith");
        Assert.assertEquals(page.cell(1, 2), "John");
        Assert.assertEquals(page.cell(1, 3), "jsmith@gmail.com");
        Assert.assertEquals(page.cell(1, 4), "$50.00");

        Assert.assertEquals(page.cell(2, 1), "Bach");
        Assert.assertEquals(page.cell(2, 2), "Frank");
        Assert.assertEquals(page.cell(3, 1), "Doe");
    }
}
