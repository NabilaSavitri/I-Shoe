package com.nabilasavitri.i_shoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.nabilasavitri.i_shoe.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    private ActivityUpdateBinding binding;
    private Tambah tambah;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tambah = getIntent().getParcelableExtra("EXTRA_DATA");
        String Id = tambah.getId();
        binding.etMerek.setText(tambah.getNamaMerekSepatu());
        binding.etModel.setText(tambah.getModelSepatu());
        binding.etJenis.setText(tambah.getJenisSepatu());
        binding.etWarna.setText(tambah.getWarnaSepatu());
        binding.etUkuran.setText(tambah.getUkuranSepatu());
        binding.etJumlah.setText(tambah.getJumlahSepatu());
        binding.etHarga.setText(tambah.getHargaPerPcsSepatu());
        binding.btnUpdateSepatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MerekSepatu = binding.etMerek.getText().toString();
                String ModelSepatu = binding.etModel.getText().toString();
                String JenisSepatu = binding.etJenis.getText().toString();
                String WarnaSepatu = binding.etWarna.getText().toString();
                int UkuranSepatu = Integer.parseInt(binding.etUkuran.getText().toString()) ;
                int JumlahSepatu = Integer.parseInt(binding.etJumlah.getText().toString()) ;
                int HargaSepatu = Integer.parseInt(binding.etHarga.getText().toString()) ;


                boolean tambahUpdate = true;
                if (TextUtils.isEmpty(MerekSepatu)) {
                    tambahUpdate = false;
                    binding.etMerek.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(ModelSepatu)) {
                    tambahUpdate = false;
                    binding.etModel.setError("Model tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(JenisSepatu)) {
                    tambahUpdate = false;
                    binding.etJenis.setError("Jenis tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(WarnaSepatu)) {
                    tambahUpdate = false;
                    binding.etWarna.setError("Warna tidak boleh kosong!");
                }
                if (UkuranSepatu == 0) {
                    tambahUpdate = false;
                    binding.etUkuran.setError("Ukuran tidak boleh kosong!");
                }
                if (JumlahSepatu == 0) {
                    tambahUpdate = false;
                    binding.etJumlah.setError("Jumlah tidak boleh kosong!");
                }
                if (HargaSepatu == 0) {
                    tambahUpdate = false;
                    binding.etHarga.setError("Harga tidak boleh kosong!");
                }
                if (tambahUpdate) {
                    updateTambah(Id, MerekSepatu, ModelSepatu, JenisSepatu, WarnaSepatu, UkuranSepatu, JumlahSepatu, HargaSepatu);
                }

            }
        });
    }

    private void updateTambah(String userId, String NamaMerek, String modelSepatu, String jenisSepatu, String warnaSepatu, int ukuranSepatu, int jumlahSepatu, int hargaSepatu) {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;

    }

}
