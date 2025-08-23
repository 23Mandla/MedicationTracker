package com.health.medicationtracker.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainClickHandlers {
    private Context context;

    public MainClickHandlers(Context context) {
        this.context = context;

    }

    public void onAddMedicationClick(View view) {
        Intent intent = new Intent(context, AddMedication.class);
        context.startActivity(intent);
    }
}
