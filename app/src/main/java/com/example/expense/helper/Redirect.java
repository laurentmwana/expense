package com.example.expense.helper;

import android.content.Context;
import android.content.Intent;

public abstract class Redirect {


    /**
     * Permet de faire une redirection
     *
     * @param start
     * @param end
     */
    public static void route(Context start, Class end) {
        Intent intent = new Intent(start, end);
        start.startActivity(intent);
    }
}
