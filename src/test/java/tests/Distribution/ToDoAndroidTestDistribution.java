package tests.Distribution;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ToDoAndroidTestDistribution extends BaseTestDistribution {

    //This class is for work with to emulators to work in parallel

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TasksData.json",
                "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void testAddTask1(String taskName, String taskDesc) throws MalformedURLException, URISyntaxException {
        Android_setUp(10000, "11.0", "emulator-5554");

        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        driver.navigate().back();
        createTaskPage.clickSaveBtn();

        tearDown();
    }

    @Test(dataProvider = "tasks data")
    public void testAddTask2(String taskName, String taskDesc) throws MalformedURLException, URISyntaxException {
        Android_setUp(11000, "13.0", "emulator-5556");

        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        driver.navigate().back();
        createTaskPage.clickSaveBtn();

        tearDown();
    }
}
