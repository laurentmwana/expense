package com.example.expense.controller.events;

import com.example.expense.models.entity.Event;
import com.example.expense.views.event.UpdateEventActivity;

public class UpdateEventController {

    private UpdateEventActivity context;

    public UpdateEventController(UpdateEventActivity context) {

        this.context = context;
    }

    public Event getFindEvent(String id) {


        return  new Event();
    }
}
