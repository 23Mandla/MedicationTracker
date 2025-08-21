package com.health.medicationtracker.ui.login.data;

import static org.junit.Assert.*;

import android.content.Context;
import android.provider.MediaStore;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.health.medicationtracker.data.MedDao;
import com.health.medicationtracker.data.MedsDatabase;
import com.health.medicationtracker.model.Medication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.manipulation.Ordering;

import java.util.List;

public class MedDaoTest {
    private MedsDatabase database;
    private MedDao medicationDao;

    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, MedsDatabase.class).build();
        medicationDao = database.getMedDao();

    }

    @After
    public void teardown() {
        database.close();
    }

    @Test
    public void insertMedication() {
        Medication meds = new Medication("Paracetamol", "500mg", "Once a day");
        medicationDao.insert(meds);

        List<Medication> medicationList = medicationDao.getAllMedicationList();
        assertEquals(1, medicationList.size());

        Medication medication = medicationList.get(0);
        assertEquals(meds.getName(), medication.getName());
        assertEquals(meds.getDosage(), medication.getDosage());
        assertEquals(meds.getFrequency(), medication.getFrequency());
    }
}