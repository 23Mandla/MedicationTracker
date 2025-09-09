package com.health.medicationtracker.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.health.medicationtracker.databinding.AddMedicationBinding;

public class MainClickHandlers {
    private final Context context;
    AddMedicationBinding addMedicationBinding;
    public MainClickHandlers(Context context) {
        this.context = context;

    }

    public void onAddMedicationClick(View view) {
        addMedicationBinding = AddMedicationBinding.inflate(LayoutInflater.from(context));
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(addMedicationBinding.getRoot());
        bottomSheetDialog.show();

        FrameLayout bottomSheet = bottomSheetDialog.findViewById(
                com.google.android.material.R.id.design_bottom_sheet);
        if (bottomSheet != null) {
            BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior.setSkipCollapsed(true);
        }

    }

}
