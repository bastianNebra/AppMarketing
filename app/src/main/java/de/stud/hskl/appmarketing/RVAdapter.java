package de.stud.hskl.appmarketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<FahrerProfil> list = new ArrayList<>();

    public RVAdapter(Context ctx){
        this.context= ctx;
    }
    public void setItems(ArrayList<FahrerProfil>fa){
        list.addAll(fa);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_item, parent,false);
        return new FahrProfilVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FahrProfilVH fa= (FahrProfilVH)holder;
        FahrerProfil fahrer = list.get(position);
        fa.txt_name.setText(fahrer.getFahrer());
        fa.txt_beschreibung.setText(fahrer.getAutobeschreibun());
        fa.txt_freieplätze.setText(fahrer.getAnzahl_platz());
        fa.txt_haare.setText(fahrer.getSwith2());
        fa.txt_raucher.setText(fahrer.getSwith1());
        fa.txt_wohnOrt.setText(fahrer.getEditText());
        fa.txt_modell.setText(fahrer.getAdress_ziel());
        fa.zielOrt.setText(fahrer.getFahrer());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
