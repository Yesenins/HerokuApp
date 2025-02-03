package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {

    @Test
    public void inputsHerokuAppTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys("88");

        String actualText = inputField.getDomProperty("value");
        Assert.assertEquals(actualText, "88");
        Thread.sleep(1000);
        inputField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(1000);
        String actualTextUp = inputField.getDomProperty("value");
        Assert.assertEquals(actualTextUp, "89");

        for (int i = 0; i < 8; i++){
            inputField.sendKeys(Keys.ARROW_DOWN);
        }
        String actualTextDown = inputField.getDomProperty("value");
        Assert.assertEquals(actualTextDown, "81");
    }
}
