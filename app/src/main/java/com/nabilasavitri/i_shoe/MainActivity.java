package com.nabilasavitri.i_shoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nabilasavitri.i_shoe.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private TambahViewAdapater tambahViewAdapater;

    private List<Tambah> data;

    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Utilities.chechValue(MainActivity.this, "xUserId")){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        tambahViewAdapater = new TambahViewAdapater();
        binding.rvTambah.setLayoutManager(new LinearLayoutManager(this));
        binding.rvTambah.setAdapter(tambahViewAdapater);

        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TambahSepatuActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getAllTambah();
    }

    private void getAllTambah() {
        binding.progressBar.setVisibility(View.VISIBLE);
        //memanggil data unggah dari server
        binding.progressBar.setVisibility(View.GONE);
    }

    public boolean onCleateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return  true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout){
            Utilities.clearuser(this);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




