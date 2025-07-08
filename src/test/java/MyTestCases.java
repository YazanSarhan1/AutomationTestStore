import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MyTestCases {
    WebDriver driver = new ChromeDriver();
    String theURL = "https://automationteststore.com/";
    String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

    Random rand = new Random();


    @BeforeTest
    public void mySetup() {
        driver.get(theURL);

        driver.manage().window().maximize();

    }


    @Test(priority = 1)
    public void Signup() throws InterruptedException {

        driver.navigate().to(SignupPage);

        //Elements
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
        WebElement lastNameInput= driver.findElement(By.id("AccountFrm_lastname"));
        WebElement emailInput= driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
        WebElement telephoneInput= driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
        WebElement faxInput= driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
        WebElement companyInput= driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
        WebElement address1Input= driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
        WebElement address2Input= driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
        WebElement cityInput= driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));


        WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
        WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
        WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
        WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
        WebElement agreeBoxCheck = driver.findElement(By.id("AccountFrm_agree"));
        WebElement continueClick = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
        WebElement selectCountry= driver.findElement(By.id("AccountFrm_country_id"));
        WebElement selectState=driver.findElement(By.id("AccountFrm_zone_id"));

        //Data
        String[] firstNames={"Yazan","Mohammad","Zaid","Ahmad","Tareq"};
        int randomIndexFirstName = rand.nextInt(firstNames.length);
        String randomFirstName = firstNames[randomIndexFirstName];

        String[] lastNames={"Sarhan","Assad","Khalil","Sultan","Hussein"};
        int randomIndexLastName = rand.nextInt(lastNames.length);
        String randomLastName = lastNames[randomIndexLastName];

        int randomNumberForEmail=rand.nextInt(7000);
        String email =randomFirstName+randomLastName+randomNumberForEmail+"@gmail.com";

        String telephone = "0962777555000";
        String fax = "962778";
        String company = "ABC";
        String address1 = "Amman Airport St";
        String address2 = "Amman Waves";
        String city = "Amman";
        String PostalCode = "1168";
        String password = "Yzn@1234";
        //Action
        firstNameInput.sendKeys(randomFirstName);
        lastNameInput.sendKeys(randomLastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        faxInput.sendKeys(fax);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        cityInput.sendKeys(city);

        Select selectMyCountry= new Select(selectCountry);
        selectMyCountry.selectByVisibleText("Jordan");

        Thread.sleep(2000);

        //Select selectMyState= new Select(selectState);
        int numberOfOption=selectState.findElements(By.tagName("Option")).size();
        Select mySelectForTheState = new Select(selectState);
        int randomStateIndex = rand.nextInt(1, numberOfOption);
        mySelectForTheState.selectByIndex(randomStateIndex);

        PostalCodeInput.sendKeys(PostalCode);
        loginNameInput.sendKeys(randomFirstName+randomLastName+randomNumberForEmail);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);
        agreeBoxCheck.click();
        //Thread.sleep(2000);
        //continueClick.click();

        //Hello
    }
}
