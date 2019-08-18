package com.cybertek.pages.activityStream;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.utilities.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityStreamManagment extends BasePage {

    public ActivityStreamManagment(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "feed-add-post-form-tab-tasks")
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
public WebElement uploadFile;
@FindBy(xpath = "//span[@class='f-wrap']")
public WebElement uploadedfile;

@FindBy(xpath = "//a[@class='task-title task-status-text-color-accepted']")
public List<WebElement> totalTaskLocator;
@FindBy(xpath = "//input[@name='ID[]']")
public WebElement totalCheckBoxLocator;
@FindBy(xpath = "//span[@class='bx-calendar-button-text'][contains(text(),'Select')]")
public WebElement selectBtn;
@FindBy(css = "span[class='task-deadline-date']")
public List<WebElement> deadLineDates;
@FindBy(xpath = "//span[@class='task-options-inp-container task-options-date']//input[@class='task-options-inp']")
public WebElement selectDates;

@FindBy(css = "[id='task-detail-deadline']")
public WebElement deadlineDetail;

public void clickSelectBtn(){
    try{
        selectBtn.click();
        throw  new ElementNotInteractableException("seleck button");
    }catch (Exception e){
        System.out.println("e.getMessage() = " + e.getMessage());
    }
}

public void clickOnTask(){
    tasklocator.click();
    BrowserUtils.waitFor(3);
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
public boolean verifyUserUploads(){

    uploadLinkLocator.sendKeys("\u202AC:\\Users\\ademo\\Desktop\\FirstTask.jpg");
    return uploadedfile.isEnabled();

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

    List<String> list=new ArrayList<>();
    for (WebElement each:totalTaskLocator
    ) {if(each.getText().equals(task))
        each.click();

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


}
