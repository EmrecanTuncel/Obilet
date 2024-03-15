package steps;

import common.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;

import java.time.Duration;

import static com.google.gson.internal.bind.TypeAdapters.URL;
import static driver.DriverFactory.currentDriver;

public class FlightTicketStepDef extends BaseTest {
    PageManager pageManager = new PageManager();
    @When("Click the flight button and assert {string} website")
    public void clickTheFlightButtonAndAssertHttpsWwwObiletComUcakBiletiWebsite(String URL) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable( pageManager.homePage.flightButton));
        pageManager.homePage.flightButton.click();
        Assert.assertEquals(URL, "https://www.obilet.com/ucak-bileti" );
    }

    @And("Users enters From {string} to {string}")
    public void usersEntersFromGidisToDonus(String Gidis, String Donus) throws InterruptedException {
        pageManager.flightTicketPage.enterFlightInformation(Gidis,Donus);
    }

    @Then("User click ChenckInDate and CheckOutDate")
    public void userClickChenckInDateAndCheckOutDate() throws InterruptedException {
        pageManager.flightTicketPage.enterDateInformation();
    }

    @And("User click the flight search button")
    public void userClickTheFlightSearchButton() {
        pageManager.flightTicketPage.clickFlightSearchButton();
    }
}
