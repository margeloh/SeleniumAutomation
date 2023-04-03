package org.examples.tests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MyStepdefs_SE_Automation {
    WebDriver driverObj;
    @Given("I open Chrome")
    public void iOpenChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driverObj = new ChromeDriver(options);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driverObj.manage().window();

    }
     @When("I open practice form webpage")
    public void iOpenAutomationExploreInTheSameBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driverObj.get("https://automationexplore.com/selenium-automation-practice-page/");
    }

    @Then("I enter my name")
    public void iEnterMyName() {
        driverObj.manage().deleteAllCookies();
        driverObj.findElement(By.id("firstname")).sendKeys("Mari");
        driverObj.findElement(By.id("lastname")).sendKeys("Maasikas");
    }

    @And("I enter my email")
    public void iEnterMyEmail() {
        driverObj.findElement(By.id("email")).sendKeys("Mari.Maasikas@gmail.com");
    }

    @And("I choose Gender and Profession")
    public void iChooseGenderAndProfession() {
        driverObj.findElement(By.xpath("//input[@value = 'female']")).click();
        driverObj.findElement(By.xpath("//input[@value ='Student']")).click();
    }

    @And("I enter country and skill")
    public void iEnterCountryAndSkill() {
        Select country = new Select(driverObj.findElement(By.name("country")));
        country.selectByVisibleText("USA");
        Select skill = new Select(driverObj.findElement(By.id("skillsmultiple")));
        skill.selectByVisibleText("Manual Testing");
    }

    @And("I click the button")
    public void iClickTheButton() {
        driverObj.findElement(By.id("alertbutton")).click();
        Alert alertObj = driverObj.switchTo().alert();
        alertObj.accept();
    }
}
