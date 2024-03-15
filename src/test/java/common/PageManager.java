package common;

import driver.DriverFactory;
import pages.FlightTicketPage;
import pages.HomePage;
import pages.OdemePage;
import pages.UcuslarPage;

public class PageManager {
    public HomePage homePage;
    public FlightTicketPage flightTicketPage;
    public UcuslarPage ucuslarPage;
    public OdemePage odemePage;

    public PageManager() {

        DriverFactory.initDriver();

        homePage = PageFactory.buildLoginPage();
        flightTicketPage = PageFactory.buildFlightTicketPage();
        ucuslarPage=PageFactory.buildUcuslarPage();
        odemePage=PageFactory.buildOdemePage();

    }
}
