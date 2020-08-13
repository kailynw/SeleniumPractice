package StepDefinitions;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver;
    Scenario scenario;
    JavascriptExecutor js;
    String username;
    String password;

    public LoginSteps(){
        //Config
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"/src/test/drivers/geckodriver");
        this.driver=new FirefoxDriver();
        this.js= (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        this.username="Kailyn Williams";
        this.password="12345";
        driver.get("http://example.testproject.io/web/");
        //Enter name and password
        driverWait(driver,2000);
        driver.findElement(By.id("name")).sendKeys(this.username);
        driverWait(driver,1000);
        driver.findElement(By.id("password")).sendKeys(this.password);
        driverWait(driver,1000);
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        driverWait(driver,3000);
    }

    @Then("They are logged in")
    public void they_are_logged_in() {
        String loginConfirmation= driver.findElement(By.id("greetings")).getText();
        final String expected= "Hello "+ this.username +", let's complete the test form:";
        assertEquals(expected,loginConfirmation);
        driver.close();
    }



    /** SCENARIO 2**/
    @Given("user enters incorrect username and password")
    public void user_enters_incorrect_username_and_password() throws InterruptedException {
        this.username="Kailyn Williams";
        this.password="1234";
        driver.get("http://example.testproject.io/web/");
        driverWait(driver,2000);
        driver.findElement(By.id("name")).sendKeys(this.username);
        driverWait(driver,1000);
        driver.findElement(By.id("password")).sendKeys(this.password);
        driverWait(driver,1000);
    }


    @Then("an unauthorized error appears and they are not logged in")
    public void an_unauthorized_error_appears_and_they_are_not_logged_in() {
        String validationText= driver.findElement(By.xpath("//div[@class='invalid-feedback' and text()='Password is invalid']")).getText();
        final String expected="Password is invalid";
        assertEquals(expected,validationText);
        driver.close();
    }

    public static void driverWait(WebDriver driver,int time) throws InterruptedException {
        synchronized (driver) {
            driver.wait(time);
        }
    }
}
// throw new io.cucumber.java.PendingException();
