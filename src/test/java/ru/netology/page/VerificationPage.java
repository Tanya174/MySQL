package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void verifyVerificationPage() {
        codeField.shouldBe(visible);
    }
    public void verifyErrorNotification() {
        errorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page (DashboardPage.class);
    }
    public void verify(String verificationCode){
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
