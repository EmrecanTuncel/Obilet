package steps;

import common.PageManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UcuslarPage;

import java.time.Duration;

import static driver.DriverFactory.currentDriver;

public class OdemeStepDef {
    PageManager pageManager = new PageManager();

    @Then("User assert tickets")
    public void userAssertTickets() {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(pageManager.odemePage.checkDonusSaati));
        String expectedGidisSaati = pageManager.odemePage.getCheckGidisSaati();
        String expectedDonusSaati = pageManager.odemePage.getCheckDonusSaati();
        String time1 = UcuslarPage.time1;
        System.out.println(time1);
        String time2 = UcuslarPage.time2;
        System.out.println(time2);


        if (expectedGidisSaati.contains(time1) && expectedDonusSaati.contains(time2)) {
            System.out.println("BAŞARILI");
        } else {
            System.out.println("BAŞARISIZ");
        }



    }
}
