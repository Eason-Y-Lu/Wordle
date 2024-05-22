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
    private String wordChoice;
    private int row;

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
        wordChoice = WordleDictionary.FIVE_LETTER_WORDS[random.nextInt(WordleDictionary.FIVE_LETTER_WORDS.length - 1)];
        System.out.println(wordChoice);
        /*for (int i = 0; i < 5; i++) {
            gw.setSquareLetter(0, i, String.valueOf(wordChoice.charAt(i)));
        }*/
    }

    /* Private instance variables */

    public void enterAction(String s) {
        boolean win = false;
        row = gw.getCurrentRow();
        s = s.toLowerCase();
        if (Arrays.asList(WordleDictionary.FIVE_LETTER_WORDS).contains(s)) {
            char[] correctLetters = wordChoice.toCharArray();
            char[] answerLetters = s.toCharArray();
            for (int i = 0; i < 5; i++) {
                if (answerLetters[i] == correctLetters[i]) {
                    gw.setSquareColor(row, i, WordleGWindow.CORRECT_COLOR);
                } else if (wordChoice.indexOf(answerLetters[i]) != -1) {
                    gw.setSquareColor(row, i, WordleGWindow.PRESENT_COLOR);
                } else {
                    gw.setSquareColor(row, i, WordleGWindow.MISSING_COLOR);
                    gw.setKeyColor(Character.toString(answerLetters[i]).toUpperCase(), WordleGWindow.MISSING_COLOR);
                }
            }
            if (row < 6) {
                gw.setCurrentRow(row + 1);
            } else {
                gw.showMessage("The correct word is:" + wordChoice);
            }
        } else {
            gw.showMessage("Not in word list.");
        }
    }

}
