import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
    WebDriver driver = new ChromeDriver();
    String theURL = "https://automationteststore.com/";
    String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

    @BeforeTest
    public void mySetup() {
        driver.get(theURL);

        driver.manage().window().maximize();

    }


    @Test(priority = 1)
    public void Signup() {

        driver.navigate().to(SignupPage);

        //Elements
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
        WebElement lastName= driver.findElement(By.id("AccountFrm_lastname"));
        WebElement email= driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
        WebElement telephone= driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
        WebElement fax= driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
        WebElement company= driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
        WebElement address1= driver.findElement(By.xpath("//input[@id='AccountFrm_address1']"));
        WebElement address2= driver.findElement(By.xpath("//input[@id='AccountFrm_address2']"));
        WebElement city= driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));

        //Actions
        firstName.sendKeys("Yazan");
        lastName.sendKeys("Sarhan");
        email.sendKeys("yazan@yahoo.com");
        telephone.sendKeys("00962788997711");
        fax.sendKeys("0011");
        company.sendKeys("ABC");
        address1.sendKeys("Amman");
        address2.sendKeys("Airport St");
        city.sendKeys("Amman");




        //Hello
    }
}
