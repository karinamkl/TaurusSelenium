package TaurusDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login {


   WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }

    public String getUserManagementText() {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        String text = driver.findElement(By.id("menu_admin_UserManagement")).getText();
        return text;
    }


    @Test()
    void LoginAdmin() {

        driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(getUserManagementText(), "User Management");
        System.out.println("Logged in successfully");
    }

}
