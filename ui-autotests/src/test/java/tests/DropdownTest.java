package tests;

import base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends TestBase {

    @Test
    public void selectOptionsFromSimpleDropdown() {
        open("/dropdown");
        DropdownPage page = new DropdownPage(driver);
        Select dropdown = page.simpleDropdown();

        Assert.assertEquals(dropdown.getOptions().size(), 3, "В простом списке должно быть три пункта");
        Assert.assertEquals(dropdown.getOptions().get(0).getText(), "Please select an option");
        Assert.assertEquals(dropdown.getOptions().get(1).getText(), "Option 1");
        Assert.assertEquals(dropdown.getOptions().get(2).getText(), "Option 2");

        page.selectOption("Option 1");
        Assert.assertEquals(page.selectedOptionText(), "Option 1");

        page.selectOption("Option 2");
        Assert.assertEquals(page.selectedOptionText(), "Option 2");
    }
}
