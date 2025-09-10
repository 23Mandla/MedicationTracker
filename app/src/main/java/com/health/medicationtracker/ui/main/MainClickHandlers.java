package com.health.medicationtracker.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.health.medicationtracker.databinding.AddMedicationBinding;
import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.viewmodel.MedicationViewModel;

public class MainClickHandlers {
    private final Context context;
    AddMedicationBinding addMedicationBinding;
    Medication medication;
    public MainClickHandlers(Context context, Medication medication) {
        this.context = context;
        this.medication = medication;

    }

    public void onAddMedicationClick(View view) {
        addMedicationBinding = AddMedicationBinding.inflate(LayoutInflater.from(context));

        // get view model from the class that owns it
        MedicationViewModel medicationViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(MedicationViewModel.class);

        // show bottom sheet
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(addMedicationBinding.getRoot());
        bottomSheetDialog.show();

        // create the handler
        AddMedicationHandler addMedicationHandler = new AddMedicationHandler(
                context,
                medication,
                medicationViewModel, bottomSheetDialog
        );

        // bind handler to layout (this connects `@{medication::addMedication}` and text fields)
        addMedicationBinding.setHandler(addMedicationHandler);
        addMedicationBinding.setMedication(medication);

        // expand sheet
        FrameLayout bottomSheet = bottomSheetDialog.findViewById(
                com.google.android.material.R.id.design_bottom_sheet);
        if (bottomSheet != null) {
            BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior.setSkipCollapsed(true);
        }
    }
}