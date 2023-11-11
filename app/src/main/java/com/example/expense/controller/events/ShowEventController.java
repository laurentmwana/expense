package com.example.expense.controller.events;

import com.example.expense.exception.NotFoundException;
import com.example.expense.models.entity.Event;
import com.example.expense.models.repository.EventRepository;
import com.example.expense.views.event.show.ShowEventActivity;

public class ShowEventController {

    private ShowEventActivity context;

    private EventRepository repository;

    public ShowEventController(ShowEventActivity context) {

        this.context = context;


        this.repository = new EventRepository(context);
    }

    public Event getFindEvent(String id) throws NotFoundException {

        return repository.find(id);

    }
}
