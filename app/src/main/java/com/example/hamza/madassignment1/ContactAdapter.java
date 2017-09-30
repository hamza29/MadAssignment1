package com.example.hamza.madassignment1;

/**
 * Created by Hamza on 9/30/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Hamza on 5/12/2017.
 */



public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<Contact> contactList;


    Context c;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, number;
        public Button call;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
            image = view.findViewById(R.id.image);
            call= view.findViewById(R.id.call);
        }
    }


    public ContactAdapter(List<Contact> contactList, Context ctx) {

        this.contactList = contactList;
        c = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Contact contact= contactList.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
        holder.image.setImageDrawable(c.getDrawable(contact.getImage()));
        holder.call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
               // callIntent.setData(Uri.parse("tel:"+contact.getCall()));
                callIntent.setData(Uri.parse("tel: 03234615131"));

                c.startActivity(callIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}