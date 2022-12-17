package de.stud.hskl.appmarketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DriveAdapter extends RecyclerView.Adapter<DriveAdapter.ViewHolder> {

    DriveData[] DriveData;
    Context context;

    public DriveAdapter(DriveData[] DriveData, MainActivity activity){
        this.DriveData = DriveData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fahrt_card_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DriveData DriveDataList = DriveData[position];
        /*
        holder.Kartenzugriff.setImageResource(DriveDataList.getKartenzugriff);
        holder.Standorttext.setText(DriveDataList.getStandorttext);
        holder.Zielorttext.setText(DriveDataList.getZielorttext);
        holder.ZeitAnkunft.setText(DriveDataList.getZeitAnkunft);
        holder.ZeitAbfahrt.setText(DriveDataList.getZeitAbfahrt);
        holder.NutzerZugriff.setText(DriveDataList.getNutzerZugriff);
        */
        holder.itemView.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(context, DriveDataList.getFahrtID(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return DriveData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        int FahrtID; //ID aus DB
        ImageView Kartenzugriff;
        TextView Zielorttext;
        TextView Standorttext;
        TextView ZeitAbfahrt;
        TextView ZeitAnkunft;
        TextView NutzerZugriff;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Kartenzugriff = itemView.findViewById(R.id.Kartenzugriff);
            Standorttext = itemView.findViewById(R.id.Standorttext);
            Zielorttext = itemView.findViewById(R.id.Zielorttext);
            ZeitAbfahrt = itemView.findViewById(R.id.ZeitAbfahrt);
            ZeitAnkunft = itemView.findViewById(R.id.ZeitAnkunft);
            NutzerZugriff = itemView.findViewById(R.id.NutzerZugriff);
        }
    }

}
