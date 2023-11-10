package com.example.expense.models.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.expense.database.AppDatabase;
import com.example.expense.models.QueryBuilder;
import com.example.expense.models.entity.Event;
import com.example.expense.models.query.Insert;
import com.example.expense.models.query.Select;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public static final String TABLE = "events";

    private final AppDatabase database;

    private String[] columns = new String[]{
            "id", "start_time", "end_time", "amount_daily_recipe", "amount_daily_expense", "created_at"};

    public EventRepository(Context c) {

        this.database = AppDatabase.getDatabaseInstance(c.getApplicationContext());
    }

    /**
     * Permet d'ajouter les données dans la table events
     *
     * @param start
     * @param end
     * @param recipe
     * @param expense
     * @return
     */
    public boolean add(String start, String end, Float recipe, Float expense) {

        ContentValues values = new ContentValues();
        values.put("start_time", start);
        values.put("end_time", end);
        values.put("amount_daily_recipe", recipe);
        values.put("amount_daily_expense", expense);

        return (new Insert(database)).from(TABLE).values(values).save();
    }

    public ArrayList<Event> findAll() {
        // on recupère les données depuis la base de données
        Cursor cs = (new Select(database))
                .from(TABLE, null)
                .select(columns)
                .orderBy("id", "DESC")
                .orderBy("created_at", "DESC")
                .push();

        ArrayList<Event> ev = new ArrayList<Event>();

        // on fait l'hydratation
        // pour avoir les données, comme des objets
        while (cs.moveToNext()) {
            Event e = (new Event())
                    .setId(cs.getInt(0))
                    .setStartTime(cs.getString(1))
                    .setStartTime(cs.getString(2))
                    .setAmountDailyRecipe(cs.getFloat(3))
                    .setAmountDailyExpense(cs.getFloat(4));
            ev.add(e);
        }
        return ev;
    }
}
