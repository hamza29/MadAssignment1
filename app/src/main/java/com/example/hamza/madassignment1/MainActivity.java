package com.example.hamza.madassignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ContactAdapter(contactList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareContactData();
    }

    private void prepareContactData() {
//        String[] contactname;
//        contactname = new String[]{"Hamza","Salman","Umair","imtiaz", "John"
//                ,"Ali","Umer","Usama","Mubashir","Hassan",
//                "HAtib","Talha", "Hamza","Salman","Umair","imtiaz","John","Ali","Umer","Usama", "Mubashir","Hassan","HAtib","Talha","Hamza","Salman", "Umair","imtiaz","John","Ali","Umer","Hamza","Salman", "Umair","imtiaz","John","Ali","Umer","Usama",
//                "Mubashir","Hassan","Hamza","Hamza","Salman","Umair","imtiaz", "John","Ali","Umer","Usama","Mubashir","Hassan","HAtib","Talha",
//                "Hamza","Salman","Umair","imtiaz","John","Ali","Umer","Usama",
//                "Mubashir","Hassan","HAtib","Talha","Hamza","Salman", "Umair","imtiaz","John","Ali","Umer","Hamza","Salman", "Umair","imtiaz","John","Ali","Umer","Usama", "Mubashir","Hassan","Hamza","Hamza","Salman","Umair","imtiaz", "John","Ali","Umer","Usama","Mubashir","Hassan","HAtib","Talha", "Hamza","Salman","Umair","imtiaz","John","Ali","Umer","Usama", "Mubashir","Hassan","HAtib","Talha","Hamza","Salman",
//                "Umair","imtiaz","John","Ali","Umer","Hamza","Salman", "Umair","imtiaz","John","Ali","Umer","Usama", "Mubashir","Hassan","Hamza","Hamza","Salman","Umair","imtiaz", "John","Ali","Umer","Usama","Mubashir","Hassan","HAtib","Talha", "Hamza","Salman","Umair","imtiaz","John","Ali","Umer","Usama",
//                "Mubashir","Hassan","HAtib","Talha","Hamza","Salman",
//                "Umair","imtiaz","John","Ali","Umer","Hamza","Salman",
//                "Umair","imtiaz","John","Ali","Umer","Usama",
//                "Mubashir","Hassan","Hamza"};
//        String[] contactnumber;
//        contactnumber = new String[]{"03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410",
//                "03234615131","03324163416","03214139410","03214139410","03214139410"};
        for (int i = 0; i < 1000; i++) {
            contactList.add(new Contact("Number  "+ i , "Hamza" +i ,R.drawable.unnamed1, "CALL" ));
        }
        mAdapter.notifyDataSetChanged(); 
    }
}