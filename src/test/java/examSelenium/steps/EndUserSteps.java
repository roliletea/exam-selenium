package examSelenium.steps;

import examSelenium.pages.BestSongsOfAllTimePage;
import examSelenium.pages.BrithdaySongPage;
import examSelenium.pages.WikipediaPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    BrithdaySongPage birthdaySongPage;
    BestSongsOfAllTimePage bestSongsOfAllTimePage;
    WikipediaPage wikipediaPage;

    @Step
    public void open_birthday_songs_page() {
        birthdaySongPage.open();
    }

    @Step
    public void enterBirthday(String date) { this.birthdaySongPage.enterBirthday(date); }

    @Step
    public String lookForResults() { return this.birthdaySongPage.getSongDetails(); }

    @Step
    public void open_best_songs_of_all_time_page() {
        bestSongsOfAllTimePage.open();
    }

    @Step
    public List<String> getAllBestSongTitles(){
        return this.bestSongsOfAllTimePage.getSongNames();
    }


    @Step
    public void open_wikipedia_page() {
        wikipediaPage.open();
    }

    @Step
    public void searchSongName(String songName){
        wikipediaPage.enter_keywords(songName);
    }
}
