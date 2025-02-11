package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class PageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openPage();});

        step("Заполнить форму", () -> {
        registrationPage.setFirstName("Maria")
                .setLastName("Ivanova")
                .setEmail("maria@yandex.ru")
                .setGender("Female")
                .setUserNumber("1234567891")
                .setDateOfBirth("10", "February", "1995")
                .setSubject("English")
                .setHobbies("Sports")
                .uploadPicture("picture.jpg")
                .setAddress("Russia")
                .setState("NCR")
                .setCity("Delhi")
                .submit();});
        step("Проверить данные", () -> {
        registrationPage.checkResult("Student Name","Maria Ivanova")
                .checkResult("Student Email","maria@yandex.ru")
                .checkResult("Gender","Female")
                .checkResult("Mobile","1234567891")
                .checkResult("Date of Birth","10 February,1995")
                .checkResult("Subjects","English")
                .checkResult("Hobbies","Sports")
                .checkResult("Picture","picture.jpg")
                .checkResult("Address","Russia")
                .checkResult("State and City","NCR Delhi");});

    }
    @Test

    void minimalFormTest() {
        step("Открыть форму регистрации", () -> {
        registrationPage.openPage();});

        step("Заполнить форму", () -> {
        registrationPage .setFirstName("Maria")
                .setLastName("Ivanova")
                .setEmail("maria@yandex.ru")
                .setGender("Female")
                .setUserNumber("1234567891")
                .setDateOfBirth("10", "February", "1995")
                .submit();});
        step("Проверить данные", () -> {
        registrationPage.checkResult("Student Name","Maria Ivanova")
                .checkResult("Student Email","maria@yandex.ru")
                .checkResult("Gender","Female")
                .checkResult("Mobile","1234567891")
                .checkResult("Date of Birth","10 February,1995");});

    }
    @Test

    void withoutUserNumberTest() {
        step("Открыть форму регистрации", () -> {
        registrationPage.openPage();});
        step("Заполнить форму", () -> {
        registrationPage.setFirstName("Maria")
                .setLastName("Ivanova")
                .setEmail("maria@yandex.ru")
                .setGender("Female")
                .setDateOfBirth("10", "February", "1995")
                .submit();});
        step("Проверить данные", () -> {
        registrationPage.withoutNumberCheck();});

    }
    }
