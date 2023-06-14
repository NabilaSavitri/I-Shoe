package com.nabilasavitri.i_shoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.nabilasavitri.i_shoe.databinding.ActivityTambahSepatuBinding;

public class TambahSepatuActivity extends AppCompatActivity {

    private ActivityTambahSepatuBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTambahSepatuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambahSepatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NamaMerekSepatu = binding.etMerek.getText().toString();
                String ModelSepatu = binding.etModel.getText().toString();
                String JenisSepatu = binding.etJenis.getText().toString();
                String WarnaSepatu = binding.etWarna.getText().toString();
                String UkuranSepatu = binding.etUkuran.getText().to();
                String JumlahSepatu = binding.etJumlah.getText().to();
                String HargaPerPcsSepatu = binding.etHarga.getText().to();


                boolean bolehTambah = true;

                if (TextUtils.isEmpty(NamaMerekSepatu)) {
                    bolehTambah = false;
                    binding.etMerek.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(ModelSepatu)) {
                    bolehTambah = false;
                    binding.etModel.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(JenisSepatu)) {
                    bolehTambah = false;
                    binding.etJenis.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(WarnaSepatu)) {
                    bolehTambah = false;
                    binding.etWarna.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(UkuranSepatu)) {
                    bolehTambah = false;
                    binding.etUkuran.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(JumlahSepatu)) {
                    bolehTambah = false;
                    binding.etJumlah.setError("Konten tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(HargaPerPcsSepatu)) {
                    bolehTambah = false;
                    binding.etHarga.setError("Konten tidak boleh kosong!");
                }


                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, NamaMerekSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, ModelSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId,JenisSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, WarnaSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, UkuranSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, JumlahSepatu);
                }
                if(bolehTambah) {
                    String userId = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userId, HargaPerPcsSepatu);
                }
            }
        });
    }

    private void addTambah(String userId, String NamaMerekSepatu) {
        binding.progressBar.setVisibility(View.VISIBLE);
        //proses untuk mengunggah konten
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }
}



