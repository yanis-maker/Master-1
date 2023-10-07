package com.example.applicationtrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private ExtendedFloatingActionButton dateButton;

    private String dateChosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //Auto complete
        AutoCompleteTextView departureView=findViewById(R.id.departure);
        AutoCompleteTextView arrivalView=findViewById(R.id.arrival);

        List<String> cities = Arrays.asList("Montpellier","Mende","Paris","Saint-Etienne","Lyon",
                "Bordeaux","Brest","Rouen","Lille","Toulouse");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cities);

        departureView.setThreshold(1);
        arrivalView.setThreshold(1);

        departureView.setAdapter(adapter);
        arrivalView.setAdapter(adapter);

        //Search
        List<Trip> trips = new Repository().getTrips();
        MaterialButton searchButton = findViewById(R.id.searchButton);
        MaterialButton viewAllButton=findViewById(R.id.viewAllButton);
        LinearLayout noneLayout=findViewById(R.id.noneLayout);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(dateChosen);
                String departure = ((AutoCompleteTextView) findViewById(R.id.departure)).getText().toString();
                String arrival = ((AutoCompleteTextView) findViewById(R.id.arrival)).getText().toString();
                if ((departure.isEmpty() && !arrival.isEmpty()) || ((!departure.isEmpty() && arrival.isEmpty()))) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir tout les champs", Toast.LENGTH_SHORT).show();
                } else {
                    List<Trip> selectedTrip = new ArrayList<>();

                    for (Trip trip : trips) {
                        if (trip.getStart().equals(departure) && trip.getFinish().equals(arrival)) {
                            selectedTrip.add(trip);
                        }
                    }
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);

                    if (!selectedTrip.isEmpty()) {
                        noneLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), selectedTrip));
                    } else {
                        if (noneLayout.getVisibility() == View.GONE)
                            noneLayout.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }
                }
            }
        });

        //View All
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noneLayout.setVisibility(View.GONE);
                RecyclerView recyclerView=findViewById(R.id.recyclerView);
                recyclerView.setVisibility(View.VISIBLE);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(),trips));
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c= Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        dateChosen= DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(c.getTime());

    }
}