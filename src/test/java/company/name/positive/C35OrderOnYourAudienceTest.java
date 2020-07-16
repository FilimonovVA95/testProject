package company.name.positive;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import company.name.listener.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static company.name.character.clients.ClientForC35.*;
import static company.name.helpers.DriverHelper.byTestId;
import static company.name.helpers.DriverHelper.byClass;
import static io.qameta.allure.Allure.step;


@Listeners({ScreenshotListener.class})
@Story("C35 1.5.6 Заказ теста на своей аудитории(веб-сайт), тариф 'Бесплатный'")
public class C35OrderOnYourAudienceTest {

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    @Description(value = "1.5.6 Заказ теста на своей аудитории(веб-сайт), тариф 'Бесплатный'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void OrderOnYourAudienceTest() {

        step("Step 1. Перейти на страницу сайта https://preprod.uxcrowd.ru/", () -> {
            Selenide.open(stand);
        });

        step("Step 2. Нажать кнопку 'Войти'", () -> {
            $(by("id" ,"header-lk-button")).click();
        });

        step("Step 3. Авторизируемся", () -> {
            $(by("id" ,"login")).sendKeys(email);
            $(by("type" ,"password")).sendKeys(password);
            $(by("ng-tr" ,"WHE1.WHE4")).click();
        });

        step("Step 4. Нажать на 'Создать новый тест'", () -> {
            $(byClass("new_test")).click();
        });

        step("Step 5. Вводим название теста, адрес сайта и вводную информацию", () -> {
            $(byTestId("Test name input")).setValue(nameTest);
            $(byTestId("Address site input")).setValue(siteTest);
            $(byTestId("Information textarea")).setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
            $(byTestId("Information textarea")).setValue(information);
        });

        step("Step 6. Нажать кнопку 'К выбору аудитории'", () -> {
            $(byTestId("Submit button")).click();
        });

        step("Step 7. Выбрать вкладку 'Найду пользователей сам' и ввести 3 пользователей", () -> {
            $(byTestId("Client users button")).click();

            if (unusedTheirUsers < 3) {
                System.out.println("Недостаточно пользователей для тестирования");
                Selenide.closeWebDriver();
            }

            $(byTestId("Users count input")).setValue("3");
            unusedTheirUsers -= 3;
        });

        step("Step 8. Нажать кнопку 'К заданиям'", () -> {
            $(byTestId("Tasks button")).click();
        });

        step("Step 9. Добавить задания", () -> {
            $(byTestId("Tasks task question")).setValue("Опишите свое первое впечатление от сайта.");
            $(byTestId("Tasks submit task")).click();

            $(byTestId("Tasks type switcher_1")).click();
            $(byTestId("Tasks task question")).setValue("Я буду часто использовать этот сайт.");
            $(byTestId("Tasks rating variant 0")).setValue("Совершенно не согласен");
            $(byTestId("Tasks rating variant 1")).setValue("Полностью согласен");
            $(byTestId("Tasks submit task")).click();

            $(byTestId("Tasks type switcher_2")).click();
            $(byTestId("Tasks task question")).setValue("Удалось ли вам выполнить задание?");
            $(byTestId("Tasks variant 0")).setValue("Да");
            $(byTestId("Tasks variant 1")).setValue("Нет");
            $(byTestId("Tasks variant 2")).setValue("Не уверен");
            $(byTestId("Tasks submit task")).click();

            $(byTestId("Tasks type switcher_3")).click();
            $(byTestId("Tasks task question")).setValue("Какие типы мобильных приложений вы используете чаще всего?");
            $(byTestId("Tasks variant 0")).setValue("Социальные сети");
            $(byTestId("Tasks variant 1")).setValue("Игры/развлечения");
            $(byTestId("Tasks variant 2")).setValue("Новости");
            $(byTestId("Tasks variant 3")).setValue("Погода");
            $(byTestId("Tasks variant 4")).setValue("Карты");
            $(byTestId("Tasks variant 5")).setValue("Планирование (календарь, список дел)");
            $(byTestId("Tasks variant 6")).setValue("Инструменты (калькулятор, переводчик, словарь и т. п.)");
            $(byTestId("Tasks variant 7")).setValue("Другие");
            $(byTestId("Tasks submit task")).click();

            $(byTestId("Tasks type switcher_4")).click();
            $(byTestId("Tasks task question")).setValue("Какими тремя словами можно лучше всего описать этот сайт?");
            $(byTestId("Tasks submit task")).click();

            // Не добавлена метрика т.к. нет testId
        });

        step("Step 10. Нажать на кнопку 'Проверка и запуск'", () -> {
            $(byTestId("Check button")).click();

            // Проверка параметров не выполнена т.к. нет определенности какие именно параметры проверять, а так же
            // отсутсвуют testId на полях, которые необходимо проверить
        });

        step("Step 11. Нажать кнопку 'Запустить бесплатный тест'", () -> {
            $(byTestId("Checkout start button")).click();
        });

        Selenide.closeWebDriver();
    }

}
