package com.health.medicationtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.repository.Repository;

import java.util.List;

public class MedicationViewModel extends AndroidViewModel {

    private final Repository repository;
    public MedicationViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    //for testing
    public MedicationViewModel(Application application, Repository repository){
        super(application);
        this.repository = repository;
    }

    public LiveData<List<Medication>> getAllMedication(){
        return repository.getAllMedication();
    }

    //testing
    public List<Medication> getAllMedicationList(){
        return repository.getAllMedicationList();
    }

    public void AddMedication(Medication medication){
        repository.AddMedication(medication);
    }

    public void deleteAllMedication(){
        repository.deleteAllMedication();
    }

    public void deleteMedication(Medication medication){
        repository.deleteMedication(medication);
    }
}
