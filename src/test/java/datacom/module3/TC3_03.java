package datacom.module3;

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

public class TC3_03 extends BrowserManager {

    @Test
    public void TC3_03_CONTACT_US_MEDIA_PACK() throws IOException, InterruptedException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='media-pack' and @role='anchor']"));
        DataCom.logs("The user clicked on the Media Pack Navigation menu");

        String mediaPackButton = getAttribute(driver, By.xpath("/html/body/div[2]/div/div/div/div[6]/div/div/div[1]/div[2]/a"), "href");
        Assert.assertTrue(mediaPackButton.contentEquals("mailto:media@datacom.com"));
        DataCom.logsPassed("The user able to see the correct email of the contact us button : " +  mediaPackButton);

        Log.endTest(className);

        Screen.screenPass(driver, className);
    }


}
