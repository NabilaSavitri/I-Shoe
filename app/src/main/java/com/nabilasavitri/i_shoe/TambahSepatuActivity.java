package com.nabilasavitri.i_shoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nabilasavitri.i_shoe.databinding.ActivityTambahSepatuBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahSepatuActivity extends AppCompatActivity {

    private ActivityTambahSepatuBinding binding;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTambahSepatuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambahSepatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NamaMerekSepatu = binding.etMerek.getText().toString();
                String ModelSepatu = binding.etModel.getText().toString();
                String JenisSepatu = binding.etJenis.getText().toString();
                String WarnaSepatu = binding.etWarna.getText().toString();
                int UkuranSepatu = Integer.parseInt(binding.etUkuran.getText().toString());
                int JumlahSepatu = Integer.parseInt(binding.etJumlah.getText().toString());
                int HargaPerPcsSepatu = Integer.parseInt(binding.etHarga.getText().toString());


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
                if (UkuranSepatu == 0) {
                    bolehTambah = false;
                    binding.etUkuran.setError("Konten tidak boleh kosong!");
                }
                if (JumlahSepatu == 0) {
                    bolehTambah = false;
                    binding.etJumlah.setError("Konten tidak boleh kosong!");
                }
                if (HargaPerPcsSepatu == 0) {
                    bolehTambah = false;
                    binding.etHarga.setError("Konten tidak boleh kosong!");
                }


                if (bolehTambah) {
                    String userid = Utilities.getValue(TambahSepatuActivity.this, "xUserId");
                    addTambah(userid, NamaMerekSepatu, ModelSepatu, JenisSepatu, WarnaSepatu, UkuranSepatu, JumlahSepatu, HargaPerPcsSepatu);
                }
            }
        });
    }

    private void addTambah(String userid, String NamaMerekSepatu, String ModelSepatu, String JenisSepatu, String WarnaSepatu, Integer UkuranSepatu, Integer JumlahSepatu, Integer HargaPerPcsSepatu) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.addSepatu(NamaMerekSepatu, ModelSepatu, JenisSepatu, WarnaSepatu, UkuranSepatu, JumlahSepatu, HargaPerPcsSepatu, userid);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(TambahSepatuActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(TambahSepatuActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TambahSepatuActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(TambahSepatuActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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



