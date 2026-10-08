package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormValidationPage;

import java.time.LocalDate;

public class FormValidationTest extends TestBase {

    private static final String VALID_PHONE = "123-4567890";
    private static final String PAYMENT_CARD = "card";

    @Test
    public void validFormIsSubmitted() {
        open("/form-validation");
        FormValidationPage page = new FormValidationPage(driver);

        String pickupDate = LocalDate.now().plusDays(1).toString();
        page.submitValidForm("Иван Петров", VALID_PHONE, pickupDate, PAYMENT_CARD);

        wait.until(d -> d.getCurrentUrl().contains("form-confirmation"));
        Assert.assertTrue(driver.getPageSource().contains("Thank you for validating your ticket"),
                "После отправки формы должно появиться подтверждение");
    }

    @Test
    public void phoneNumberFailsValidationForWrongFormat() {
        open("/form-validation");
        FormValidationPage page = new FormValidationPage(driver);

        page.fillContactName("Иван Петров");
        page.fillContactNumber("12345");
        page.fillPickupDate(LocalDate.now().plusDays(1).toString());
        page.selectPayment(PAYMENT_CARD);
        page.submit();

        Assert.assertFalse(page.isContactNumberValid(),
                "Телефон вида 12345 не соответствует шаблону 123-4567890");
        Assert.assertFalse(driver.getCurrentUrl().contains("form-confirmation"),
                "Форма с некорректным телефоном не должна отправляться");
    }
}
