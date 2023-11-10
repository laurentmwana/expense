package com.example.expense.adapters.Holder;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expense.R;

public class EventViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextViewMoment, mTextViewStartTime, mTextViewEndTime;

    public TextView mTextViewAmountDailyRecipe, mTextViewAmountDailyExpense;

    public Spinner mSpinnerMoreAction;

    private View view;


    public EventViewHolder(@NonNull View view) {
        super(view);

        this.view = view;

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

    }

}