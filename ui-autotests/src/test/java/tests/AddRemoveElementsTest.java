package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {

    @Test
    public void addTwoElementsAndDeleteOne() {
        open("/add-remove-elements");
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);

        Assert.assertEquals(page.elementCount(), 0, "Список элементов должен быть пустым");

        page.addElement();
        page.addElement();
        Assert.assertEquals(page.elementCount(), 2, "После двух кликов должно быть два элемента");

        page.deleteLastElement();
        Assert.assertEquals(page.elementCount(), 1, "После удаления должен остаться один элемент");
    }
}
