package com.example.expense.views.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.expense.R;
import com.example.expense.adapters.CustomListEventAdapter;
import com.example.expense.controller.events.EventController;
import com.example.expense.helper.Flash;
import com.example.expense.views.shared.SharedActionBar;
import com.example.expense.views.shared.SharedMenuItem;

public class EventActivity extends AppCompatActivity {

    private String title = "Evènement";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_event_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedMenuItem.menuEvent(EventActivity.this, item);
        return true;
    }

    private void init() {

        SharedActionBar.back(this, title);

        try {
            // on initialise le controller
            EventController controller = new EventController(this);

            // on personnalise le RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_event);
            recyclerView.setAdapter(new CustomListEventAdapter(this, controller));

        }catch (Exception e) {
            Flash.modal(this, e.getMessage());
        }
    }
}