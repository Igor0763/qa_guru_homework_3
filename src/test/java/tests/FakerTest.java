package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

public class FakerTest extends TestBases {

    TestData data = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setPhone(data.phone)
                .setOfBirthInput(data.day, data.month, data.year)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .setFile(data.file)
                .setCurrentAddress(data.currentAddress)
                .setState(data.state)
                .setCity(data.city)
                .submit();

        resultComponent.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subjects)
                .checkResult("Hobbies", data.hobbies)
                .checkResult("Picture", data.file)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city);


    }
    @Test
    void requiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setPhone(data.phone)
                .submit();

        resultComponent.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone);
    }
    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setPhone(data.phone)
                .submit();

        resultComponent.negativeResult()
                .negativeResult();
    }
}
