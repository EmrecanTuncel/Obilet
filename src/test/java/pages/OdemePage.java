package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class OdemePage extends BasePage {
    public OdemePage(String pageUrl) {
        super(pageUrl);
    }

    public SelenideElement checkGidisSaati = $(By.xpath("(//td[@class='departure'])[1]"));
    public SelenideElement checkDonusSaati = $(By.xpath("(//td[@class='departure'])[3]"));

    public String getCheckGidisSaati() {
        String a = checkGidisSaati.getText();
        System.out.println(a);
        return a;
    }

    public String getCheckDonusSaati() {
        String b = checkDonusSaati.getText();
        System.out.println(b);
        return b;
    }




}