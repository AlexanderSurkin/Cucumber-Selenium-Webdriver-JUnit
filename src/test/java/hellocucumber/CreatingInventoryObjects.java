package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CreatingInventoryObjects extends ChromedriverAndOthersMethods {

    private String actualValue;
    private String expectedValue;
    private String expectedUrl;
    @SuppressWarnings("FieldMayBeFinal")
    private String nextChildBeforeFloor = "#j_idt76\\:tabView\\:j_idt109_data > tr > td.object_name > a";
    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    private String nextChildObjectFloor = "#j_idt76\\:tabView\\:j_idt113_data > tr > td.object_name > a";
    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    private String nextObjectSwitch = "#j_idt76\\:tabView\\:j_idt107_data > tr > td.object_name > a";


    /**
     * This method is opening 'Inventory' page.
     */
    public void openingInventoryPage() {
        openAuthorizationPage();
        getDriver().findElement(By.name("j_username")).sendKeys("Userr204");
        getDriver().findElement(By.name("j_password")).sendKeys("Password204+");
        getDriver().findElement(By.name("submit")).click();
        getDriver().findElement(By.cssSelector("#inventory > a")).click();
    }

    /**
     * This method is find the save button.
     * @return path to button "Save".
     */
    public WebElement saveObjectButton() {
        return getDriver().findElement(By.name("j_idt74:j_idt76"));
    }

    /**
     * This method is retutning string value of created object type.
     * @return value of object type.
     */
    public String objectType() {
        return getDriver().findElement(By.cssSelector("#table_data > table > tbody > tr:nth-child(2) > td")).getText();
    }

    /**
     * This method is returning next created child object.
     * @return web-element of next child object.
     */
    public WebElement nextChildObject(String value) {
        return getDriver().findElement(By.cssSelector(value));

    }

    /**
     * This method is returning web-element of created country.
     * @return web-element of country.
     */
    public WebElement createdCountry() {
        return getDriver().findElement(By.cssSelector("#j_idt76\\:tabView\\:j_idt89_data > tr > td.object_name > a"));
    }

    /**
     * This method is returning web-element of create any object button.
     * @return web-element of create any object button.
     */
    public WebElement creatingObject() {
        return getDriver().findElement(By.cssSelector("#table_header > table > tbody > tr > td:nth-child(1) > a"));
    }

    /**
     * This method is returning web-element of button 'Parameters'.
     * @return web-element of button 'Parameters'.
     */
    public WebElement buttonParameters() {
        return getDriver().findElement(By.cssSelector("#j_idt76\\:tabView > ul > li:nth-child(1) > a"));
    }

    /**
     * This method make assertion equals and quit browser.
     */
    public void assertAndQuit() {
        Assert.assertEquals(expectedValue, actualValue);
        closeBrowser();
    }

    /**
     * This method is return web-element of Name field.
     * @return web-element of Name field.
     */
    public WebElement nameField() {
        return getDriver().findElement(By.id("j_idt74:name"));
    }

    /**
     * This method is return web-element of Square field.
     * @return web-element of Square field.
     */
    public WebElement squareField() {
        return getDriver().findElement(By.id("j_idt74:square"));
    }

    /**
     * This method is return web-element of Number field.
     * @return web-element of Number field.
     */
    public WebElement numberField() {
        return getDriver().findElement(By.id("j_idt74:number"));
    }

    /**
     * This method is return web-element of Width field.
     * @return web-element of Width field.
     */
    public WebElement widthField() {
        return getDriver().findElement(By.id("j_idt74:width"));
    }

    /**
     * This method is return web-element of Length field.
     * @return web-element of Length field.
     */
    public WebElement lengthField() {
        return getDriver().findElement(By.id("j_idt74:length"));
    }

    /**
     * This method is return web-element of Height field.
     * @return web-element of Height field.
     */
    public WebElement heightField() {
        return getDriver().findElement(By.id("j_idt74:height"));
    }

    /**
     * This method is select value in dropdown.
     * @param option is value of option.
     */
    public void physicalStatus(String option) {
        new Select(getDriver().findElement(By.id("j_idt74:physicalStatus"))).selectByVisibleText(option);
    }

    //TODO TC_6_1_1

    @Given("URL-page for inventory page")
    public void urlPageForInventoryPage() {
        openingInventoryPage();
    }

    @When("When I create new object with <Create country>")
    public void whenICreateNewObjectWithCreateCountry() {
        //Нажимаем кнопку 'Create country'
        creatingObject().click();

        //Вводим название
        nameField().sendKeys("Country1989");
        CreatingInventoryObjects.getScreenShot("TC_6_1_1_Step1.png");

        //Выбираем в выпадающем меню 'Eurasia'
        new Select(getDriver().findElement(By.id("j_idt74:continent"))).selectByVisibleText("Eurasia");
        CreatingInventoryObjects.getScreenShot("TC_6_1_1_Step2.png");

        //Вводим язык
        getDriver().findElement(By.id("j_idt74:language")).sendKeys("Africanian");
        CreatingInventoryObjects.getScreenShot("TC_6_1_1_Step3.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_1_Step4.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "Country";
        CreatingInventoryObjects.getScreenShot("TC_6_1_1_Step5.png");
    }

    @Then("Object with type <Country> must be created")
    public void objectWithTypeCountryMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_2

    @When("When I create new object with <Create city>")
    public void whenICreateNewObjectWithCreateCity() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_2_Step1.png");

        //Нажать на кнопку 'Create city'
        creatingObject().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_2_Step2.png");

        //Ввести имя в поле 'Name'
        nameField().sendKeys("Lawakia");
        CreatingInventoryObjects.getScreenShot("TC_6_1_2_Step3.png");

        //Ввести имя в поле 'Population'
        getDriver().findElement(By.id("j_idt74:population")).sendKeys("500000");
        CreatingInventoryObjects.getScreenShot("TC_6_1_2_Step4.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_2_Step5.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "City";
    }

    @Then("Object with type <City> must be created")
    public void objectWithTypeCityMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_3

    @When("When I create new object with <Create building>")
    public void whenICreateNewObjectWithCreateBuilding() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step2.png");

        //Нажать на кнопку 'Create building'
        creatingObject().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step3.png");

        //Ввести название в поле 'Name'
        nameField().sendKeys("AgrobaMall");
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step4.png");

        //Ввести название в поле 'Street Name'
        getDriver().findElement(By.id("j_idt74:streetName")).sendKeys("Frunze");
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step5.png");

        //Ввести название в поле 'Number'
        numberField().sendKeys("85");
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step6.png");

        //Ввести название в поле 'Square'
        squareField().sendKeys("52");
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step7.png");

        //Выбираем в выпадающем меню 'Is connected' необходимое значение
        new Select(getDriver().findElement(By.id("j_idt74:isconnected"))).selectByVisibleText("Lit");
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step8.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_3_Step9.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "Building";
    }

    @Then("Object with type <Building> must be created")
    public void objectWithTypeBuildingMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_4

    @When("When I create new object with <Create floor>")
    public void whenICreateNewObjectWithCreateFloor() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step2.png");

        //Нажать на кнопку нужного здания
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step3.png");

        //Нажать на кнопку 'Create floor'
        creatingObject().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step4.png");

        //Ввести название в поле 'Number'
        numberField().sendKeys("545");
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step5.png");

        //Ввести название в поле 'Square'
        squareField().sendKeys("8");
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step6.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_4_Step7.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "Floor";
    }

    @Then("Object with type <Floor> must be created")
    public void objectWithTypeFloorMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_5

    @When("When I create new object with <Create room>")
    public void whenICreateNewObjectWithCreateRoom() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step2.png");

        //Нажать на кнопку нужного здания
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step3.png");

        //Нажать на кнопку нужного этажа
        nextChildObject(this.nextChildObjectFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step4.png");

        //Нажать на кнопку 'Create room'
        creatingObject().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step5.png");

        //Ввести название в поле 'Name'
        nameField().sendKeys("545");
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step6.png");

        //Ввести название в поле 'Square'
        squareField().sendKeys("8");
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step7.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_5_Step8.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "Room";

    }

    @Then("Object with type <Room> must be created")
    public void objectWithTypeRoomMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_6

    @When("When I create new object with <Create rack>")
    public void whenICreateNewObjectWithCreateRack() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step2.png");

        //Нажать на кнопку нужного здания
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step3.png");

        //Нажать на кнопку нужного этажа
        nextChildObject(this.nextChildObjectFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step4.png");

        //Нажать на кнопку нужного помещения
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step5.png");

        //Нажать на кнопку 'Create rack'
        creatingObject().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step6.png");

        //Ввести название в поле 'Name'
        nameField().sendKeys("Switch");
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step7.png");

        //Ввести название в поле 'Width'
        widthField().sendKeys("7");
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step8.png");

        //Ввести название в поле 'Length'
        lengthField().sendKeys("8");
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step9.png");

        //Ввести название в поле 'Height'
        heightField().sendKeys("3");
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step10.png");

        //Выбираем в выпадающем меню 'Physical Status' необходимое значение
        physicalStatus("Planned");
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step11.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_6_Step12.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "Rack";
    }

    @Then("Object with type <Rack> must be created")
    public void objectWithTypeRackMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_1_7

    @When("When I create new object with <Post terminal>")
    public void whenICreateNewObjectWithPostTerminal() throws InterruptedException {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step2.png");

        //Нажать на кнопку нужного здания
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step3.png");

        //Нажать на кнопку нужного этажа
        nextChildObject(this.nextChildObjectFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step4.png");

        //Нажать на кнопку нужного помещения
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step5.png");

        //Нажать на кнопку нужного рэка
        nextChildObject(this.nextObjectSwitch).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step6.png");

        //Нажать на вкладку 'POS terminal'
        WebElement element = getDriver().findElement(By.xpath(".//a[text()='Post Terminal (s)']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step7.png");

        //Нажать на кнопку 'Create Post Terminal'
        WebElement element1 = getDriver().findElement(By.xpath(".//a[contains(text(),'Create Post Terminal')]"));
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].click();", element1);
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step8.png");

        //Ввести название в поле 'Name'
        nameField().sendKeys("Ozon");
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step9.png");

        //Ввести название в поле 'Width'
        widthField().sendKeys("3");
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step10.png");

        //Ввести название в поле 'Length'
        lengthField().sendKeys("5");
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step11.png");

        //Ввести название в поле 'Height'
        heightField().sendKeys("6");
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step12.png");

        //Выбираем в выпадающем меню 'Physical Status' необходимое значение
        physicalStatus("Planned");
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step13.png");

        //Нажать на кнопку 'select' у поля 'Located in'
        getDriver().findElement(By.cssSelector("#table_data > table > tbody > tr:nth-child(6) > td > a:nth-child(5)")).click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step14.png");

        //Переходим на открывшуюся страницу
        String parent = getDriver().getWindowHandle();
        Set<String> s = getDriver().getWindowHandles();
        //getDriver().switchTo().window("Navigation Tree");
        for (String child_window : s) {

            if (!parent.equals(child_window)) {
                getDriver().switchTo().window(child_window);

                //System.out.println(getDriver().getTitle());


            }
        }

        WebElement element2 = getDriver().findElement(By.xpath("/html/body/form/div/div[2]/div/ul/li/span/span[3]/a"));
        JavascriptExecutor executor2 = (JavascriptExecutor)getDriver();
        executor2.executeScript("arguments[0].click();", element2);
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step15.png");

        //Нажимаем кнопку ОК
        getDriver().findElement(By.id("OK")).click();

        //Возвращаемся на родительскую страницу
        getDriver().switchTo().window(parent);

        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step16.png");

        //Нажимаем кнопку сохранения
        saveObjectButton().click();
        CreatingInventoryObjects.getScreenShot("TC_6_1_7_Step17.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "POS Term";
    }

    @Then("Object with type <POS Term> must be created")
    public void objectWithTypePOSTermMustBeCreated() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_6_2_1

    @When("When I trying to click button <Edit>")
    public void whenITryingToClickButtonEdit() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_6_2_1_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_6_2_1_Step2.png");

        //Нажать на кнопку 'Parameters'
        buttonParameters().click();
        CreatingInventoryObjects.getScreenShot("TC_6_2_1_Step3.png");

        //Нажать на кнопку 'Edit'
        WebElement element3 = getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/form/div/div/div[1]/" +
                "div/div[1]/table/tbody/tr/td/a"));
        JavascriptExecutor executor3 = (JavascriptExecutor)getDriver();
        executor3.executeScript("arguments[0].click();", element3);
        CreatingInventoryObjects.getScreenShot("TC_6_2_1_Step4.png");

        //Ожидаемый рзультат URL страницы
        this.expectedUrl = "https://inventory.edu-netcracker.com/pages/inventory/city/edit.xhtml?id=3750";
    }

    @Then("Found object open me an <Edit> page")
    public void foundObjectOpenMeAnEditPage() {
        Assert.assertEquals(expectedUrl, getDriver().getCurrentUrl());
        getDriver().quit();
    }

    //TODO TC_8_1_1

    @When("When I trying to check that object type <City> is inner type < Country>")
    public void whenITryingToCheckThatObjectTypeCityIsInnerTypeCountry() {

        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_8_1_1_Step1.png");

        //Нажать на кнопку нужного города
        nextChildObject(this.nextChildBeforeFloor).click();
        CreatingInventoryObjects.getScreenShot("TC_8_1_1_Step2.png");

        //Нажать на кнопку 'Parameters'
        buttonParameters().click();
        CreatingInventoryObjects.getScreenShot("TC_8_1_1_Step3.png");

        //Находим значение объекта
        this.actualValue = objectType();
        this.expectedValue = "City";
    }

    @Then("There is object of type <City> into object type <Country>")
    public void thereIsObjectOfTypeCityIntoObjectTypeCountry() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }

    //TODO TC_9_1_1

    @When("When I trying to attributes from parameters of  <Country>")
    public void whenITryingToAttributesFromParametersOfCountry() {
        //Нажать на кнопку нужной страны
        createdCountry().click();
        CreatingInventoryObjects.getScreenShot("TC_9_1_1_Step1.png");

        //Нажать на кнопку 'Parameters'
        buttonParameters().click();
        CreatingInventoryObjects.getScreenShot("TC_9_1_1_Step2.png");

        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;

        if (Objects.equals(getDriver().findElement(By.cssSelector("#table_data > table > tbody > " +
                "tr:nth-child(3) > td")).getText(), "")) {
            flag1 = false;
        }
        if (Objects.equals(getDriver().findElement(By.cssSelector("#table_data > table > " +
                "tbody > tr:nth-child(5) > td")).getText(), "")) {
            flag2 = false;
        }
        if (Objects.equals(getDriver().findElement(By.cssSelector("#table_data > table > tbody > " +
                "tr:nth-child(4) > td")).getText(), "")) {
            flag3 = false;
        }
        if (Objects.equals(getDriver().findElement(By.cssSelector("#table_data > table > tbody > " +
                "tr:nth-child(6) > td")).getText(), "")) {
            flag4 = false;
        }

        this.expectedValue = "All objects attributes have values";

        if ((flag1 == true) && (flag2 == true) && (flag3 == true) && (flag4 == true)) {
            this.actualValue = "All objects attributes have values";
        } else {
            this.actualValue = "All objects attributes don't have any values";
        }
    }

    @Then("All needed attributes is on their places")
    public void allNeededAttributesIsOnTheirPlaces() {
        //Сравниваем две строки, ожидаемую и фактическую
        assertAndQuit();
    }
}
