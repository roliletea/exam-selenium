package examSelenium.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.thedelite.com/best-songs-of-all-time-according-to-critics-and-fans")
public class BestSongsOfAllTimePage extends PageObject {

    public List<String> getSongNames() {
        List<WebElementFacade> slides = findAll(By.tagName("h2"));
        return slides.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}
