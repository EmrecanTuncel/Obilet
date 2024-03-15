package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import driver.DriverFactory;
import org.testng.Assert;
import utils.PropertyManager;

import static driver.DriverFactory.currentDriver;

public abstract class BasePage {

    protected String pageUrl;
    PropertyManager propertyManager = new PropertyManager();

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        String url = propertyManager.getProperty("APP_URL") ;
        Selenide.open(url);
        String URL = currentDriver ( ).getCurrentUrl ( );
        Assert.assertEquals(URL, "https://www.obilet.com/" );
    }


}
