package com.cybertek.pages.activityStream;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.utilities.BasePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ActivityStreamPage extends BasePage {

    Pages pages=new Pages();


    @Test
    public void test() throws FileNotFoundException {

        pages.loginPage().goToLandingPage();
        pages.loginPage().login("help desk");
      pages.activityStreamManagment().tasklocator.click();
       BrowserUtils.waitFor(6);
//
//            clickOnTask("final task8");
//
//
//        BrowserUtils.waitFor(5);
//        WebElement frame=Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"));
//       Driver.getDriver().switchTo().frame(frame);
//
//        System.out.println(Driver.getDriver().findElement(By.cssSelector("#task-detail-deadline")).getText());
//        Driver.getDriver().switchTo().defaultContent();

        String path="C:\\Users\\ademo\\Desktop\\Btrix24 application.pdf";

        FileInputStream inputFile=new FileInputStream(path);
        pages.activityStreamManagment().uploadFile.click();
        BrowserUtils.waitFor(3);
        pages.activityStreamManagment().attachFile.sendKeys(path);


BrowserUtils.waitFor(5);
        Driver.closeDriver();




    }
    public  void clickOnTask(String task) {


        List<WebElement> tasks = Driver.getDriver().findElements(By.cssSelector("[class^='task-title task-status-text-']"));
        for (WebElement each : tasks
        ) {
            if (each.getText().equals(task)) {
                BrowserUtils.waitForStaleElement(each);
                each.click();
            }
        }

    }

}
