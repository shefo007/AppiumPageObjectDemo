import org.testng.annotations.Test;

public class ToDoAndroidTest extends BaseTest {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Test
    public void testAddTask() {
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing my course ASAP");
        driver.navigate().back();
        createTaskPage.clickSaveBtn();
    }
}
