package com.example.expense.views.event.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.expense.R;
import com.example.expense.controller.events.ShowEventController;
import com.example.expense.helper.Flash;
import com.example.expense.models.entity.Event;
import com.example.expense.views.shared.SharedActionBar;
import com.example.expense.views.shared.SharedMenuItem;

public class ShowEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_event_show_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedMenuItem.menuEventShow(ShowEventActivity.this, item);
        return super.onOptionsItemSelected(item);
    }

    private void init() {

        try {
            ShowEventController controller = new ShowEventController(this);

            Bundle bundle = getIntent().getExtras();

            // on recupère l'id de l'évènement
            String id = bundle.get("id").toString();

            // on modifie le titre du menu
            SharedActionBar.back(this, "Evenement #" + id);

            Event ev = controller.getFindEvent(id);

            Flash.modal(this, ev.getStartTime() + "");
        }catch (Exception e) {
            Flash.modal(this, e.getMessage());
        }


    }

    private void addListeners() {

    }
}