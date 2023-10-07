package com.example.applicationtrain;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Trip> trips;

    public Repository() {

        this.trips = new ArrayList<Trip>();

        Trip trip1 =new Trip("Paris","Lyon","12h30","14h45","88€");
        Trip trip2 =new Trip("Montpellier","Toulouse","12h30","20h45","68€");
        Trip trip3 =new Trip("Montpellier","Toulouse","18h45","21h30","72€");
        Trip trip4 =new Trip("Montpellier","Toulouse","03h50","05h00","55€");
        Trip trip5 =new Trip("Mende","Saint-Etienne","05h45","07h10","34€");
        Trip trip6 =new Trip("Mende","Saint-Etienne","12h30","20h45","54€");
        Trip trip7 =new Trip("Mende","Saint-Etienne","10h20","12h10","42€");
        Trip trip8 =new Trip("Mende","Saint-Etienne","19h45","21h35","36€");
        Trip trip9 =new Trip("Paris","Montpellier","12h30","20h45","156€");
        Trip trip10 =new Trip("Bordeaux","Brest","10h00","13h35","79€");
        Trip trip11 =new Trip("Rouen","Lille","21h15","00h30","63€");

        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);
        trips.add(trip5);
        trips.add(trip6);
        trips.add(trip7);
        trips.add(trip8);
        trips.add(trip9);
        trips.add(trip10);
        trips.add(trip11);

    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }
}
