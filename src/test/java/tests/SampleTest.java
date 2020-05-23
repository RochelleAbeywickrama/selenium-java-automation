package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class SampleTest {

    private WebDriver driver;
    protected HomePage homePage;

    String URL = "https://the-internet.herokuapp.com/";
    String driverPath = "src/main/resources/chromedriver.exe";

    @BeforeClass
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }

    @Test
    public void SampleTestCase(){

        homePage = new HomePage(driver);
        homePage.clickFormAuthentication();
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
