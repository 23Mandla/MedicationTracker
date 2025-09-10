package com.health.medicationtracker.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.viewmodel.MedicationViewModel;

public class AddMedicationHandler {
    Medication medication;

    MedicationViewModel medicationViewModel;
    BottomSheetDialog bottomSheetDialog;
    Context context;

    public AddMedicationHandler(Context context, Medication medication, MedicationViewModel medicationViewModel, BottomSheetDialog bottomSheetDialog) {
        this.context = context;
        this.medication = medication;
        this.medicationViewModel = medicationViewModel;
        this.bottomSheetDialog = bottomSheetDialog;
    }

    public void addMedication(View view) {
        if(medication.getName() == null || medication.getDosage() == null || medication.getFrequency() == null) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();

        }else {
            medication = new Medication(medication.getName(), medication.getDosage(), medication.getFrequency());
            medicationViewModel.AddMedication(medication);
            bottomSheetDialog.dismiss();
        }

    }
}
