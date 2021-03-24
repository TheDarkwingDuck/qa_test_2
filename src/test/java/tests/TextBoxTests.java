package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/text-box");
     //   Selenide.open();

        $("#userName").setValue("alex");
        $("#userEmail").setValue("22@22.22");
        $("#currentAddress").setValue("123");
        $("#permanentAddress").setValue("777");
        $("#submit").click(); // не работает. почему?

        System.out.println("debug");
    }

    @Test
    void successfulFillNewFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("alex");
        $("#lastName").setValue("baranov");
        $("#userEmail").setValue("123@123.hh");
        $(by("for", "gender-radio-3")).click();
        $("#userNumber").setValue("79171027222");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(by("value", "1990")).click();
        $(by("value", "3")).click();
   //     $("#dateOfBirthInput").clear(); почему не работает?
   //     $("#dateOfBirthInput").setValue("17 Mar 2016");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(by("for", "hobbies-checkbox-2")).click();
        $("#uploadPicture").sendKeys("C:\\Users\\thinkpad_1\\Desktop\\11111.png");
        $("#currentAddress").setValue("qwerty");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
    //    $("#state").setValue("Uttar Pradesh").pressEnter(); почему не работает?
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        //не придумала, как написать нормальные локаторы
        //    $("  ").shouldHave(text("  ")); шаблон
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table >" +
                " tbody > tr:nth-child(1) > " + "td:nth-child(2)").shouldHave(text("alex baranov"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > " +
                "tr:nth-child(2) > td:nth-child(2)").shouldHave(text("123@123.hh"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table >" +
                " tbody > tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Other"));
    //    $("body > div.fade.modal.show > div > div > div.modal-body > div > " +
    //            "table > tbody > tr:nth-child(4) > td:nth-child(2)").shouldHave(text("79171027222")); почему-то находится элемент с тегами
        $("body > div.fade.modal.show > div > div > div.modal-body > div > " +
                "table > tbody > tr:nth-child(5) > td:nth-child(2)").shouldHave(text("17 April,1990"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table >" +
                " tbody > tr:nth-child(6) > td:nth-child(2)").shouldHave(text("English"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table " +
                "> tbody > tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Reading"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table >" +
                " tbody > tr:nth-child(8) > td:nth-child(2)").shouldHave(text("11111.png")); //кажется, это не очень корректно
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table " +
                "> tbody > tr:nth-child(9) > td:nth-child(2)").shouldHave(text("qwerty"));
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table" +
                " > tbody > tr:nth-child(10) > td:nth-child(2)").shouldHave(text("Uttar Pradesh Agra"));


        System.out.println("debug");
    }

}
