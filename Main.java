import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Main {

    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"/src/drivers/geckodriver");

        //Set Gecko Driver for Firefox
        WebDriver driver=new FirefoxDriver();
        JavascriptExecutor js= (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Go to Destination
        driver.get("https://www.google.com");

        //Type in Search Bar
        WebElement searchBar= driver.findElement(By.name("q"));
        searchBar.sendKeys("ohh yoo");
        driverWait(driver,4000);
        searchBar.sendKeys(" my name is kailyn");
        driverWait(driver,4000);

        //Submit Search
        driver.findElement(By.name("btnK")).submit();
        driverWait(driver,4000);

//        //Go through 5 pages
//        for(int i=0;i<5;i++){
//            for(int j=0; j<3;j++){
//                js.executeScript("window.scrollBy(0, 1000)");
//                driverWait(driver,500);
//            }
//
//            driver.findElement(By.id("pnnext")).click();
//            driverWait(driver,4000);
//        }


        //closing the browser
        driver.close();
    }

    public static void driverWait(WebDriver driver,int time) throws InterruptedException {
        synchronized (driver) {
            driver.wait(2000);
        }
    }

}
