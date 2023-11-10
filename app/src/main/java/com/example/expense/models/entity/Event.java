package com.example.expense.models.entity;

public class Event {

    private int id;

    private String startTime;

    private String endTime;

    private Float amountDailyRecipe;

    private Float amountDailyExpense;

    public int getId() {
        return id;
    }

    public Event setId(int id) {
        this.id = id;

        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public Event setStartTime(String startTime) {
        this.startTime = startTime;

        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public Event setEndTime(String endTime) {
        this.endTime = endTime;

        return this;
    }

    public Float getAmountDailyRecipe() {
        return amountDailyRecipe;
    }

    public Event setAmountDailyRecipe(Float amountDailyRecipe) {
        this.amountDailyRecipe = amountDailyRecipe;

        return this;
    }

    public Float getAmountDailyExpense() {
        return amountDailyExpense;


    }

    public Event setAmountDailyExpense(Float amountDailyExpense) {
        this.amountDailyExpense = amountDailyExpense;

        return this;
    }
}
