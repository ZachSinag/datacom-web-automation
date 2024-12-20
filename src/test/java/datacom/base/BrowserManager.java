package datacom.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import datacom.listener;
import datacom.utilities.DataCom;
import datacom.utilities.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class BrowserManager extends listener {
    public static WebDriver driver;
    public static String env;
    public static String browser;

    @Parameters({"browser", "environment"})
//    @BeforeSuite
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, @Optional("prod") String environment) {
        BrowserManager.browser = browser;
        env = environment;
        driver = getDriver(browser, environment);
    }

    public static WebDriver getDriver(String type, String environment) {
        if (type == null) {
            throw new IllegalArgumentException("Browser type must be specified");
        }

        if (type.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            ChromeOptions ops = getChromeOptions();
            driver = new ChromeDriver(ops);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } else if (type.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } else {
            DataCom.logs("NO browser type sent");
        }

        switch (environment) {
            case "prod":
                driver.get("https://datacom.com/nz/en/contact-us/");
                break;
            case "stg":
                driver.get("http://stg-datacom.com/nz/en/contact-us/"); //sample environment in stg
                break;
            case "test":
                driver.get("http://test-datacom.com/nz/en/contact-us/"); //sample environment in stg
                break;
            case "preProd":
                driver.get("https://preprod.datacom.com/nz/en/contact-us/"); //sample environment in stg
                break;
            default:
                break;
        }

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-infobars");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-save-password");
//        ops.addArguments("chrome.switches","--disable-extensions");
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.setPageLoadStrategy(PageLoadStrategy.NONE);
        ops.setExperimentalOption("prefs", chromePrefs);
        return ops;
    }

    @AfterMethod
    public void tearDown_afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String exceptionMessage = result.getThrowable().getMessage();
            extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occurred, click to see details:"
                    + "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
            Log.error(exceptionMessage.replaceAll(",", "<br>"));
            WebDriver driver = null;

            String path2 = "./";
            String path = "./Automation Reports/";
            String screenshotName = (path + methodName);
            Object testObject = result.getInstance();
            Class<?> clazz = result.getTestClass().getRealClass();
            try {
                driver = (WebDriver) clazz.getField("driver").get(testObject);
            } catch (Exception e1) {
                DataCom.failedLogs("Failed to load Driver, Please check BrowserManager");
            }
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotName + "_" + dateName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(path2 + methodName + "_" + dateName + ".png").build());

            String logText = "<b>" + methodName + " Failed</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            extentTest.get().log(Status.FAIL, m);

            driver.quit();
        }else{
            driver.quit();
        }
    }

}


