package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * This class is testing main positive scenarios for test-cases TC_1 and TC_2.
 */
public class PositiveScenarios extends ChromedriverAndOthersMethods {

    private String actualText;
    private final String REGISTER_ANSWER = "An email should have been sent to your address. " +
            "It contains easy instructions to complete your registration";
    private String expectedText;
    private final String expectedUrl =  "https://inventory.edu-netcracker.com/pages/startpage.xhtml";
    private String actualUrl;

    /**
     * This method is return web-element 'Registration'
     * @return web-element 'Registration'
     */
    public WebElement registerButtonClick() {
        return getDriver().findElement(By.name("registerForm:j_idt26"));
    }

    /**
     * This method is search coincidences with sought string
     * @return sought string or empty string
     */
    public String actualRegisterResult() {
        if (getDriver().getPageSource().contains("An email should have been sent to your address. " +
                "It contains easy instructions to complete your registration")) {
            return this.actualText = REGISTER_ANSWER;

        } else {
            return this.actualText = "";
        }
    }

    //TODO TC_1_1

    @Given("URL-page for testing registration form")
    public void urlPageForTestingRegistrationForm() {
        openRegisterFormPage();
    }

    @When("I am testing registration form")
    public void iAmTestingRegistrationForm() throws InterruptedException {

        //Вводим логин
        getDriver().findElement(By.id("registerForm:username")).sendKeys("Userr204");
        PositiveScenarios.getScreenShot("TC_1_1_Step1.png");

        //Вводим пароль
        getDriver().findElement(By.id("registerForm:password")).sendKeys("Password204+");
        PositiveScenarios.getScreenShot("TC_1_1_Step2.png");

        //Вводим подтверждение пароля
        getDriver().findElement(By.id("registerForm:confirmPassword")).sendKeys("Password204+");
        PositiveScenarios.getScreenShot("TC_1_1_Step3.png");

        //Вводим email
        getDriver().findElement(By.id("registerForm:email")).sendKeys("userr204@testmail.com");
        PositiveScenarios.getScreenShot("TC_1_1_Step4.png");

        //Выбираем в выпадающем меню 'Admin'
        new Select(getDriver().findElement(By.id("registerForm:role"))).selectByVisibleText("Read / Write");
        PositiveScenarios.getScreenShot("TC_1_1_Step5.png");

        //Нажимаем кнопку 'Register' и ждём 5 секунд
        registerButtonClick().click();

        //Ждём 5 секунд
        TimeUnit.SECONDS.sleep(5);

        //Ищем искомый текст сообщения об успешной регистрации, если его нет, то возвращаем пустую строку
        actualRegisterResult();

        PositiveScenarios.getScreenShot("TC_1_1_Step6.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = REGISTER_ANSWER;
    }

    @Then("The registration has completed successfully")
    public void theRegistrationHasCompletedSuccessfully() throws InterruptedException {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(expectedText, actualText);
        closeBrowser();
    }

    //TODO TC_2_1

    @Given("URL-page for testing authorization form")
    public void urlPageForTestingAuthorizationForm() {
        sProp();
        //Открываем URL с формой регистрации
        getDriver().get("https://inventory.edu-netcracker.com/login.jsp");
    }

    @When("I am testing authorization form")
    public void iAmTestingAuthorizationForm() throws InterruptedException {
        //Вводим логин
        getDriver().findElement(By.name("j_username")).sendKeys("Userr204");
        PositiveScenarios.getScreenShot("TC_2_1_Step1.png");

        //Вводим пароль
        getDriver().findElement(By.name("j_password")).sendKeys("Password204+");
        PositiveScenarios.getScreenShot("TC_2_1_Step2.png");

        //Нажимаем кнопку 'Login'
        getDriver().findElement(By.name("submit")).click();

        //Получаем ожидаемую страницу после успешной регистрации
        this.actualUrl = getDriver().getCurrentUrl();
    }

    @Then("The log in has completed successfully")
    public void theLogInHasCompletedSuccessfully() throws InterruptedException {
        //Сравниваем два строковых значения URL, ожидаемую и фактическую
        Assert.assertEquals(expectedUrl, actualUrl);
        closeBrowser();
    }
}
