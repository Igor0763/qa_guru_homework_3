package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBases {

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    @Tag("demoQaTest")
    void fillFormTest() {
        step("Form filling", () -> {
            registrationPage.openPage()
                    .setFirstName("Nikita")
                    .setLastName("Malinin")
                    .setEmail("Malinin@true.re")
                    .setGender("Other")
                    .setPhone("1234567891")
                    .setOfBirthInput("05", "May", "1920")
                    .setSubjects("English")
                    .setHobbies("Sports")
                    .setFile("panda.jpg")
                    .setCurrentAddress("city:Big, street:long")
                    .setState("Haryana")
                    .setCity("Karnal")
                    .submit();
        });
        step("Verification of the completed form", () -> {
            resultComponent.checkResult("Student Name", "Nikita Malinin")
                    .checkResult("Student Email", "Malinin@true.re")
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", "1234567891")
                    .checkResult("Date of Birth", "05 May,1920")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "panda.jpg")
                    .checkResult("Address", "city:Big, street:long")
                    .checkResult("State and City", "Haryana Karnal");
        });

    }

    @Test
    void requiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Malinin")
                .setGender("Other")
                .setPhone("1234567891")
                .submit();

        resultComponent.checkResult("Student Name", "Nikita Malinin")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567891");
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Malinin")
                .setPhone("1234567891")
                .submit();

        resultComponent.negativeResult()
                .negativeResult();
    }

}