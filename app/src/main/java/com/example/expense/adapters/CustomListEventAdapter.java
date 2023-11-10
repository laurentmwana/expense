package com.example.expense.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expense.R;
import com.example.expense.adapters.Holder.EventViewHolder;
import com.example.expense.models.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class CustomListEventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private final Context context;

    private  ArrayList<Event> events;

    public CustomListEventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_event, parent, false);
        return  new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Event ev = events.get(position);

        holder.mTextViewMoment.setText("Aujourd'hui");
        holder.mTextViewStartTime.setText(ev.getStartTime());
        holder.mTextViewEndTime.setText(ev.getEndTime());
        holder.mTextViewAmountDailyExpense.setText(String.valueOf(ev.getAmountDailyExpense()));
        holder.mTextViewAmountDailyRecipe.setText(String.valueOf(ev.getAmountDailyRecipe()));
    }


    @Override
    public int getItemCount() {
        return events.size();
    }
}
