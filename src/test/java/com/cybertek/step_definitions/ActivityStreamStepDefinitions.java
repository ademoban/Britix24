package com.cybertek.step_definitions;

import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ActivityStreamStepDefinitions {

    Pages pages = new Pages();



    @Given("Login with valid {string}  on landing page")
    public void loginWithValidOnLandingPage(String role) {
        pages.loginPage().goToLandingPage();
        pages.loginPage().login(role);
    }



    @When("write {string} into todo box")
    public void write_into_todo_box(String string) {
   pages.activityStreamManagment().writeIntoToDoList(string);
    }

    @Then("click on send")
    public void click_on_send() {
     pages.activityStreamManagment().clickToSend();
    }

    @Then("go to {string} module under activity stream")
    public void go_to_module_under_activity_stream(String string) {
      pages.activityStreamManagment().navigateToModule(string);
    }

    @Then("user verifies {string} been created")
    public void user_verifies_been_created(String string) {
        Assert.assertTrue(pages.activityStreamManagment().getAllTasks(pages.activityStreamManagment().totalTaskLocator).contains(string));
    }


    @When("click on task")
    public void clickOnTask() {
        pages.activityStreamManagment().clickOnTask();
    }
}