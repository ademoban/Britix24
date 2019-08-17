package com.cybertek.pages.activityStream;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.utilities.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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
@FindBy(id = "blog-submit-button-save")
public WebElement sendButtonLocator;
@FindBy(xpath = "//a[contains(text(),'First Task')]")
public WebElement firstTaskLocator;
@FindBy(xpath = "//input[@name='bxu_files[]']")
public WebElement uploadFile;
@FindBy(xpath = "//span[@class='f-wrap']")
public WebElement uploadedfile;
@FindBy(xpath = "//table//tbody//tr[1]//td[3]")
public WebElement taskTableLocater;
@FindBy(xpath = "//a[@class='task-title task-status-text-color-accepted']")
public List<WebElement> totalTaskLocator;
@FindBy(xpath = "//input[@name='ID[]']")
public WebElement totalCheckBoxLocator;


public void clickOnTask(){
    tasklocator.click();
}
public void writeIntoToDoList(String task){

    BrowserUtils.waitForClickablility(thingsToDoLocator,3);
    thingsToDoLocator.sendKeys(task);
}
public  void clickToSend(){
   sendButtonLocator.click();
}
public boolean verifyUserUploads(){

    uploadLinkLocator.sendKeys("\u202AC:\\Users\\ademo\\Desktop\\FirstTask.jpg");
    return uploadedfile.isEnabled();

}
public boolean verifyUserUploadsLink(){
    return uploadLinkLocator.isEnabled();
}
public boolean verifyUserCanCreateCheckList(){
    return checklistLocator.isEnabled();
}
public void verifydeadline(){
    deadlineLocator.click();

}
public static List<String> getAllTasks(List<WebElement> elements){
    List<String> list=new ArrayList<>();
    for (WebElement each:elements
    ) {if(!each.getText().isEmpty())
        list.add(each.getText());

    }
    return list;
}

}
