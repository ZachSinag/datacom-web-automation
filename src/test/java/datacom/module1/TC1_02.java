package datacom.module1;

import datacom.base.BrowserManager;
import datacom.utilities.DataCom;
import datacom.utilities.Log;
import datacom.utilities.MyElements;
import datacom.utilities.Screen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC1_02 extends BrowserManager {

    @Test
    public void TC1_02_VALIDATE_BREADCRUMBS() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        String breadCrumbs = MyElements.getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[1]"));
        Assert.assertTrue(breadCrumbs.contains("Home Our locations"));
        DataCom.logsPassed("The user able to see the Home > Our locations in breadcrumbs section");

        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);


    }
}
