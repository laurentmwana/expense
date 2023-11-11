package com.example.expense.adapters.Holder;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expense.Listeners.EventAdapterListener;
import com.example.expense.R;
import com.example.expense.controller.events.EventController;

public class EventViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextViewMoment, mTextViewStartTime, mTextViewEndTime;

    public TextView mTextViewAmountDailyRecipe, mTextViewAmountDailyExpense;

    public Spinner mSpinnerMoreAction;

    public EventController controller;

    public View view;


    public EventViewHolder(@NonNull View view, EventController controller) {
        super(view);

        this.view = view;
        this.controller = controller;

        // Define click listener for the ViewHolder's View

        // on initialise
        init();

    }

    private void init() {

        mTextViewMoment = (TextView) view.findViewById(R.id.text_view_moment_event);

        mTextViewStartTime = (TextView) view.findViewById(R.id.text_view_event_start_time);
        mTextViewEndTime = (TextView) view.findViewById(R.id.text_view_event_end_time);

        mTextViewAmountDailyExpense = (TextView) view.findViewById(R.id.text_view_event_amount_daily_expense);
        mTextViewAmountDailyRecipe = (TextView) view.findViewById(R.id.text_view_event_amount_daily_recipe);

        mSpinnerMoreAction = (Spinner) view.findViewById(R.id.spinner_event_more_action);

        // on ajoute les listeners
        addListeners();
    }

    private void addListeners() {
        // on recupère l'id(de la base de données) de l'élèment
        mSpinnerMoreAction.setOnItemSelectedListener(new EventAdapterListener());
    }

}