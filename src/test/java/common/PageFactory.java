package common;

import pages.FlightTicketPage;
import pages.HomePage;
import pages.OdemePage;
import pages.UcuslarPage;

public class PageFactory {

    public static HomePage buildLoginPage() {
        return new HomePage("/");
    }
    public static FlightTicketPage buildFlightTicketPage() {
        return new FlightTicketPage("/inventory.html");
    }
    public static UcuslarPage buildUcuslarPage() {
        return new UcuslarPage("/inventory.html");
    }
    public static OdemePage buildOdemePage() {
        return new OdemePage("/inventory.html");
    }



}
