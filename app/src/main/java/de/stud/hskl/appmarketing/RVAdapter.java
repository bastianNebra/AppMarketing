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
        ((FahrProfilVH) holder).lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Mail gesendet Erfolgreiche Buchung", Toast.LENGTH_SHORT).show();
                // Mail implementierung
                try {
                    buttonSendEmail(v, fahrer);
                } catch (AddressException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            }
        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    /*class MyViewHolder extends  RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        } Represente notre classe fahrProfilVH*/



    public void buttonSendEmail(View view, FahrerProfil fahrer ) throws AddressException {
        try{
        LoginActivity log= new LoginActivity();

        String senderMail = log.mail;
        String receiverEmail = fahrer.getMail();
            System.out.println( senderMail);
            System.out.println( receiverEmail);
        String stringHost ="smtp.gmail.com";
        String password="Test22";
        Properties properties= System.getProperties();
        properties.put("mail.smtp.host",stringHost);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(receiverEmail)));


            mimeMessage.setSubject("Mitfahr Buchung");
            mimeMessage.setText(" Hallo, Ich möchte mit dir Fahren. Schreib mir bitte zürück,damit wir uns einigen");

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Transport.send(mimeMessage);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            System.out.println( senderMail);
            System.out.println( receiverEmail);


        }catch(AddressException e){
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
    }

