package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest extends TestBases {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Malinin")
                .setEmail("Malinin@true.re")
                .setGender("Other")
                .setPhone("1234567891")
                .setOfBirthInput("05", "May", "1920")
                .setSubjects("English")
                .setHobbies("Sports", "Reading", "Music")
                .setFile("panda.jpg")
                .setCurrentAddress("city:Big, street:long")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();

        registrationPage.checkResult("Student Name", "Nikita Malinin")
                .checkResult("Student Email", "Malinin@true.re")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567891")
                .checkResult("Date of Birth", "05 May,1920")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "panda.jpg")
                .checkResult("Address", "city:Big, street:long")
                .checkResult("State and City", "Haryana Karnal");


    }

    @Test
    void requiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Malinin")
                .setGender("Other")
                .setPhone("1234567891")
                .submit();

        registrationPage.checkResult("Student Name", "Nikita Malinin")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567891");
    }

    @Test
    void negativeTest(){
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Malinin")
                .setPhone("1234567891")
                .submit();

        registrationPage.negativeResult()
                .negativeResult();
    }

}