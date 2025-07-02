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
        firstName.sendKeys("Yazan");
        WebElement lastName= driver.findElement(By.id("AccountFrm_lastname"));
        lastName.sendKeys("Sarhan");
        WebElement email= driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
        email.sendKeys("yazan@yahoo.com");
        WebElement telephone= driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
        telephone.sendKeys("00962788997711");
        WebElement fax= driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
        fax.sendKeys("0011");
        WebElement company= driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
        company.sendKeys("ABC");
        WebElement address1= driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
        address1.sendKeys("Amman");
        WebElement address2= driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
        address2.sendKeys("Airport St");
        WebElement city= driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
        city.sendKeys("Amman");





        //Hello
    }
}
