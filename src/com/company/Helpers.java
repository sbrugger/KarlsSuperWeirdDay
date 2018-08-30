package com.company;

/**
 * Created by Sarah on 8/9/18.
 */
public class Helpers {
    public static void waitForMilliseconds(int milliseconds) {
        try {Thread.sleep(milliseconds);} catch (InterruptedException e) {}
    }
}
