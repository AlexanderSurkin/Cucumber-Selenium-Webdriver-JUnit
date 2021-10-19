package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * This class is testing main negative scenarios for TC_3.
 */
public class NegativeScenarioForRegistrationForm extends ChromedriverAndOthersMethods {
    @SuppressWarnings("FieldCanBeLocal")
    private final String LABEL_USERNAME_VALUE = "Login must contain only alphanumeric characters and contain at " +
            "least 6 characters";
    @SuppressWarnings("FieldCanBeLocal")
    private final String LABEL_PASSWORD_VALUE = "The Password must have at least 8 characters, at least 1 digit, " +
            "at least 1 lower case letter, at least 1 upper case letter, at least 1 non-alphanumeric character";
    @SuppressWarnings("FieldCanBeLocal")
    private final String CHARS_PASSWORD = "The Password must have at least 8 characters, at least 1 digit, at least 1 " +
            "lower case letter, at least 1 upper case letter, at least 1 non-alphanumeric character";
    @SuppressWarnings("FieldCanBeLocal")
    private final String LABEL_CONFIRM_PASSWORD_VALUE = "The Repeat password must be the same as the Password";
    @SuppressWarnings("FieldCanBeLocal")
    private final String LABEL_EMAIL_VALUE = "Enter here valid e-mail address";
    @SuppressWarnings("FieldCanBeLocal")
    private final String EMAIL_VALUE = "The email must be contains at least 1 symbol «@», digits and Latin letters, " +
            "also  characters: «_», «.», « - ». After symbol «@», at least must be 1 symbol «.», but not at the end of " +
            "value. After last symbol  «.» must be only Latin letters from lower case.";
    @SuppressWarnings("FieldCanBeLocal")
    private final String ROLE_VALUE = "Pick corresponding role";
    private final String REGISTER_ANSWER = "An email should have been sent to your address. " +
            "It contains easy instructions to complete your registration";
    private String actualLabelValue;
    private String actualText;
    private String expectedText;

    /**
     * This method is return web-element 'Registration'
     * @return web-element 'Registration'
     */
    public WebElement registerButtonClick() {
        return getDriver().findElement(By.name("registerForm:j_idt26"));
    }

    /**
     * This method is search coincidences with sought string from 'Username' field
     * @return sought string or empty string
     */
    @SuppressWarnings("UnusedReturnValue")
    public String checkCorrectionValueUsername() {
        if (getDriver().getPageSource().contains("The Username must have at least 1 digit or 1 Latin letter")) {
            return this.actualText = "";
        } else {
            return this.actualText = getDriver().findElement(By.cssSelector("#registerForm > table > tbody > " +
                    "tr:nth-child(1) > td:nth-child(3) > span")).getText();
        }
    }

    /**
     * This method is search coincidences with sought string from 'Password' field
     * @return sought string or empty string
     */
    @SuppressWarnings("UnusedReturnValue")
    public String checkCorrectionValuePassword() {
        if (getDriver().findElement(By.cssSelector("#registerForm > table > tbody > tr:nth-child(2) > " +
                "td:nth-child(3) > span")).getText().contains("The Password must have at least 8 characters")) {
            return this.actualText = "";
        } else {
            return this.actualText = getDriver().findElement(By.cssSelector("#registerForm > table > tbody > " +
                    "tr:nth-child(2) > td:nth-child(3) > span")).getText();
        }
    }

