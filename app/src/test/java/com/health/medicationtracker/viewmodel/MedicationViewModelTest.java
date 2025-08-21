package com.health.medicationtracker.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.repository.Repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class MedicationViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule(); //testing background tasks

    @Mock
    private Repository repository;

    private MedicationViewModel medicationViewModel;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        medicationViewModel = new MedicationViewModel(repository);

    }

    @Test
    public void getAllMedication() {
        Medication meds1 = new Medication("Lansoprazole", "500mg", "Once a day");
        Medication meds2 = new Medication("Maxalon", "200mg", "Twice a day");

        List<Medication> medicationList = Arrays.asList(meds1, meds2);
        MutableLiveData<List<Medication>> medicationLiveData = new MutableLiveData<>();
        medicationLiveData.setValue(medicationList);
    }
}
