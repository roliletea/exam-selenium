package examSelenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import sun.lwawt.macosx.CPrinterDevice;

@DefaultUrl("https://playback.fm/birthday-song")
public class BrithdaySongPage extends PageObject {

    @FindBy(id="month")
    private WebElementFacade monthSelector;

    @FindBy(id="day")
    private WebElementFacade daySelector;

    @FindBy(id="year")
    private WebElementFacade yearSelector;

    @FindBy(css = ".findSong")
    private WebElementFacade searchTerms;

    public void enterBirthday(String date){
//        split a standard european format date (dd-mm-yyyy)
        String[] dayMonthYear = date.split("-");

        this.enterMonth(dayMonthYear[1]);
        this.enterDay(dayMonthYear[0]);
        this.enterYear(dayMonthYear[2]);

        this.searchTerms.click();
    }

    public String getSongDetails(){
        WebElementFacade resultContainer = find(By.cssSelector(".daySongContainer"));
        return resultContainer.findElement(By.tagName("strong")).getText();
    }

    private void enterMonth(String month){
        this.monthSelector.selectByValue(month);
    }
    private void enterDay(String day){
        this.daySelector.selectByValue(day);
    }
    private void enterYear(String year){
        this.yearSelector.selectByValue(year);
    }
}