    /**
     * This method is search coincidences with sought string from 'Email' field
     * @return string result of actions from value of email field
     */
    public String valueOfEmailField() {
        return getDriver().findElement(By.cssSelector("#registerForm > table > tbody > tr:nth-child(5) > " +
                "td:nth-child(3) > span")).getText();
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

    /**
     * This method make assertion equals and quit browser.
     */
    public void assertAndQuit() {
        Assert.assertEquals(expectedText, actualText);
        closeBrowser();
    }

    /**
     * This method is return web-element of Username field.
     * @return Username field.
     */
    public WebElement userNameField() {
        return getDriver().findElement(By.id("registerForm:username"));
    }

    /**
     * This method is return web-element of Password field.
     * @return Password field.
     */
    public WebElement passwordField() {
        return getDriver().findElement(By.id("registerForm:password"));
    }

    /**
     * This method is return web-element of Confirm password field.
     * @return Confirm password field.
     */
    public WebElement confirmPasswordField() {
        return getDriver().findElement(By.id("registerForm:confirmPassword"));
    }

    /**
     * This method is return web-element of Email field.
     * @return Email field.
     */
    public WebElement emailField() {
        return getDriver().findElement(By.id("registerForm:email"));
    }

    //TODO TC 3_1_1

    @Given("URL-page for negative testing")
    public void urlPageForNegativeTesting() {
        openRegisterFormPage();
    }

    @When("I am testing checking <?> of <Username> field")
    public void iAmTestingCheckingOfUsernameField() {
        //Нажать на элемент '?' поля 'Username'
        this.actualLabelValue = getDriver().findElement(By.xpath("//*[@id=\"registerForm\"]" +
                "/table/tbody/tr[1]/td[3]/label")).getAttribute("title");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_1_1_Step1.png");
    }

    @Then("Checking <?> of <Username> shows me a notification")
    public void checkingOfUsernameShowsMeANotification() {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(LABEL_USERNAME_VALUE, actualLabelValue);
        closeBrowser();
    }

    //TODO TC_3_1_2

    @When("I am testing <Username> field for alphanumeric characters")
    public void iAmTestingUsernameFieldForAlphanumericCharacters() {
        //Вводим логин с превышением 6 символов
        userNameField().sendKeys("++**--+++..");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_1_2_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        checkCorrectionValueUsername();

        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_1_2_Step2.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = "The Username must have at least 1 digit or 1 Latin letter";
    }

    @Then("Page near <Username> shows me a notification if the value is incorrect")
    public void pageShowsMeANotificationIfTheValueIsIncorrect() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_2_1

    @When("I am testing checking <?> of <Password> field")
    public void iAmTestingCheckingOfPasswordField() {
        //Нажать на элемент '?' поля 'Password'
        this.actualLabelValue = getDriver().findElement(By.xpath("//*[@id=\"registerForm\"]/table/" +
                "tbody/tr[2]/td[3]/label")).getAttribute("title");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_2_1_Step1.png");
    }

    @Then("Checking <?> of <Password> shows me a notification")
    public void checkingOfPasswordShowsMeANotification() {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(LABEL_PASSWORD_VALUE, actualLabelValue);
        closeBrowser();
    }

    //TODO TC_3_2_2

    @When("I am testing <Password> field length")
    public void iAmTestingPasswordFieldLength() {
        //Вводим пароль менее 8 символов
        passwordField().sendKeys("Paswd3+");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_2_2_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        checkCorrectionValuePassword();

        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_2_2_Step2.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = "The Password must have at least 8 characters.";
    }

    @Then("Page near <Password> field shows me a notification if the value is incorrect")
    public void pageNearPasswordFieldShowsMeANotificationIfTheValueIsIncorrect() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_2_3

    @When("I am testing <Password> field for correction value of password")
    public void iAmTestingPasswordFieldForCorrectionValueOfPassword() {
        //Вводим пароль менее не содержащий ни одной цифры, ни одной буквы в верхнем регистре,
        //ни одного символа, не являющегося ни буквой, ни цифрой.
        passwordField().sendKeys("password");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_2_3_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        if (getDriver().findElement(By.cssSelector("#registerForm > table > tbody > tr:nth-child(2) > td:nth-child(3) " +
                "> span")).getText().contains(CHARS_PASSWORD)) {
            this.actualText = CHARS_PASSWORD;
        } else {
            this.actualText = getDriver().findElement(By.cssSelector("#registerForm > table > tbody > tr:nth-child(2) >" +
                    " td:nth-child(3) > span")).getText();
        }
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_2_3_Step2.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = CHARS_PASSWORD;
    }

    @Then("Page near <Password> field shows me a notification about incorrect symbols")
    public void pageNearPasswordFieldShowsMeANotificationAboutIncorrectSymbols() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_3_1

    @When("I am testing checking <?> of <Repeat Password'> field")
    public void iAmTestingCheckingOfRepeatPasswordField() {
        //Нажать на элемент '?' поля 'Repeat Password'
        this.actualLabelValue = getDriver().findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[3]/td[3]/" +
                "label")).getAttribute("title");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_3_1_Step1.png");
    }

    @Then("Checking <?> of <Repeat Password> shows me a notification")
    public void checkingOfRepeatPasswordShowsMeANotification() {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(LABEL_CONFIRM_PASSWORD_VALUE, actualLabelValue);
        closeBrowser();
    }

    //TODO TC_3_3_2

    @When("I am testing coincidence <Password> field with <Repeat Password>")
    public void iAmTestingCoincidencePasswordFieldWithRepeatPassword() throws InterruptedException {

        //Вводим значение пароля
        passwordField().sendKeys("Password1+");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_3_2_Step1.png");

        //Вводим подтверждение пароля
        confirmPasswordField().sendKeys("Password1");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_3_2_Step2.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        if ((getDriver().getPageSource().contains("The Repeat password must be the same as the Password")) &&
                        (!getDriver().getPageSource().contains("<label title=\"The Repeat password must be the " +
                                "same as the Password\">?</label>"))) {
            this.actualText = "The Repeat password must be the same as the Password";
        } else {
            this.actualText = "";
        }
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_3_2_Step3.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = "The Repeat password must be the same as the Password";
    }

    @Then("Page near <Repeat Password> field shows me a notification about incorrect symbols")
    public void pageNearRepeatPasswordFieldShowsMeANotificationAboutIncorrectSymbols() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_4_1

    @When("I am testing checking <?> of <Email> field")
    public void iAmTestingCheckingOfEmailField() {
        //Нажать на элемент '?' поля 'Email'
        this.actualLabelValue = getDriver().findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[5]/" +
                "td[3]/label")).getAttribute("title");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_4_1_Step1.png");
    }

    @Then("Checking <?> of <Email> shows me a notification")
    public void checkingOfEmailShowsMeANotification() {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(LABEL_EMAIL_VALUE, actualLabelValue);
        closeBrowser();
    }

    //TODO TC_3_4_2

    @When("I am testing <Email> field for correction value of email")
    public void iAmTestingEmailFieldForCorrectionValueOfEmail() {

        //Вводим email состоящий не из букв, не из цифр, не содержащий ни одного символа '@' и '.'
        emailField().sendKeys(":%?;№;*!");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_4_2_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ищем искомый текст сообщения о превышении допустимого количества вводимых символов
        if (getDriver().getPageSource().contains(EMAIL_VALUE)) {
            this.actualText = EMAIL_VALUE;
        } else {
            this.actualText = valueOfEmailField();
        }
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_4_2_Step2.png");

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = EMAIL_VALUE;
    }

    @Then("Page near <Email> field shows me a notification about incorrect symbols")
    public void pageNearEmailFieldShowsMeANotificationAboutIncorrectSymbols() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_5_1

    @When("I am testing checking <?> of <Role> field")
    public void iAmTestingCheckingOfRoleField() {
        //Нажать на элемент '?' поля 'Role'
        this.actualLabelValue = getDriver().findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[6]/" +
                "td[3]/label")).getAttribute("title");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_1_Step1.png");
    }

    @Then("Checking <?> of <Role> shows me a notification")
    public void checkingOfRoleShowsMeANotification() {
        //Сравниваем две строки, ожидаемую и фактическую
        Assert.assertEquals(ROLE_VALUE, actualLabelValue);
        closeBrowser();
    }

    //TODO TC_3_5_2

    @When("I am testing <Role> field with value <Admin>")
    public void iAmTestingRoleFieldWithValueAdmin() throws InterruptedException {

        //Выбираем в выпадающем меню значение "Admin"
        userNameField().sendKeys("Userr300");
        passwordField().sendKeys("Password300+");
        confirmPasswordField().sendKeys("Password300+");
        emailField().sendKeys("userr300@testmail.com");
        new Select(getDriver().findElement(By.id("registerForm:role"))).selectByVisibleText("Admin");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_2_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ждём 5 секунд
        TimeUnit.SECONDS.sleep(5);

        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_2_Step2.png");

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        actualRegisterResult();

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = REGISTER_ANSWER;
    }

    @Then("The registration with value <Admin> has completed successfully")
    public void theRegistrationWithValueAdminHasCompletedSuccessfully() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_5_3

    @When("I am testing <Role> field with value <Read Only>")
    public void iAmTestingRoleFieldWithValueReadOnly() throws InterruptedException {

        //Выбираем в выпадающем меню значение "Read Only"
        userNameField().sendKeys("Userr301");
        passwordField().sendKeys("Password301+");
        confirmPasswordField().sendKeys("Password301+");
        emailField().sendKeys("userr301@testmail.com");
        new Select(getDriver().findElement(By.id("registerForm:role"))).selectByVisibleText("Read Only");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_3_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ждём 5 секунд
        TimeUnit.SECONDS.sleep(5);

        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_3_Step2.png");

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        actualRegisterResult();

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = REGISTER_ANSWER;
    }

    @Then("The registration with value <Read Only> has completed successfully")
    public void theRegistrationWithValueReadOnlyHasCompletedSuccessfully() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_3_5_4

    @When("I am testing <Role> field with value <Read_Write>")
    public void iAmTestingRoleFieldWithValueReadWrite() throws InterruptedException {

        //Выбираем в выпадающем меню значение "Read / Write"
        userNameField().sendKeys("Userr301");
        passwordField().sendKeys("Password301+");
        confirmPasswordField().sendKeys("Password301+");
        emailField().sendKeys("userr301@testmail.com");
        new Select(getDriver().findElement(By.id("registerForm:role"))).selectByVisibleText("Read / Write");
        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_4_Step1.png");

        //Нажимаем кнопку 'Register'
        registerButtonClick().click();

        //Ждём 5 секунд
        TimeUnit.SECONDS.sleep(5);

        NegativeScenarioForRegistrationForm.getScreenShot("TC_3_5_4_Step2.png");

        //Ищем искомый текст сообщения, если его нет, то возвращаем пустую строку
        actualRegisterResult();

        //Присваиваем ожидаемую строку в ожидаемый текст
        this.expectedText = REGISTER_ANSWER;
    }

    @Then("The registration with value <Read_Write> has completed successfully")
    public void theRegistrationWithValueReadWriteHasCompletedSuccessfully() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }
}
