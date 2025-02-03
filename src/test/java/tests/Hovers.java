package tests;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.List;

public class Hovers {

    @Test
    public void hoversTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
        SoftAssert softAssert = new SoftAssert();

        Actions act = new Actions(driver);

        List<WebElement> userProfile = driver.findElements(By.xpath("//*[@class=\"figure\"]"));
        for (WebElement element : userProfile){
            act.moveToElement(element).perform();
            Thread.sleep(1000);

            WebElement clickUser1 = driver.findElement(By.linkText("View profile"));
            act.moveToElement(clickUser1).click().perform();
            Thread.sleep(1000);

            softAssert.assertNotEquals(driver.findElement(By.cssSelector("h1")).getText(), "Not Found");
            driver.navigate().back();
            Thread.sleep(1000);
        }
        }
    }

