package MentoringWithAhmet.Bank.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BankTestBase {
    public WebDriver driver;

    @BeforeSuite
    public void clearTheCookies(){
        driver = DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("bankUrl")); // SINGLETON PATTERN DESIGN
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
//        if (!iTestResult.isSuccess()){
//            BrowserUtils.getScreenShot(driver,"Bank");
//        }
        driver.quit();
    }
}
