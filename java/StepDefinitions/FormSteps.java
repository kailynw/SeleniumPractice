package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import static StepDefinitions.LoginSteps.driverWait;
import static org.junit.Assert.assertEquals;

public class FormSteps {
    WebDriver driver;
    JavascriptExecutor js;
    String username;
    String password;

    public FormSteps(){
        //Config
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"/src/test/drivers/geckodriver");
        this.driver=new FirefoxDriver();
        this.js= (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("The user selects their country using the select box")
    public void the_user_selects_their_country_using_the_select_box() {
        this.login();
        Select country= new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("Uruguay");
    }

    @Then("enters their address")
    public void enters_their_address() {
        System.out.println("Enter Address");
        driver.findElement(By.id("address")).sendKeys(("301 Clams Drive, Richmond VA"));
    }

    @Then("enters their email")
    public void enters_their_email() {
        driver.findElement(By.id("email")).sendKeys(("james333@gmail.com"));
    }

    @Then("enters their phone")
    public void enters_their_phone() {
        driver.findElement(By.id("phone")).sendKeys(("377-883-3872"));
    }

    @Then("clicks the save button")
    public void clicks_the_save_button() throws InterruptedException {
        driver.findElement(By.id("save")).click();
        driverWait(driver, 1000);
    }

    @Then("success text is displayed")
    public void success_text_is_displayed() throws InterruptedException {
        String successText= driver.findElement(By.className("tp-saved")).getText();
        String expected= "Saved";
        assertEquals(expected,successText);
        driverWait(driver,2000);
        driver.close();
    }

    public void login(){
        this.username="Kailyn Williams";
        this.password="12345";
        driver.get("http://example.testproject.io/web/");
        driver.findElement(By.id("name")).sendKeys(this.username);
        driver.findElement(By.id("password")).sendKeys(this.password);
        driver.findElement(By.id("login")).click();
    }


}



