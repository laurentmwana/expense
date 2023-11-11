package com.example.expense.controller.events;

import android.view.View;
import android.widget.AdapterView;

import com.example.expense.helper.Flash;
import com.example.expense.models.entity.Event;
import com.example.expense.models.repository.EventRepository;
import com.example.expense.views.event.EventActivity;

import java.util.ArrayList;

public class EventController {

    private final EventActivity context;

    private final EventRepository repository;


    /**
     * Constructor
     * @param context
     */
    public EventController(EventActivity context) {

        this.context = context;

        this.repository = new EventRepository(context);
    }

    public ArrayList<Event> getFindAllEvent() {
        ArrayList<Event> events = null;
        try {
            events = repository.findAll();
        }catch (Exception e) {
            Flash.modal(context, e.getMessage());
        }
        return events;
    }
}
