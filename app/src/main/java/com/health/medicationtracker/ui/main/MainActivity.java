package com.health.medicationtracker.ui.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.health.medicationtracker.R;
import com.health.medicationtracker.data.MedsDatabase;
import com.health.medicationtracker.databinding.ActivityMainBinding;
import com.health.medicationtracker.model.Medication;
import com.health.medicationtracker.ui.adapter.MedicationAdapter;
import com.health.medicationtracker.viewmodel.MedicationViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //data source
    private ArrayList<Medication> medicationList = new ArrayList<>();
    private MedsDatabase medication_database;

    //adapter
    private MedicationAdapter medicationAdapter;

    //data binding
    private ActivityMainBinding binding_main_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //data binding
        binding_main_activity = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //database
        medication_database = MedsDatabase.getInstance(this);

        //view model use on the add contact handler, when you create a class to this
        MedicationViewModel medicationViewModel = new ViewModelProvider(this).get(MedicationViewModel.class);
        medicationViewModel.AddMedication(new Medication("Lansoprazole", "500mg", "Once a day"));
        medicationViewModel.AddMedication(new Medication("Maxalon", "200mg", "Twice a day"));

        //add data to the list
        medicationList.add(new Medication("Lansoprazole", "500mg", "Once a day"));
        medicationList.add(new Medication("Maxalon", "200mg", "Twice a day"));

        //once adding page is setup
        medicationViewModel.getAllMedication().observe(this, medications -> {
            medicationAdapter.setMedicationList((ArrayList<Medication>) medications);
        });

        //adapter
        medicationAdapter = new MedicationAdapter(medicationList);
        RecyclerView recyclerView = binding_main_activity.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(medicationAdapter);


    }
}