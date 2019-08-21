package com.cybertek.pages.activityStream;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.utilities.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ActivityStreamManagment extends BasePage {

    public ActivityStreamManagment(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#feed-add-post-form-tab-tasks")
    public WebElement tasklocator;
@FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public  WebElement thingsToDoLocator;
@FindBy(id = "bx-b-uploadfile-task-form-lifefeed_task_form")
    public WebElement uploadFileLocator;
@FindBy(css = "#bx-b-link-task-form-lifefeed_task_form")
    public WebElement uploadLinkLocator;
@FindBy(name = "bxu_files[]")
    public WebElement uploadFileBox;
@FindBy(xpath = "//span[@class='tasks-task-mpf-link']")
    public WebElement checklistLocator;
@FindBy(xpath = "//span[@class='task-options-destination-wrap date']//input[@class='task-options-inp']")
    public WebElement deadlineLocator;
@FindBy(xpath = "//button[@id='blog-submit-button-save']")
public WebElement sendButtonLocator;
@FindBy(xpath = "//a[contains(text(),'First Task')]")
public WebElement firstTaskLocator;
@FindBy(xpath = "//input[@name='bxu_files[]']")
public WebElement attachFile;


@FindBy(css = "[class^='task-title task-status-text-']")
public List<WebElement> totalTaskLocator;
@FindBy(xpath = "//input[@name='ID[]']")
public WebElement totalCheckBoxLocator;
@FindBy(xpath = "//span[@class='bx-calendar-button-text'][contains(text(),'Select')]")
public WebElement selectBtn;
@FindBy(css = "span[class='task-deadline-date']")
public List<WebElement> deadLineDates;
@FindBy(xpath = "//span[@class='task-options-inp-container task-options-date']//input[@class='task-options-inp']")
public WebElement selectDates;

@FindBy(id = "task-detail-deadline")
public WebElement deadlineDetail;
@FindBy(css = "#bx-b-uploadfile-task-form-lifefeed_task_form")
public WebElement uploadFile;

@FindBy(xpath = "//img[@data-bx-viewer='image']")
public WebElement imigaLocator;

public void clickSelectBtn(){
    try{
        selectBtn.click();
        throw  new ElementNotInteractableException("seleck button");
    }catch (Exception e){
        System.out.println("e.getMessage() = " + e.getMessage());
    }
}

public void clickOnTask(){
   try{
       BrowserUtils.waitFor(3);
       tasklocator.click();
       throw new NoSuchElementException("Element");
}catch (Exception e) {
       System.out.println("e.getMessage() = " + e.getMessage());
   }
   }
public void writeIntoToDoList(String task){

    BrowserUtils.waitForClickablility(thingsToDoLocator,3);
    thingsToDoLocator.sendKeys(task);
    BrowserUtils.waitFor(2);
}
public  void clickToSend(){
    BrowserUtils.waitForStaleElement(sendButtonLocator);
    sendButtonLocator.click();
}


public static List<String> getAllTasks(List<WebElement> elements){
    List<String> list=new ArrayList<>();
    for (WebElement each:elements
    ) {if(!each.getText().isEmpty())
        list.add(each.getText());

    }
    return list;
}
public  void clickOnTask(String task){

try {
    List<WebElement> tasks = Driver.getDriver().findElements(By.cssSelector("[class^='task-title task-status-text-']"));
    for (WebElement each : tasks
    ) {
        if (each.getText().equals(task)) {
            BrowserUtils.waitForStaleElement(each);
            each.click();
        }
    }
    throw new ElementClickInterceptedException("clickable");
}catch (Exception e){
    System.out.println("task = " + e.getMessage());
}
    }


public  void selectDeadline(int input){

    Driver.getDriver().findElement(By.xpath("//a[@class='bx-calendar-cell'][contains(text(),'"+input+"')]")).click();
  BrowserUtils.waitForStaleElement(selectBtn);
    selectBtn.click();

}
public String selectedDate(){
  String date=  selectDates.getText();
  return date;
}
public String deadLineDetail() {

    WebElement frame=Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"));
    Driver.getDriver().switchTo().frame(frame);

    String info= Driver.getDriver().findElement(By.cssSelector("#task-detail-deadline")).getText();
    Driver.getDriver().switchTo().defaultContent();


    return info;


}

public  void uploadFiles(String path){
    try {
        FileInputStream inputFile=new FileInputStream(path);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    BrowserUtils.waitFor(3);
    attachFile.sendKeys(path);
    BrowserUtils.waitFor(3);
}

public void checkFile(){
    WebElement frame=Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"));
    Driver.getDriver().switchTo().frame(frame);
    Assert.assertTrue(imigaLocator.isDisplayed());
    Driver.getDriver().switchTo().defaultContent();

}
}
