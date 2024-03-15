package steps;

import com.codeborne.selenide.ElementsCollection;
import common.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static driver.DriverFactory.currentDriver;

public class UcuslarStepDef {
    PageManager pageManager = new PageManager();
    @Then("User assert availible flights")
    public void userAssertAvailibleFlights() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(30));
        Thread.sleep(2000);
        pageManager.ucuslarPage.closePopUp.click();
        wait.until(ExpectedConditions.visibilityOf(pageManager.ucuslarPage.availibleFlights));
        pageManager.ucuslarPage.availibleFlights.shouldBe(visible);

    }

    @And("User click random depurter flight and choose flight type")
    public void userClickRandomDepurterFlightAndChooseFlightType() throws InterruptedException {

        pageManager.ucuslarPage.selectRandomDepartureFlight();
        pageManager.ucuslarPage.flyContainer.shouldBe(visible);
        pageManager.ucuslarPage.getGidisSaati();
        pageManager.ucuslarPage.chooseDepartureFlightType();

    }

    @And("User click random return flight and choose flight type")
    public void userClickRandomReturnFlightAndChooseFlightType() throws InterruptedException {
        pageManager.ucuslarPage.selectRandomReturnFlight();
        pageManager.ucuslarPage.getDonusSaati();
        pageManager.ucuslarPage.chooseReturnFlightType();
        Thread.sleep(10000);
    }
}
