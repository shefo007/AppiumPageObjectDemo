package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class TasksListPage extends BasePage {

    public TasksListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "fab")
    protected WebElement addTaskBtn;
    public void clickAddTaskBtn() {
        click(addTaskBtn);
    }


}
