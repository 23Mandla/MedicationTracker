package com.health.medicationtracker.viewmodel;

import static org.junit.Assert.*;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.health.medicationtracker.data.MedDao;
import com.health.medicationtracker.data.MedsDatabase;
import com.health.medicationtracker.model.Medication;


import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class MedicationViewModelTest {

    private MedicationViewModel medicationViewModel;
    private MedsDatabase database;
    private MedDao medicationDao;


    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, MedsDatabase.class)
                .build();
        medicationDao = database.getMedDao();
        Application app = ApplicationProvider.getApplicationContext();
        medicationViewModel = new MedicationViewModel(app);

    }

    @Test
    public void getAllMedication() throws InterruptedException {
        Medication meds1 = new Medication("Lansoprazole", "500mg", "Once a day");
        Medication meds2 = new Medication("Maxalon", "200mg", "Twice a day");

       medicationViewModel.AddMedication(meds1);
       medicationViewModel.AddMedication(meds2);

       Thread.sleep(2000);

        List<Medication> result = medicationViewModel.getAllMedicationList();

        assertNotNull(result);
        assertEquals(2, result.size());

    }
}
