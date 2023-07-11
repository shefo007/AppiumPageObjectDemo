import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CreateTaskPage extends BasePage {

    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "action_save")
    protected WebElement saveBtn;

    @AndroidFindBy(id = "editTextTitre")
    protected WebElement taskNameTxt;

    @AndroidFindBy(id = "editTextNote")
    protected WebElement taskDescTxt;

    public void enterTaskName(String taskName) {
        clear(taskNameTxt);
        sendText(taskNameTxt, taskName);
    }

    public void enterTaskDesc(String descText) {
        clear(taskDescTxt);
        sendText(taskDescTxt, descText);
    }

    public void clickSaveBtn() {
        click(saveBtn);
    }
}
