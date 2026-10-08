package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    @Test
    public void changeStateOfBothCheckboxes() {
        open("/checkboxes");
        CheckboxesPage page = new CheckboxesPage(driver);

        Assert.assertFalse(page.checkbox1().isSelected(), "Checkbox 1 должен быть снят");
        page.checkbox1().click();
        Assert.assertTrue(page.checkbox1().isSelected(), "Checkbox 1 должен быть установлен после клика");

        Assert.assertTrue(page.checkbox2().isSelected(), "Checkbox 2 должен быть установлен");
        page.checkbox2().click();
        Assert.assertFalse(page.checkbox2().isSelected(), "Checkbox 2 должен быть снят после клика");
    }
}
