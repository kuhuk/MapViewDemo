package com.sharma.kuhuk.mapviewdemo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class FDatabase {

    static void databaseCheck() {

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello,!");

    }
}
