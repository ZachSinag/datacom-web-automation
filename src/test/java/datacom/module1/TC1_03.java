package datacom.module1;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class TC1_03 extends BrowserManager {

    @Test
    public void TC1_03_VALIDATE_NAVIGATION() throws IOException, InterruptedException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        String textNavigation = MyElements.getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/ol"));
        Assert.assertTrue(textNavigation.contains("Our locations\n" +
                "Get in touch\n" +
                "Media pack"));
        DataCom.logsPassed("The user able to see the Our location, Get in touch, and Media pack in navigation section");

        Log.endTest(className);

        Screen.screenPass(driver, className);
    }


}
