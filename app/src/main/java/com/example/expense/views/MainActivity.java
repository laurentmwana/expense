package com.example.expense.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.expense.R;
import com.example.expense.views.shared.SharedActionBar;
import com.example.expense.views.shared.SharedMenuItem;

public class MainActivity extends AppCompatActivity {

    private String title = "Tableau de bord";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedMenuItem.menus(MainActivity.this, item);
        return true;
    }

    private void init() {

        SharedActionBar.title(this, title);

    }
}