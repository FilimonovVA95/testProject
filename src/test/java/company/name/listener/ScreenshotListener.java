package company.name.listener;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        String screenData = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        Allure.addAttachment("Screenshot exception " + screenData, new ByteArrayInputStream(screenShot()));
    }

    private byte[] screenShot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
