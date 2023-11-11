package com.example.expense.models.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.expense.database.AppDatabase;
import com.example.expense.exception.NotFoundException;
import com.example.expense.models.entity.Event;
import com.example.expense.models.query.Insert;
import com.example.expense.models.query.Select;

import java.util.ArrayList;

public class EventRepository {

    public static final String TABLE = "events";

    private final AppDatabase database;

    private String[] columns = new String[]{
            "id", "start_time", "end_time", "amount_daily_recipe", "amount_daily_expense", "created_at", "updated_at"};

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
                .execute();

        ArrayList<Event> ev = new ArrayList<Event>();

        // on fait l'hydratation
        // pour avoir les données sous forme d'objets
        while (cs.moveToNext()) {
            ev.add(getHydrate(cs));
        }
        return ev;
    }

    public Event find(String id) throws NotFoundException {
        // on recupère les données depuis la base de données qui repondent à la condition id = id
        Cursor cs = (new Select(database))
                .from(TABLE, null)
                .select(columns)
                .where("id = ?")
                .params(id)
                .limit(1)
                .execute();
        if (null == cs) {
            throw new NotFoundException("nous n'avons pas trouvé l'évènement #" + id);
        }
        cs.moveToFirst();

        return getHydrate(cs);
    }


    private Event getHydrate(Cursor cs) {

        Event ev = new Event();
        return  (ev)
                .setId(cs.getInt(0))
                .setStartTime(cs.getString(1))
                .setEndTime(cs.getString(2))
                .setAmountDailyRecipe(cs.getFloat(3))
                .setAmountDailyExpense(cs.getFloat(4))
                .setCreatedAt(cs.getString(5))
                .setUpdatedAt(cs.getString(6));
    }
}
