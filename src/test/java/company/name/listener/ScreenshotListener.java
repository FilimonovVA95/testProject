package company.name.listener;


import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.codeborne.selenide.Selenide.screenshot;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        String screenData = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String className = this.getClass().getSimpleName();
        String fullName = "screen-shots" + File.separator + className + File.separator + screenData + "_Screenshot";
        byte[] screen = screenshot(fullName).getBytes();
        Allure.addAttachment("Screenshot exception " + screenData, new ByteArrayInputStream(screen));
    }
}
