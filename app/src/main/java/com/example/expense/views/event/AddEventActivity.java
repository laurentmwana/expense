package com.example.expense.views.event;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.example.expense.R;
import com.example.expense.controller.events.AddEventController;
import com.example.expense.views.shared.SharedActionBar;

public class AddEventActivity extends AppCompatActivity {

    private String title = "Ajouter un évènement";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        init();
    }

    private void init() {

        SharedActionBar.back(this, title);

        // on initialise le controller
        (new AddEventController(this)).init();
    }
}