package com.netflix;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String favMovie = "Project Hail Mary";
        ArrayList<String> moreFavMovies = new ArrayList<>();
        moreFavMovies.add("Tron (2010)");
        moreFavMovies.add("Wonka");
        String favMovieGenre = "Sci-F";
        int movieReleaseYear = 2026;
        float movieDurationInMinutes = 156f;
        float movieWatchAmount = 1f;
        String favStreamingPlatform = "Pirating";
        float hoursPerWeekWatching = 0F;
        float myMovieRating = 9f;
        String funFactAboutMyMoviePreferences = "I bult my own home server to stream movies/tv shows";

        System.out.println("==========================================================");
        System.out.println("            My Movie & Streaming Profile \uD83C\uDF7F");
        System.out.println("==========================================================");
        System.out.printf("""
                        Favorite Movie: %s
                        Favorite Movie Genre: %s
                        Movie Release Year: %d
                        Movie Duration in Minutes: %.2f
                        Amount of Times I've Watched the Movie: %.2f
                        Favorite Streaming Platform: %s
                        Amount of Hours per Week I Spend Watching Movies/Series: %.2f
                        My Movie Rating(1-10): %.2f
                        Interesting Fact About my Movie Preferences: %s
                        More Favorite Movies: %s
                        """
                        ,favMovie, favMovieGenre, movieReleaseYear, movieDurationInMinutes, movieWatchAmount
                        ,favStreamingPlatform, hoursPerWeekWatching, myMovieRating, funFactAboutMyMoviePreferences, moreFavMovies);

        System.out.println("==========================================================");

    }
    }