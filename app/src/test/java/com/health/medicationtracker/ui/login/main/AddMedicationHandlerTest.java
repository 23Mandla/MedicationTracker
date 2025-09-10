package com.health.medicationtracker.ui.login.main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import android.content.Context;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.ui.main.AddMedicationHandler;
import com.health.medicationtracker.viewmodel.MedicationViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddMedicationHandlerTest {

    @Mock
    MedicationViewModel medicationViewModel;
    @Mock
    BottomSheetDialog bottomSheetDialog;
    @Mock
    Context mockContext;
    @Mock
    View mockView;


    @Test
    public void callsViewModelAndDisMissesDialog(){
        Medication medication = new Medication("Paracetamol", "500mg", "Once a day");

        AddMedicationHandler handler = new AddMedicationHandler(
                mockContext,
                medication,
                medicationViewModel,
                bottomSheetDialog);

        handler.addMedication(mockView);

        verify(medicationViewModel).AddMedication(medication);
        verify(bottomSheetDialog).dismiss();
    }

    @Test
    public void addMedication() {
    }
}