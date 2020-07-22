package company.name.CustomerAccount;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import company.name.character.clients.ClientForC809;
import company.name.listener.ScreenshotListener;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static company.name.helpers.DriverHelper.byTestId;
import static io.qameta.allure.Allure.step;

@Listeners({ScreenshotListener.class})
public class C809InputCorrectDataTesterTest {

    ClientForC809 user2 = new ClientForC809();
    private String deleteField = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Epic("4.Личный кабинет тестировщика")
    @Feature("4.1 Заполнение Профиля")
    @Story("C809 4.1.1 Заполнение корректных данных профиля тестировщика (мужской профиль)")
    @Description(value = "C809 4.1.1 Заполнение корректных данных профиля тестировщика (мужской профиль)")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(description = "C809 4.1.1 Заполнение корректных данных профиля тестировщика (мужской профиль)", groups = {"include", "C809", "4.1.1", "4.1"})
    public void inputCorrectDataTesterTest() {

        step("Step 1. Перейти на страницу сайта https://preprod.uxcrowd.ru/", () -> {
            Selenide.open(user2.stand);
        });

        step("Step 2. Нажать кнопку 'Войти'", () -> {
            if ($(byTestId("Logout button")).isDisplayed())
                $(byTestId("Logout button")).click();

            $(byTestId("Login menu button")).click();
            $(byTestId("Login button")).shouldHave(enabled);
        });

        step("Step 3. Авторизируемся", () -> {
            $(byTestId("Email input")).shouldHave(visible);
            $(byTestId("Email input")).sendKeys(user2.email);
            $(byTestId("Password input")).sendKeys(user2.password);
            $(byTestId("Login button")).click();
            $(byTestId("Logout button")).shouldHave(enabled);
        });

        step("Step 4. Нажать кнопку 'Профиль'", () -> {
            $(byTestId("Profile tester menu button")).click();
            $(by("ng-tr", "PTS.PTS64")).shouldHave(enabled);
        });

        step("Step 5. В группе пол выбираем метку 'Мужской'", () -> {
            $(by("value", "MALE")).click();
            $(byXpath("//div[@class='main_container']//div[5]//div[1]//span[1]")).shouldHave(text("Холост"));
        });

        step("Step 6. Ввести или выбрать следующие значения:", () -> {

            $(by("data-type-title", "fio")).setValue(deleteField).setValue(user2.fioProfile);
            $(by("data-type-title", "city")).setValue(deleteField).setValue(user2.address);

            if (user2.isMarried)
                $(byXpath("//div[5]//div[2]//input[1]")).click();
            else
                $(byXpath("//div[5]//div[1]//input[1]")).click();

            $(by("id", "education-button")).click();
            switch (user2.education) {
                case INCOMPLETE_GENERAL:
                    $(by("id", "ui-id-2")).click();
                    break;

                case COMPLETE_GENERAL:
                    $(by("id", "ui-id-3")).click();
                    break;

                case SECONDARY_VOCATIONAL:
                    $(by("id", "ui-id-4")).click();
                    break;

                case INCOMPLETE_HIGHER_EDUCATION:
                    $(by("id", "ui-id-5")).click();
                    break;

                case HIGHER:
                    $(by("id", "ui-id-6")).click();
                    break;

                default:
                    System.out.println("Ошибка выбора образования");
                    break;
            }

            $(by("id", "socialStatus-button")).click();
            switch (user2.career) {
                case DEPARTMENT_HEAD:
                    $(byXpath("//div[contains(text(), 'Руководитель отдела')]")).click();
                    break;

                case SPECIALIST_HIGHER_EDUCATION_WITHOUT_SUBMISSIONS:
                    $(byXpath("//div[contains(text(), 'Специалист с высшим образованием без подчиненных')]")).click();
                    break;

                case WORKER_OF_ANY_QUALIFICATION:
                    $(byXpath("//div[contains(text(), 'Рабочий любой квалификации')]")).click();
                    break;

                case FREELANCER:
                    $(byXpath("//div[contains(text(), 'Фрилансер')]")).click();
                    break;

                case STUDENT:
                    $(byXpath("//div[contains(text(), 'Студент')]")).click();
                    break;

                case HOUSEWIFE:
                    $(byXpath("//div[contains(text(), 'Домохоз')]")).click();
                    break;

                case UNEMPLOYED:
                    $(byXpath("//div[contains(text(), 'Безработ')]")).click();
                    break;

                default:
                    System.out.println("Ошибка выбора карьеры");
                    break;
            }

            $(by("id", "income")).setValue(deleteField).setValue(user2.income);

            switch (user2.children) {
                case 0:
                    $(byXpath("//div[@class='mt-25']//div[2]//div[1]//input[1]")).click();
                    break;

                case 1:
                    $(byXpath("//div[@class='mt-25']//div[2]//div[2]//input[1]")).click();
                    break;

                case 2:
                    $(byXpath("//div[@class='mt-25']//div[2]//div[3]//input[1]")).click();
                    break;

                default:
                    $(byXpath("//div[@class='mt-25']//div[2]//div[4]//input[1]")).click();
                    break;
            }

            $(by("data-type-title", "birthday")).setValue(deleteField).setValue(user2.dataBirth);

            $(by("type", "checkbox")).click();
            $(by("type", "submit")).click();
        });

        step("Step 7. Проверяем, что данные сохранились", () -> {
            getWebDriver().navigate().refresh();

            $(by("data-type-title", "fio")).getAttribute("value").equals(user2.fioProfile);
            $(by("data-type-title", "birthday")).getAttribute("value").equals(user2.dataBirth);
            $(by("data-type-title", "city")).getAttribute("value").equals(user2.address);
            $(by("data-type-title", "city")).getAttribute("value").equals(user2.address);
            $(by("id", "income")).getAttribute("value").equals(user2.income);
        });
    }
}
