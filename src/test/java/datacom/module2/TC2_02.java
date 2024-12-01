package datacom.module2;

import datacom.base.BrowserManager;
import datacom.utilities.DataCom;
import datacom.utilities.Log;
import datacom.utilities.MyElements;
import datacom.utilities.Screen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static datacom.utilities.MyElements.getAttribute;
import static datacom.utilities.MyElements.getText;

public class TC2_02 extends BrowserManager {

    @Test
    public void TC2_02_GET_IN_TOUCH_NAVIGATION_SECTIONS() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='get-in-touch' and @role='anchor']"));
        DataCom.logs("The user clicked on the Get In Touch Navigation menu");

        String getTouchTitle = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[4]/div/div/div[1]/h2"));
        Assert.assertTrue(getTouchTitle.contentEquals("Get in touch"));
        DataCom.logsPassed("The user able to see the Get in touch Title");

        String getTouchBody = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[4]/div/div/div[1]/div[1]"));
        Assert.assertTrue(getTouchBody.contentEquals("Do you have a question? Want to learn more about our products and solutions? We're here to help."));
        DataCom.logsPassed("The user able to see the Get in touch body literature");

        String getTouchImage = getAttribute(driver, By.xpath("/html/body/div[2]/div/div/div/div[4]/div/div/div[2]/picture/img"), "src");
        Assert.assertTrue(getTouchImage.contentEquals("https://assets.datacom.com/is/image/datacom/Generic_staff_working_office?$text-w-image-cmp--standard$"));
        DataCom.logsPassed("The user able to see the Get in touch image");

        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
