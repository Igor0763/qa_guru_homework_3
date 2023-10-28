import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //заполнение полей формы
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Malinin");
        $("#userEmail").setValue("Malinin@true.re");
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1920");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("panda.jpg");
        $("#currentAddress").setValue("city:Big, street:long");
        $("#stateCity-label").scrollTo();
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#react-select-4-input").val("Karnal").pressEnter();
        $("#submit").pressEnter();

//проверка заполненных полей
        $(".table-responsive").shouldHave(
                text("Nikita Malinin"),
                text("Malinin@true.re"),
                text("Other"),
                text("1234567891"),
                text("05 May,1920"),
                text("English"),
                text("Sports, Reading, Music"),
                text("panda.jpg"),
                text("city:Big, street:long"),
                text("Haryana Karnal")
        );

    }

}
