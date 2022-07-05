package Tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.ShoppingCartPage;
import pageObjects.CreateNewAccountPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static junit.framework.TestCase.assertTrue;
import static Tests.TestSuite.driverFactory;


/**
 * Created by jack.forman on 09/10/2016.
 */


public class Registration {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ShoppingCartPage basketpage = new ShoppingCartPage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);


    /**
     * This should make sure we are on the correct page, i.e. set up each test case so we can be sure that they run
     */
    @Before
    public void individualSetUp() {
        homepage.goTo();
    }


    /**
     * Cannot register if user Already Registered
     * Pre-Conditions - Must have Email address of user already registered
     * Navigate to Sign In Screen
     * Enter E mail Address
     * Click Create Account
     * Verify error message displayed
     */
    @Test
    public void registerAlreadyRegistered() {
        homepage.navigateToSignInPage();
        //signInPage.enterEmailAddress("test@test.com");
        signInPage.clickCreateAnAccount();


        WebElement userEmailAddress = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > input"));
        userEmailAddress.sendKeys("test@test.com");

        WebElement usersTitle = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]"));
        usersTitle.click();

        WebElement usersFirstName = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(3) > div.col-md-6 > input"));
        usersFirstName.sendKeys("Chili");

        WebElement usersLastname = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(4) > div.col-md-6 > input"));
        usersLastname.sendKeys("laugh");

        WebElement userPassword = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(6) > div.col-md-6 > div > input"));
        userPassword.sendKeys("ten10.");

        WebElement userDOB = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(7) > div.col-md-6 > input"));
        userDOB.sendKeys("24/08/1987");

        WebElement submitNewUser = driver.findElement(By.cssSelector("#customer-form > footer > button"));
        submitNewUser.click();

        signInPage.alreadyRegisteredAlertPresent();
    }


    /**
     * New user is able to register (New = not registered before)
     * Navigate to signIn Page
     * Enter E-Mail Address
     * Click Create New Account
     * Fill in All Details on registration form
     * Click Register
     * Check My Account Page is Displayed
     */
    @Test
    @Ignore
    public void registerAsNewUser() {

        homepage.navigateToSignInPage();


        WebElement CreateNewAccount = driver.findElement(By.cssSelector("#content > div a"));
        CreateNewAccount.click();

        WebElement socialTitle = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio"));
        socialTitle.click();

        WebElement UserFirstName = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(3) > div.col-md-6 > input"));
        UserFirstName.sendKeys("Tommy");

        WebElement UserLastName = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(4) > div.col-md-6 > input"));
        UserLastName.sendKeys("Lee");

        createNewAccountPage.enterEmailAddress("tommy5@test.com");

        //WebElement UserEmail = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > input"));
        //UserEmail.sendKeys("Tommyisking@gmail.com");

        WebElement UserPassword = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(6) > div.col-md-6 > div > input"));
        UserPassword.sendKeys("Ten10");

        WebElement UserDateOfBirth = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(7) > div.col-md-6 > input"));
        UserDateOfBirth.sendKeys("08/23/1985");

        WebElement SaveUser = driver.findElement(By.cssSelector("#customer-form > footer > button"));
        SaveUser.click();

        WebElement UserAccountpage = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span"));
        UserAccountpage.click();


        Assert.assertEquals("Your account", driver.findElement(By.cssSelector("#main > header > h1")).getText());
        //always have assert to check

    }


    @After
    public void individualTearDown() {

    }

    @AfterClass
    public static void mainTearDown() {
        // Uncomment this when just running individual tests in this file.
        //driver.quit();
    }


}
