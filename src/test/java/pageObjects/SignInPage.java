package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("#login-form>section>div:nth-child(2)> div.col-md-6>input");
    private static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector("#content > div > a");
    private static final By ALREADY_REGISTERED_ALERT = By.cssSelector("#customer-form > section > div.form-group.row.has-error > div.col-md-6 > div > ul > li");

    public void enterEmailAddress(String emailAddress){
        findAndType(EMAIL_ADDRESS_INPUT_BOX, emailAddress);
    }

    public void clickCreateAnAccount(){
        waitAndClick(CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void alreadyRegisteredAlertPresent(){
        WebElement alertBox = driver.findElement(ALREADY_REGISTERED_ALERT);
        Assert.assertTrue(elementIsVisible(alertBox));
    }


}
