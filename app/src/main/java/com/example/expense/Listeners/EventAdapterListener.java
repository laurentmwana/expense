package com.example.expense.Listeners;

import android.view.View;
import android.widget.AdapterView;

import com.example.expense.helper.Redirect;
import com.example.expense.views.event.show.ShowEventActivity;
import com.example.expense.views.event.UpdateEventActivity;

import java.util.Objects;

public class EventAdapterListener implements AdapterView.OnItemSelectedListener {

    private String identified = "2";

    private String[] labels = {"", "Voir plus", "Editer", "Supprimer"};


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        int index = (int) id;
        String v = labels[index];
        if (Objects.equals(v, labels[1])) {
            // on fait une redirection vers l'activité show
            Redirect.route(view.getContext(), ShowEventActivity.class, "id", identified);
        } else if (Objects.equals(v, labels[2])) {
            // on fait une redirection vers l'activité d'edition
            Redirect.route(view.getContext(), UpdateEventActivity.class, "id", identified);

        } else if (v == labels[3]) {
            // on fait supprimer le event dans l'activité
            Redirect.route(view.getContext(), ShowEventActivity.class);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
