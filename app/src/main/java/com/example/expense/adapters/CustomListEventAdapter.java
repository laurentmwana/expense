package com.example.expense.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expense.R;
import com.example.expense.models.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class CustomListEventAdapter extends RecyclerView.Adapter<CustomListEventAdapter.ViewHolder> {
    private final Context context;

    private  ArrayList<Event> events;

    public CustomListEventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_event, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

        }

    }

}
