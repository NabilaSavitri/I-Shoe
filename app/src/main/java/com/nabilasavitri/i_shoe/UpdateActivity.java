package com.nabilasavitri.i_shoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nabilasavitri.i_shoe.databinding.ActivityUpdateBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            public void onClick(View v) {
                String NamaMerekSepatu = binding.etMerek.getText().toString();
                String ModelSepatu = binding.etModel.getText().toString();
                String JenisSepatu = binding.etJenis.getText().toString();
                String WarnaSepatu = binding.etWarna.getText().toString();
                int UkuranSepatu = Integer.parseInt(binding.etUkuran.getText().toString()) ;
                int JumlahSepatu = Integer.parseInt(binding.etJumlah.getText().toString()) ;
                int HargaPerPcsSepatu = Integer.parseInt(binding.etHarga.getText().toString()) ;


                boolean tambahUpdate = true;
                if (TextUtils.isEmpty(NamaMerekSepatu)) {
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
                if (HargaPerPcsSepatu == 0) {
                    tambahUpdate = false;
                    binding.etHarga.setError("Harga tidak boleh kosong!");
                }
                if (tambahUpdate) {
                    updateTambah(Id, NamaMerekSepatu, ModelSepatu, JenisSepatu, WarnaSepatu, UkuranSepatu, JumlahSepatu, HargaPerPcsSepatu);
                }

            }
        });
    }

    private void updateTambah(String Id, String NamaMerekSepatu, String ModelSepatu, String JenisSepatu, String WarnaSepatu, int UkuranSepatu, int JumlahSepatu, int HargaPerPcsSepatu) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateSepatu(Id,NamaMerekSepatu, ModelSepatu, JenisSepatu, WarnaSepatu, UkuranSepatu, JumlahSepatu, HargaPerPcsSepatu);
        binding.progressBar.setVisibility(View.GONE);

        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(UpdateActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error :" + t.getMessage());
                Toast.makeText(UpdateActivity.this, "Retrofit Error :" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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
