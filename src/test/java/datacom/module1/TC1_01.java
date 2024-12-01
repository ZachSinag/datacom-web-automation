package datacom.module1;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

import static datacom.utilities.MyElements.getAttribute;
import static datacom.utilities.MyElements.getText;

public class TC1_01 extends BrowserManager {

    @Test
    public void TC1_01_CHECK_HEADER_CONTENT() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        String dataComLogo = getAttribute(driver, By.xpath("/html/body/div[1]/header/div/div/a/img"), "src");

        Assert.assertTrue(dataComLogo.contentEquals("https://assets.datacom.com/is/content/datacom/Datacom-Primary-Logo-RGB?$header-mega-logo$"));
        DataCom.logsPassed("The user able to see the DataCom Logo");;

        String headerText = MyElements.getText(driver, By.xpath("/html/body/div[1]/header/div/div"));
        Assert.assertTrue(headerText.contains("Products\n" +
                "Industries\n" +
                "Discover\n" +
                "About Us\n" +
                "Careers\n" +
                "Sign in"));
        DataCom.logsPassed("The user able to see the Solutions, Products, Industries, Discover, About Us, Careers, and Sign in in header section");

        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
