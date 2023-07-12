package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;
import tests.BaseTest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class StepDefinitions extends BaseTest {

    TasksListPage tasksListPage;
    CreateTaskPage createTaskPage;

    private void setUp() throws MalformedURLException, URISyntaxException {
//        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
    }


    @Given("Click Add new Task")
    public void click_add_new_task() throws MalformedURLException, URISyntaxException {
        setUp();
        tasksListPage.clickAddTaskBtn();
    }
    @And("Enter Task Name")
    public void enterTaskName() {
        createTaskPage.enterTaskName("Task 1");
    }

    @And("Enter Task Description")
    public void enterTaskDescription() {
        createTaskPage.enterTaskDesc("Description of task 1");
    }

    @Given("Enter {string} and {string}")
    public void enterTaskNameAndTaskDesc(String taskName, String taskDesc) {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }

    @When("Click Save")
    public void click_save() {
        createTaskPage.clickSaveBtn();
    }

    @Then("Task added successfully")
    public void task_added_successfully() {
        driver.navigate().back();
    }



}
