package datacom.utilities;

import datacom.listener;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.*;
import java.io.IOException;



public class DataCom extends listener {

    public static void logs(String info) {

        extentTest.get().log(Status.INFO, info);
        Log.info(info);
    }


    public static void failedLogs(String info) {

        extentTest.get().log(Status.FAIL, info);
        Log.error("Failed: " + info);
    }

    public static void logsPassed(String info) {

        extentTest.get().log(Status.PASS, info);
        Log.info("Passed: " + info);
    }

    public static void logsCapture(WebDriver driver, String className, String info) throws IOException {

        Screen.capture(driver, className, info);
        Log.info(info);
    }


    public static void testTitle(WebDriver driver, String className) throws IOException, InterruptedException {

        String url = driver.getCurrentUrl();
        Log.startTest(className);
        String testTitle = String.format("<b>%s Test Start</b>", className);
        Markup markTitle = MarkupHelper.createLabel(testTitle, ExtentColor.BLUE);
        extentTest.get().log(Status.INFO, markTitle);

        MyElements.wait(driver, "/html/body/div[1]/header/div/div/a/img");



        DataCom.logsCapture(driver, className, "User accessed the following link: " + url);

    }

    public static void clickContact(WebDriver driver)  {

        MyElements.click(driver, By.id("cmp-mrkto-modal-thank-you"));
        DataCom.logs("User clicked Contact us button in the navigation menu section of the page");

    }






}
