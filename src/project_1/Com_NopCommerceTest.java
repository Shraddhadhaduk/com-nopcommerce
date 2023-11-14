package project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Com_NopCommerceTest {
    static String baseUrl = "https://demo.nopcommerce.com/";

    public static void main(String[] args) throws InterruptedException {
        //Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the Url into the browser
        driver.get(baseUrl);

        //Maximize the browser
        driver.manage().window().maximize();

        //We will give implicit wait for driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get current Url
        String current =driver.getCurrentUrl();
        System.out.println("The current Url  : " + driver.getCurrentUrl());

        //get a page source
        System.out.println(driver.getPageSource());

        //Get the next Url
          String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
          driver.navigate().to(loginUrl);
          System.out.println("Get current url " + driver.getCurrentUrl());
          Thread.sleep(3000);

        //Back to the homepage
        driver.navigate().back();
        Thread.sleep(2000);

        //Find login link element and click on it
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Get the next Url
        String nextLoginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        System.out.println("Get current Url " + driver.getCurrentUrl());

        //Refresh the browser
        driver.navigate().refresh();

        //Find email field element and type the email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Abcd1234@gmail.com");
        Thread.sleep(2000);

        //Find password field element and type the password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Abc123");
        Thread.sleep(2000);

        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);

        //Close the url into browser
        driver.quit();


    }
}
