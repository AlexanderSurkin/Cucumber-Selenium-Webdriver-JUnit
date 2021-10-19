package hellocucumber;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This class creates Chromedriver.
 */
public class ChromedriverAndOthersMethods {
    public static final String CHROMEDRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static WebDriver driver;

    /**
     * This method runs setProperty for Chromedriver.
     */
    public static void sProp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    /**
     * This method is return Chromedriver.
     * @return variable with Chromedriver.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * This method is opening URL with registration form.
     */
    public void openRegisterFormPage() {
        sProp();
        getDriver().get("https://inventory.edu-netcracker.com/pages/registration.xhtml");
    }

    /**
     * This method is opening authorization form.
     */
    public void openAuthorizationPage() {
        sProp();
        getDriver().get("https://inventory.edu-netcracker.com/login.jsp");
    }

    /**
     * This method closes a browser.
     */
    public void closeBrowser() {
        //TimeUnit.SECONDS.sleep(3);
        getDriver().quit();
    }

    /**
     * This method is create screenshot of web-page after testing
     * @param file contains name of png-file
     */
    public static void getScreenShot(String file) {
        try {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/main/Screenshots/" + file));

        } catch (IOException ioe) {
            ioe.getStackTrace();
        }
    }
}