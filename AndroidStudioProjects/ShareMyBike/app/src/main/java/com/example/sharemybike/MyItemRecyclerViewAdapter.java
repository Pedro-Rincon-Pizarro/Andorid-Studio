package com.example.sharemybike;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sharemybike.databinding.FragmentItemBinding;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Bike> mValues;
    private Bundle mBundle;
    private Context mContext;

    public MyItemRecyclerViewAdapter(Context context, List<Bike> items, Bundle bundle) {
        mContext = context;
        mValues = items;
        mBundle = bundle; // Para pasar datos como la fecha
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Bike bike = mValues.get(position);
        holder.bind(bike);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "Bike Reservation Request";
                String body = "Dear Mr/Mrs " + bike.getDueñoBici() + ",\n\n" +
                        "I'd like to use your bike at " + bike.getCiudadBici() + " for the following date: " +
                        mBundle.getString("fechaSeleccionada") + ".\n\n" +
                        "Can you confirm its availability?\n\n" +
                        "Kindest regards.";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822"); // Tipo MIME para correos electrónicos
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@email.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);

                // Verificar si hay una app que pueda manejar el intent
                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                } else {
                    Toast.makeText(mContext, "No email app found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mIdView;
        public final TextView mContentView1, mContentView2, mContentView3, mContentView4;
        public final ImageButton btn;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.imageView;
            mContentView1 = binding.txtBici;
            mContentView2 = binding.txtpropietario;
            mContentView3 = binding.txtDireccion;
            mContentView4 = binding.txtDescripocion;
            btn = binding.imageButton;
        }

        public void bind(Bike bike) {
            mIdView.setImageResource(bike.getImg());
            mContentView1.setText(bike.getCiudadBici());
            mContentView2.setText(bike.getDueñoBici());
            mContentView3.setText(bike.getLugarBici());
            mContentView4.setText(bike.getDescripcionBici());
        }
    }
}
