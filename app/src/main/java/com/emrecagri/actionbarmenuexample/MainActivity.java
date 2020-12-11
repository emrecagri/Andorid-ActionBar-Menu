package com.emrecagri.actionbarmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.ara:
                Toast.makeText(this, "Arama seçeneğine bastınız.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.begen:
                Toast.makeText(this, "Beğenme seçeneğine bastınız.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.paylas:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                        "Bu çok satırlı yazı \n" +
                                "paylaşma kodudur. \n");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Paylaş"));

                break;
            case R.id.hakkinda:

                final AlertDialog.Builder hakkindapenceresi = new AlertDialog.Builder( MainActivity.this ); //hakkindapenceresi adında AlertDialog tanımladık
                hakkindapenceresi.setTitle("Hakkında"); //AlertDialog penceresi başlığı
                hakkindapenceresi.setMessage( "Bu uygulama \ngithub.com/emrecagri \ntarafından hazırlanmıştır." );         //AlertDialog penceresi açıklaması
                hakkindapenceresi.setCancelable( true ); //true ile bu AlertDialog penceresinden seçeneklere basılmadan çıkış yapılabileceğini belirttik
                hakkindapenceresi.setPositiveButton( "Geri", new DialogInterface.OnClickListener() { //AlertDialog Pozitif Geri seçeneği
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // Geri seçeneği seçildiğinde bu kod çalışıp AlertDialog penceresini kapatacak
                    }
                });
                AlertDialog hakkindapenceresiAlertDialogu = hakkindapenceresi.create();
                hakkindapenceresiAlertDialogu.show(); // AlertDialog penceresini gösteren kod

                break;
            case R.id.cikis:

                final AlertDialog.Builder cikispenceresi = new AlertDialog.Builder( MainActivity.this ); //cikispenceresi adında AlertDialog tanımladık
                cikispenceresi.setMessage( "Uygulamadan çıkmak istediğinize emin misiniz?" );         //AlertDialog penceresi açıklaması
                cikispenceresi.setCancelable( true );  //true ile bu AlertDialog penceresinden seçeneklere basılmadan çıkış yapılabileceğini belirttik
                cikispenceresi.setNegativeButton( "Hayır",new DialogInterface.OnClickListener() { //AlertDialog Negatif Hayır seçeneği
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // Hayır seçeneği seçildiğinde bu kod çalışıp AlertDialog penceresini kapatacak
                    }
                });
                cikispenceresi.setPositiveButton( "Evet", new DialogInterface.OnClickListener() { //AlertDialog Pozitif Evet seçeneği
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();   // Evet seçeneği seçildiğinde bu kod çalışıp uygulamayı kapatacak
                    }
                });
                AlertDialog cikispenceresiAlertDialogu = cikispenceresi.create();
                cikispenceresiAlertDialogu.show(); // AlertDialog penceresini gösteren kod

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}