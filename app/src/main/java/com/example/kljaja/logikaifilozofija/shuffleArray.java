package com.example.kljaja.logikaifilozofija;

import java.util.Random;

/**
 * Created by kljaja on 08-Feb-17.
 */

public class shuffleArray {
    static void shuffle(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
