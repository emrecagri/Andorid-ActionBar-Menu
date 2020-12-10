package com.emrecagri.actionbarmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
                Toast.makeText(this, "Paylaşma seçeneğine bastınız.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hakkinda:
                Toast.makeText(this, "Hakkında seçeneğine bastınız.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cikis:
                Toast.makeText(this, "Çıkış seçeneğine bastınız.", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}