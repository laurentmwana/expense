package com.example.expense.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expense.R;
import com.example.expense.adapters.Holder.EventViewHolder;
import com.example.expense.controller.events.EventController;
import com.example.expense.helper.Flash;
import com.example.expense.helper.Moment;
import com.example.expense.models.entity.Event;

import java.util.ArrayList;

public class CustomListEventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private Context context;

    private  ArrayList<Event> events;

    private EventController controller;


    public CustomListEventAdapter(Context context, EventController controller) {
        this.context = context;
        this.events = controller.getFindAllEvent();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_event, parent, false);
        return  new EventViewHolder(view, controller);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Event ev = events.get(position);
        holder.mTextViewMoment.setText(Moment.moment(ev.getCreatedAt()));
        holder.mTextViewMoment.setText(Moment.moment(ev.getCreatedAt()));
        holder.mTextViewEndTime.setText(ev.getEndTime());
        holder.mTextViewAmountDailyExpense.setText(String.valueOf(ev.getAmountDailyExpense()));
        holder.mTextViewAmountDailyRecipe.setText(String.valueOf(ev.getAmountDailyRecipe()));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
