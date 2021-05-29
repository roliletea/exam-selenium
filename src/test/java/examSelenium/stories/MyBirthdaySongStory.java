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

    private static final int SECONDS_TO_KEEP_PAGE_OPEN = 5;

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

//        to match with Let It Be by The Beatles, the date has to be 11-4-1970

        student.enterBirthday("11-4-1970");
        String resultSong = this.adaptResultToListFormat(student.lookForResults());
        System.out.println(resultSong);

        // he open the article with the top 100 songs of all time
        student.open_best_songs_of_all_time_page();

        List<String> bestSongs = student.getAllBestSongTitles();


        // he checks if his songs is in the top (simply tries to match the full name)
        // and then prints the appropriate message in the console
        // ...
        if(this.isSongInList(resultSong, bestSongs))
            System.out.println("The Song is in the list!");
        else{
            System.out.println("Sadly, the song is not in the list...");
        }

        // he goes on Wikipedia
        student.open_wikipedia_page();



        // he searches for the song there aswell and opens the first result
        // ...

        //searching by song title, omitting the artist
        student.searchSongName(resultSong.split("-")[0]);

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

    private String adaptResultToListFormat(String resultSong){
        return String.join("-", resultSong.split("by"));
    }

    private Boolean isSongInList(String resultSong, List<String> songList){
        String[] comparisonItem = resultSong.split(" - ");

        for(String song: songList){
            String[] listItem = song.split(" \u2014 ");

            if(listItem[0].contains(comparisonItem[0]) && listItem[1].contains(comparisonItem[1])) return true;
        }
        return false;
    }


}
