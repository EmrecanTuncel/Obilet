package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static driver.DriverFactory.currentDriver;

public class UcuslarPage extends BasePage {

    public UcuslarPage(String pageUrl) {
        super(pageUrl);
    }

    public SelenideElement availibleFlights = $(("div[class='airlines col ']"));
    public SelenideElement closePopUp = $("span[class='ins-close-button']");
    public SelenideElement flyContainer = $("div[class='fly-container']");

    public SelenideElement ecoFly = $(By.xpath("//*[contains(text(),'Ecofly (EF)')]"));
    public SelenideElement returnEcoFly = $(By.xpath("(//*[contains(text(),'Ecofly (EF)')])[3]"));

    public SelenideElement otherFly = $(By.xpath("(//div[@class='fly-container'])[2]"));
    public SelenideElement returnFly = $(By.xpath("(//div[@class='fly-container'])[5]"));


    public void chooseDepartureFlightType() {
        if (ecoFly.isDisplayed()) {
            ecoFly.click();
        } else {
            otherFly.click();
        }
    }

    public void chooseReturnFlightType() {
        if (returnEcoFly.isDisplayed()) {
            returnEcoFly.click();
        } else {
            returnFly.click();
        }
    }

    public void selectRandomDepartureFlight() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(availibleFlights));
        Random random = new Random();
        ElementsCollection flights = $$("ul[id='outbound-journeys'] div[class='airlines col ']");
        int result = random.nextInt(flights.size());
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(availibleFlights));
        flights.get(result).click();

    }

    public void selectRandomReturnFlight() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(availibleFlights));
        Random random = new Random();
        ElementsCollection flights = $$("ul[id='return-journeys'] div[class='airlines col ']");
        int result = random.nextInt(flights.size());
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(availibleFlights));
        flights.get(result).click();

    }

    public static String time1 = null;
    public static String getGidisSaati() {
        SelenideElement gidisSaatiElement = $("li[class='item journey one-way available open'] div[class='journey row'] div[class='departure']").shouldBe(visible);
        time1 = gidisSaatiElement.getText();
        return gidisSaatiElement.getText();
    }

    public static String time2 = null;
    public static String getDonusSaati() {
        SelenideElement donusSaatiElement = $("li[class='item journey one-way available open'] div[class='journey row'] div[class='departure']").shouldBe(visible);
        time2 = donusSaatiElement.getText();
        return donusSaatiElement.getText();
    }



}
