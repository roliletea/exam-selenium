package examSelenium.stories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import examSelenium.steps.EndUserSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class MyBirthdaySongStory {

    private static final int SECONDS_TO_KEEP_PAGE_OPEN = 10;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps student;

    @Test
    public void searching_for_my_birthday_song() {

        // the student goes to the birthday songs page
        student.open_birthday_songs_page();

        // he retrieves his corresponding birthday song (full name)
        // ...
        student.enterBirthday("25-1-1998");
        String resultSong = student.lookForResults();
        System.out.println(resultSong);

        // he open the article with the top 100 songs of all time
        student.open_best_songs_of_all_time_page();

        List<String> bestSongs = student.getAllBestSongTitles();

        for(String song : bestSongs){
            System.out.println(song);
        }

        // he checks if his songs is in the top (simply tries to match the full name)
        // and then prints the appropriate message in the console
        // ...

        // he goes on Wikipedia
        student.open_wikipedia_page();

        // he searches for the song there aswell and opens the first result
        // ...

        // keep the page open al little longer after the process is over
        waitForIt(SECONDS_TO_KEEP_PAGE_OPEN);

    }

    private void waitForIt(int secondsToWait)
    {
        try {
            TimeUnit.SECONDS.sleep(secondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
