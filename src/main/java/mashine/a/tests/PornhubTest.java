package mashine.a.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PornhubTest implements Runnable {
    private WebDriver driver;

    public PornhubTest(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.get("https://www.pornhub.com/");

        List<WebElement> elements = driver.findElements(By.xpath("//img[contains(@class, 'js-videoThumb')]"));

        for (WebElement element : elements) {
            System.out.println(element.getAttribute("href"));
        }


        driver.quit();
    }
}
