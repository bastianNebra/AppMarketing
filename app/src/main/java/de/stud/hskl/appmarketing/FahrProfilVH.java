package de.stud.hskl.appmarketing;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class FahrProfilVH extends RecyclerView.ViewHolder {

 public TextView txt_name,txt_wohnOrt,zielOrt,txt_raucher,txt_haare,txt_modell,txt_beschreibung,txt_freieplätze;
    public FahrProfilVH(@NonNull View itemView) {
        super(itemView);
        txt_name =itemView.findViewById(R.id.txt_name);
        txt_wohnOrt =itemView.findViewById(R.id.txt_wohnOrt);
        zielOrt =itemView.findViewById(R.id.zielOrt);
        txt_raucher =itemView.findViewById(R.id.txt_raucher);
        txt_haare =itemView.findViewById(R.id.txt_haare);
        txt_modell =itemView.findViewById(R.id.txt_modell);
        txt_beschreibung =itemView.findViewById(R.id.txt_beschreibung);
        txt_freieplätze =itemView.findViewById(R.id.txt_freieplätze);
    }
}
