package com.cybertek.pages.activityStream;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.utilities.BasePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityStreamPage extends BasePage {

    Pages pages=new Pages();


    @Test
    public void test(){

        pages.loginPage().goToLandingPage();
        pages.loginPage().login("help desk");
        pages.activityStreamManagment().navigateToModule("Task");
        BrowserUtils.waitFor(6);

            clickOnTask("final task8");


        BrowserUtils.waitFor(5);
        WebElement frame=Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"));
       Driver.getDriver().switchTo().frame(frame);

        System.out.println(Driver.getDriver().findElement(By.cssSelector("#task-detail-deadline")).getText());
        Driver.getDriver().switchTo().defaultContent();



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

    }}
