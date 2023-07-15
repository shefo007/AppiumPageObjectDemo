package tests.workflows;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;

public class ToDoAndroidTestWorkflow extends BaseTestWorkflow {


    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData("/data/TasksData.json",
                "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void testAddTask(String taskName, String taskDesc) {

        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        driver.navigate().back();
        createTaskPage.clickSaveBtn();
    }
}
