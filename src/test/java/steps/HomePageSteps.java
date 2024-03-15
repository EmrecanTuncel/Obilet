package steps;

import common.PageManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;


import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.google.gson.internal.bind.TypeAdapters.URL;
import static driver.DriverFactory.currentDriver;

public class HomePageSteps extends BaseTest {


    PageManager pageManager = new PageManager();

    @Given("Open the web site and assert {string} website")
    public void openTheWebSiteAndAssertHttpsWwwObiletComWebsite(String URL) throws InterruptedException {
        Thread.sleep(5000);
        pageManager.homePage.open();
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(URL));
    }


    @When("Click Login Button")
    public void clickLoginButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pageManager.homePage.loginButton));
        pageManager.homePage.loginButton.doubleClick();

    }
    @Then("assert pop-up text {string}")
    public void assertPopUpTextUyeGirisi(String text) throws InterruptedException {
        Thread.sleep(5000);
        pageManager.homePage.popUpCheck.shouldHave(exactText(text));
        Thread.sleep(1000);
    }

    @And("Click sign up button")
    public void clickSignUpButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pageManager.homePage.signUpButton));
        pageManager.homePage.signUpButton.click();
    }


    @Then("User enters {string} and {string} and Click register button")
    public void userEntersMailAndPasswordAndClickRegisterButton(String mail, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pageManager.homePage.signUpButton2));
        pageManager.homePage.enterMailPassword(mail, password);
        pageManager.homePage.signUpButton2.click();
    }

    @Then("User assert profile part is visible")
    public void userAssertProfilePartIsVisible() throws InterruptedException {
        pageManager.homePage.profilePart.shouldBe(visible);
        Thread.sleep(1000);
    }


    @When("Click flight button and assert {string} website")
    public void clickFlightButtonAndAssertWebsite(String URL) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable( pageManager.homePage.flightButton));
        pageManager.homePage.flightButton.click();
        Assert.assertEquals(URL, "https://www.obilet.com/ucak-bileti" );
    }

}
