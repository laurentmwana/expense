package com.example.expense.controller.events;

import android.view.View;
import android.widget.Button;

import com.example.expense.controller.ControllerInterface;
import com.example.expense.models.repository.EventRepository;
import com.example.expense.views.event.EventActivity;

public class DeleteEventController implements ControllerInterface {

    private EventActivity context;

    private Button mButtonDelete;

    private EventRepository eventRepository;

    public DeleteEventController(EventActivity context) {

        this.context = context;

        this.eventRepository = new EventRepository(context);
    }

    @Override
    public void init() {

        addListeners();
    }

    private void addListeners() {
        mButtonDelete.setOnClickListener(this::onDelete);
    }

    private void onDelete(View view) {
    }
}
