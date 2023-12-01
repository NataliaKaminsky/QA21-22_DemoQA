package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstStart {

    @Test
    public void firstStartTrello()  {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
