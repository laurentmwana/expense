package com.example.expense.controller.events;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.expense.R;
import com.example.expense.controller.ControllerInterface;
import com.example.expense.helper.Flash;
import com.example.expense.helper.Redirect;
import com.example.expense.models.repository.EventRepository;
import com.example.expense.validator.Validator;
import com.example.expense.views.event.AddEventActivity;
import com.example.expense.views.event.EventActivity;

public class AddEventController implements ControllerInterface {

    /**
     * Pour définir l'heure du début et de la fin
     */
    private EditText mEditTextStartTime, mEditTextEndTime;

    /**
     * Pour définir le montant de dépense journalière et recette journalière
     */
    private EditText mEditTextAmountDailyRecipe, mEditTextAmountDailyExpense;

    /**
     * Bouton de soumission
     */
    private Button mButtonSave;

    /**
     * l'instance de l'activité AddEventActivity
     */
    private AddEventActivity context;

    /**
     * Model qui fait les requêtes pour la table event
     */
    private EventRepository eventRepository;


    /**
     * @param context
     */
    public AddEventController(AddEventActivity context) {
        this.context = context;

        this.eventRepository = new EventRepository(context);
    }

    @Override
    public void init() {
        // on initialise les données depuis le view (AddEventActivity)
        mEditTextStartTime = (EditText) context.findViewById(R.id.edit_text_start_time);
        mEditTextEndTime = (EditText) context.findViewById(R.id.edit_text_end_time);
        mEditTextAmountDailyRecipe = (EditText) context.findViewById(R.id.edit_text_amount_daily_recipe);
        mEditTextAmountDailyExpense = (EditText) context.findViewById(R.id.edit_text_amount_daily_expense);
        mButtonSave = (Button) context.findViewById(R.id.button_event_save);

        // on ajoute les ecouteurs (listeners)
        addListeners();
    }

    private void addListeners() {
        // on greffe l'evenement click sur le bouton
        mButtonSave.setOnClickListener(this::onSubmit);
    }

    /**
     * lorsqu'on clique sur le bouton save (enregistré)
     * @param view
     */
    private void onSubmit(View view) {

        // on valide les données
        Validator validator = (new Validator())
                .required(mEditTextStartTime, mEditTextEndTime)
                .required(mEditTextAmountDailyExpense, mEditTextAmountDailyRecipe)
                .positive(mEditTextAmountDailyExpense, mEditTextAmountDailyRecipe);

        if (validator.hasError()) {
            // on recupère les données saisies par l'utilisateur
            String startTime = mEditTextStartTime.getText().toString();
            String endTime = mEditTextEndTime.getText().toString();
            // on fait le cast pour convertir string en float
            Float amountDailyRecipe = Float.parseFloat(mEditTextAmountDailyRecipe.getText().toString());
            Float amountDailyExpense = Float.parseFloat(mEditTextAmountDailyExpense.getText().toString());

            // on stocke les données dans la base de données
            boolean created = eventRepository.add(startTime, endTime, amountDailyRecipe, amountDailyExpense);

            if (created) {
                // l'évènement a bien été enregistré dans la base de données
                // on affiche un message de success
                Flash.modal(context, "l'évènement a bien été enregistré.");
                // redirection vers la page EventActivity
                Redirect.route(context, EventActivity.class );
            } else {
                // l'évènement n'a pu être enregistré dans la base de données
                Flash.modal(context, "l'évènement n'a pu être en été enregistré.");
            }
        }
    }
}
