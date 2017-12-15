import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BananaSong {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.id("gs_htif0"));
        Actions make  = new Actions(driver);
        Action kbEvents = make.sendKeys("Banana song").build();
        kbEvents.perform();
        driver.findElement(By.xpath(".//*[@name='btnK']")).click();
        driver.findElement(By.xpath(".//*[@href='https://www.youtube.com/watch?v=wCkerYMffMo']")).click();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        if (driver.findElement(By.xpath("//*[@id='logo']")).isDisplayed()!=true){
            throw new RuntimeException("Мы не на Ютубе");
        }
        String times=driver.findElement(By.xpath("//*[@id='count']/yt-view-count-renderer/span[1]")).getText();
      String s=times.replaceAll("\\D","");
             if (Integer.parseInt(s)<50000000){
            throw new RuntimeException("Мы не то видео смотрим");
        }
    Boolean myDynamicElement = (new WebDriverWait(driver, 50))
                    .until(ExpectedConditions.textToBe(By.xpath("//span[@class='ytp-time-current']"),"0:49"));
            driver.close();

    }
}