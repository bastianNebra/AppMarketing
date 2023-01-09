package de.stud.hskl.appmarketing;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<FahrerProfil> list = new ArrayList<>();

    public RVAdapter(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<FahrerProfil> fa) {
        list.addAll(fa);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new FahrProfilVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FahrProfilVH fa = (FahrProfilVH) holder;

        FahrerProfil fahrer = list.get(position);
        fa.txt_name.setText(fahrer.getFahrer());
        fa.txt_beschreibung.setText(fahrer.getAutobeschreibun());
        fa.txt_freieplätze.setText(fahrer.getAnzahl_platz());
        fa.txt_haare.setText(fahrer.getSwith2());
        fa.txt_raucher.setText(fahrer.getSwith1());
        fa.txt_wohnOrt.setText(fahrer.getEditText());
        fa.txt_modell.setText(fahrer.getAdress_ziel());
        fa.zielOrt.setText(fahrer.getFahrer());
        ((FahrProfilVH) holder).lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mail implementierung
                final String sender= fahrer.getSendermail();
               final  String receiverMail = fahrer.getMail();
               final String password= "test22";
                String message =" Hallo ich habe starkes Interesse für deine Mitfahrmöglichkeit können wir uns bitte darüber Unterhalten?";
                String subject= "Mitfahr Anfrage";
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{receiverMail});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser as Email client using createChooser function
                context.startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            /*Intent intent2 = new Intent(context, MainActivity.class);

                context.startActivity(intent2);
                Toast.makeText(context, "Mail gesendet; Erfolgreiche Buchung", Toast.LENGTH_SHORT).show();*/



            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public void buttonSendEmail( FahrerProfil fahrer)  {

   String receiverMail = fahrer.getMail();
   String message =" Hallo ich habe starkes Interesse für deine Mitfahrmöglichkeit können wir uns bitte darüber Unterhalten?";
   String subject= "Mitfahr Anfrage";
   Intent intent = new Intent(Intent.ACTION_SEND);
   intent.putExtra(Intent.EXTRA_EMAIL, receiverMail);
   intent.putExtra(Intent.EXTRA_SUBJECT, subject);
   intent.putExtra(Intent.EXTRA_TEXT, message);
   intent.setType("message/rfc822");
   context.startActivity(Intent.createChooser(intent, "Wähl ein EMail client aus"));

    }
}

