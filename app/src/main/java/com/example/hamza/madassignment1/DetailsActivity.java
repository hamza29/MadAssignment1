package com.example.hamza.madassignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Hamza on 10/4/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

//
//        TextView name = (TextView) findViewById(R.id.name);
//        TextView number = (TextView) findViewById(R.id.number);
//       TextView email = (TextView) findViewById(R.id.email);
//
////        Intent i = getIntent();
        Gson gs = new Gson();
        String trg = getIntent().getStringExtra("Contact");
        ContactDetailEvent contactDetailsEvent = new ContactDetailEvent(trg);
        EventBus.getDefault().post(contactDetailsEvent);
        // Receiving the Data
//        Contact contact = gs.fromJson(trg,Contact.class);
////        String n = i.getStringExtra("name");
////        String number = i.getStringExtra("gender");
//
//        // Displaying Received data
//        name.setText(contact.getName().toString());
//        number.setText(contact.getNumber().toString());
//        email.setText(contact.getEmail());
//        id.setText(n);
//        name.setText(number);
    }
}




