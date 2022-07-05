package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class CreateNewAccountPage extends BasePage {

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > input");

    public void enterEmailAddress(String emailAddress) {
        findAndType(EMAIL_ADDRESS_INPUT_BOX, emailAddress);

    }
}
