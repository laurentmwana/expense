package com.example.expense.views.shared;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public abstract class SharedActionBar {

    public static void back(AppCompatActivity context, String title) {
        // on modifie le titre de l'activité
        ActionBar actionBar = context.getSupportActionBar();
        actionBar.setTitle(title);
        // activation du bouton back (retour vers l'activité précédente
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public static void title(AppCompatActivity context, String title) {
        // on modifie le titre de l'activité
        ActionBar actionBar = context.getSupportActionBar();
        actionBar.setTitle(title);
    }

    public static void onlyBack(AppCompatActivity context) {
        // activation du bouton back (retour vers l'activité précédente
        context.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
