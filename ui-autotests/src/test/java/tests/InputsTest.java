package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends TestBase {

    @Test
    public void fillInputsUseArrowsAndDisplayValues() {
        open("/inputs");
        InputsPage page = new InputsPage(driver);

        page.enterNumber("12345");
        Assert.assertEquals(page.numberValue(), "12345");

        page.pressArrowUp();
        Assert.assertEquals(page.numberValue(), "12346");

        page.pressArrowDown();
        Assert.assertEquals(page.numberValue(), "12345");

        page.enterText("Selenium");
        page.enterPassword("secret");
        Assert.assertEquals(page.textValue(), "Selenium");
        Assert.assertEquals(page.passwordValue(), "secret");

        String result = page.displayInputs();
        Assert.assertTrue(result.contains("12345"), "В результате должно быть число: " + result);
        Assert.assertTrue(result.contains("Selenium"), "В результате должен быть текст: " + result);

        page.clearInputs();
        Assert.assertEquals(page.numberValue(), "", "Числовое поле должно очищаться");
        Assert.assertEquals(page.textValue(), "", "Текстовое поле должно очищаться");

        page.enterNumber("abc");
        Assert.assertEquals(page.numberValue(), "", "В поле типа number не должно попадать нецифровое значение");
    }
}
