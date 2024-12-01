package datacom.module2;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

import static datacom.utilities.MyElements.getAttribute;
import static datacom.utilities.MyElements.getText;

public class TC2_03 extends BrowserManager {

    @Test
    public void TC2_03_MEDIA_PACK_NAVIGATION_SECTIONS() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='media-pack' and @role='anchor']"));
        DataCom.logs("The user clicked on the Media Pack Navigation menu");

        String mediaPackTitle = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[6]/div/div/div[1]/h2"));
        Assert.assertTrue(mediaPackTitle.contentEquals("Our media pack"));
        DataCom.logsPassed("The user able to see the Our media pack Title");

        String mediaPackBody = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[6]/div/div/div[1]/div[1]"));
        Assert.assertTrue(mediaPackBody.contentEquals("Need access to Datacom’s media pack and brand assets? Get in touch with our communications team for the latest guidelines and assets for the Datacom brand."));
        DataCom.logsPassed("The user able to see the Our media pack body literature");

        String getTouchImage = getAttribute(driver, By.xpath("/html/body/div[2]/div/div/div/div[6]/div/div/div[2]/picture/img"), "src");
        Assert.assertTrue(getTouchImage.contentEquals("https://assets.datacom.com/is/image/datacom/MediaPack_960x540px?$text-w-image-cmp--standard$"));
        DataCom.logsPassed("The user able to see the Our media pack image");

        String mediaPackButton = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[6]/div/div/div[1]/div[2]/a"));
        Assert.assertTrue(mediaPackButton.contentEquals("Contact us"));
        DataCom.logsPassed("The user able to see the Contact us Button");

        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
