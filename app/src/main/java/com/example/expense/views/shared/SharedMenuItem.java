package com.example.expense.views.shared;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.expense.R;
import com.example.expense.views.MainActivity;
import com.example.expense.views.event.AddEventActivity;
import com.example.expense.views.event.EventActivity;

public abstract class SharedMenuItem {

    /**
     *  Les items du menu (Event)
     * @param eventActivity
     * @param item
     */
    public static void menuEvent(EventActivity eventActivity, MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_event_add) {
            Intent intent = new Intent(eventActivity, AddEventActivity.class);
            eventActivity.startActivity(intent);
        }
    }

    /**
     * Les items global
     * @param c
     * @param item
     */
    public static void menus(Context c, MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_item_event) {
            Intent intent = new Intent(c, EventActivity.class);
            c.startActivity(intent);
        }
    }
}
