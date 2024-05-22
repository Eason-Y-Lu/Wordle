/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

import java.util.Arrays;
import java.util.Random;

public class Wordle {

    private WordleGWindow gw;

    /*
     * Called when the user hits the RETURN key or clicks the ENTER button,
     * passing in the string of characters on the current row.
     */

    public static void main(String[] args) {
        new Wordle().run();
    }

    /* Startup code */

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
        Random random = new Random();
        String wordChoice = WordleDictionary.FIVE_LETTER_WORDS[random.nextInt(WordleDictionary.FIVE_LETTER_WORDS.length - 1)];
/*        System.out.println(wordChoice);
        for (int i = 0; i < 5; i++) {
            gw.setSquareLetter(0, i, String.valueOf(wordChoice.charAt(i)));
        }*/
    }

    /* Private instance variables */

    public void enterAction(String s) {
        if (Arrays.asList(WordleDictionary.FIVE_LETTER_WORDS).contains(s)) {
            return;
        } else {
            gw.showMessage("Not in word list.");
        }
    }

}
