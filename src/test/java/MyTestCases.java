import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MyTestCases {
    WebDriver driver = new ChromeDriver();
    String theURL = "https://automationteststore.com/";
    String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

    Random rand = new Random();
    String TheUserName;
    String ThePassword = "Yzn@1234";
    String FirstNamee;


    @BeforeTest
    public void mySetup() {
        driver.get(theURL);

        driver.manage().window().maximize();

    }


    @Test(priority = 1 ,enabled = true)
    public void Signup() throws InterruptedException {

        driver.navigate().to(SignupPage);
        String ConfirmationMessage = "Congratulations! Your new account has been successfully created!";


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
        FirstNamee=randomFirstName;
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
        //Action
        TheUserName = randomFirstName + randomLastName + randomNumberForEmail;

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
        int TotalCountries = selectCountry.findElements(By.tagName("option")).size();
        int randomCountry = rand.nextInt(1, TotalCountries);
        selectMyCountry.selectByIndex(randomCountry);

        Thread.sleep(2000);

        //Select selectMyState= new Select(selectState);
        int numberOfOption=selectState.findElements(By.tagName("Option")).size();
        Select mySelectForTheState = new Select(selectState);
        int randomStateIndex = rand.nextInt(1, numberOfOption);
        mySelectForTheState.selectByIndex(randomStateIndex);

        PostalCodeInput.sendKeys(PostalCode);
        loginNameInput.sendKeys(TheUserName);
        passwordInput.sendKeys(ThePassword);
        passwordConfirmInput.sendKeys(ThePassword);
        agreeBoxCheck.click();

        continueClick.click();

        boolean ActualResult = driver.getPageSource().contains(ConfirmationMessage);
        Assert.assertEquals(ActualResult,true,"this is to test that the account has been created");

        Thread.sleep(2000);

        //Hello
    }
    @Test(priority = 2, enabled = false)
    public void Logout() throws InterruptedException {

        String ConfirmationLogOutMessage = " Account Logout";
        WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));

        LogoutButton.click();
        boolean ActualResult = driver.getPageSource().contains(ConfirmationLogOutMessage);
        Assert.assertEquals(ActualResult,true, "this is to test that the account has logged out");

        boolean ActualResult1 = driver.getCurrentUrl().equals("https://automationteststore.com/index.php?rt=account/logout");
        boolean ActualResult2 = true;
        Assert.assertEquals(ActualResult1,ActualResult2 );

        Thread.sleep(1000);


        //WebElement continueButton = driver.findElement(By.linkText("Continue"));
        //continueButton.click();
    }
    @Test(priority = 3, enabled = false)
    public void Login() throws InterruptedException {
        WebElement LoginAndRegisterButton = driver.findElement(By.partialLinkText("Login or register"));
        String ExpectedResult = "Welcome back "+FirstNamee;

        LoginAndRegisterButton.click();


        WebElement Loginname = driver.findElement(By.id("loginFrm_loginname"));
        WebElement passwordInput = driver.findElement(By.id("loginFrm_password"));
        Loginname.sendKeys(TheUserName);
        passwordInput.sendKeys(ThePassword);

        WebElement LoginButton = driver.findElement(By.xpath("//button[@title='Login']"));
        LoginButton.click();
        Thread.sleep(2000);
        String ActualResult = driver.findElement(By.id("customernav")).getText();
        Assert.assertEquals(ActualResult,ExpectedResult);

    }
    @Test(priority = 4,invocationCount = 1,enabled = false)

    public void AddtoCart() throws InterruptedException {
        driver.navigate().to(theURL);

        Thread.sleep(1000);
        List<WebElement> theListOfItems = driver.findElements(By.className("prdocutname"));

        int TotalNumberOfItems = theListOfItems.size();

        System.out.println(TotalNumberOfItems);

        int RandomItemIndex = rand.nextInt(2);

        theListOfItems.get(9).click();
        ;

        Thread.sleep(3000);

        WebElement AddToCartButton = driver.findElement(By.className("productpagecart"));
        if (AddToCartButton.getText().equals("Out of Stock")) {
            driver.navigate().back();
            System.out.println("sorry the item out of the stock");
        }
        else {
            if (driver.getCurrentUrl().contains("product_id=116")) {
                driver.findElement(By.xpath("//input[@id='option344748']")).click();
            }
            AddToCartButton.click();
            WebElement CheckOutButton = driver.findElement(By.linkText("Checkout"));
            CheckOutButton.click();



        }
    }



    }

