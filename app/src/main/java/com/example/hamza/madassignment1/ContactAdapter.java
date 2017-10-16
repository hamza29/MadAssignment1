package com.example.hamza.madassignment1;

/**
 * Created by Hamza on 9/30/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Hamza on 5/12/2017.
 */



public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private static final String TAG = "MTAG";
    private List<Contact> contactList;


    Context c;




    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, number, email;
        public Button remove;
        public ImageView prfl_image;
        public RelativeLayout item;
        public MyViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
            prfl_image = view.findViewById(R.id.prfl_image);
            remove = view.findViewById(R.id.remove);
            item = view.findViewById(R.id.item);
            email = view.findViewById(R.id.email);
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Contact contact = contactList.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
        holder.email.setText(contact.getEmail());
        Picasso.with(c).load("www.abbieterpening.com/wp-content/uploads/2013/profile-pic-round-200px.png").resize(160, 160).into(holder.prfl_image);
        holder.item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Contact contact = contactList.get(position);
                Gson gson = new Gson();
                String str = gson.toJson(contact);
                Intent callIntent = new Intent(c, DetailsActivity.class);
                callIntent.putExtra("Contact", str);
                // callIntent.putExtra("gender", holder.number.getText().toString());
                c.startActivity(callIntent);

            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                Contact itemLabel = contactList.get(position);
                // Remove the item on remove/button click
                contactList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, contactList.size());

                // Show the removed item label
                Toast.makeText(c, "Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });
//        holder.call.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View arg0) {
//                Intent callIntent = new Intent(c,DetailsActivity.class);
//
////               // callIntent.setData(Uri.parse("tel:"+contact.getCall()));
////                callIntent.setData(Uri.parse("tel: 03234615131"));
////
////                if (ActivityCompat.checkSelfPermission(c,
////                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
////
////                {
////                    ActivityCompat.requestPermissions((Activity) c, new String[]{Manifest.permission.CALL_PHONE},1001 );
////                    return;
////                }
////            Contact co = new Contact();
////        String str = gson.toJson(c);
////        Log.d(TAG, "Contact JSON is  " + str);
////        callIntent.putExtra(str,"contact");
//
//                callIntent.putExtra("name", holder.name.getText().toString());
//                callIntent.putExtra("gender", holder.number.getText().toString());
//                c.startActivity(callIntent);
//
//
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}