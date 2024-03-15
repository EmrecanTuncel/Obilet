package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import common.PageManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static driver.DriverFactory.currentDriver;

public class FlightTicketPage extends BasePage {


    public SelenideElement gidis = $(By.id("origin-input"));
    public SelenideElement donus = $(By.id("destination-input"));
    public SelenideElement gidisResult = $("#origin > div.results > ul > li.item");
    public SelenideElement donusResult = $("#destination > div.results > ul > li.item");


    public SelenideElement ciftYon = $(By.id("two-ways"));
    public SelenideElement departureDateButton =$("ob-datepicker2[id='checkInDate'] input[id='departure-input']");
    public SelenideElement returnDateButton =$(By.id("checkOutDate"));
    public SelenideElement calendarTable =$("table[class='month']");
    public SelenideElement departureDataDate =$("button[data-date='2024-04-20']");
    public SelenideElement returnDataDate =$("button[data-date='2024-04-25']");
    public SelenideElement flightSearchButton =$(By.id("search-button"));
    public SelenideElement from = $(By.id("departure-input"));
    public SelenideElement to = $(By.id("return-input"));

    public FlightTicketPage(String pageUrl) {
        super(pageUrl);
    }


    public void enterFlightInformation(String Gidis, String Donus) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ciftYon));
        ciftYon.doubleClick();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(gidis));
        gidis.click();
        Thread.sleep(1000);
        gidis.setValue(Gidis);
        Thread.sleep(1000);
        gidisResult.click();
        Thread.sleep(1000);
        donus.click();
        Thread.sleep(1000);
        donus.setValue(Donus);
        Thread.sleep(1000);
        donusResult.click();
        Thread.sleep(1000);

    }

    public void enterDateInformation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(returnDateButton));
        Thread.sleep(1000);
        departureDateButton.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(calendarTable));
        departureDataDate.click();
        Thread.sleep(1000);
        returnDataDate.click();

    }

    public void clickFlightSearchButton() {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(flightSearchButton));
        flightSearchButton.click();

    }

    public void fluentWait(WebDriver d, By element) {
        FluentWait<WebDriver> wait = new FluentWait<>(d)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        wait.until(webDriver ->
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            List<WebElement> e = d.findElements(element);
            return !e.isEmpty();
        });
    }

}
