package datacom.module1;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class TC1_04 extends BrowserManager {

    @Test
    public void TC1_04_VALIDATE_PAGE_TITLE() throws IOException, InterruptedException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        Assert.assertEquals(driver.getTitle(), "Contact Us — Get In Touch");
        DataCom.logsPassed("The user able to see the Contact Us — Get In Touch as page title");

        Log.endTest(className);

        Screen.screenPass(driver, className);
    }


}
