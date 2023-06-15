package com.nabilasavitri.i_shoe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>>login(@Field("username")String username,
                               @Field("password")String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>>register(@Field("username")String username,
                                  @Field("password")String password);

    @GET("shoes")
    Call<ValueData<List<Tambah>>> getTambah();


    @FormUrlEncoded
    @POST("shoes")
    Call<ValueNoData>addTambah(@Field("NamaMerekSepatu")String NamaMerekSepatu,
                                 @Field("ModelSepatu")String ModelSepatu,
                                 @Field("JenisSepatu")String Jenissepatu,
                                 @Field("WarnaSepatu")String WarnaSepatu,
                                 @Field("UkuranSepatu")Integer UkuranSepatu,
                                 @Field("JumlahSepatu")Integer JumlahSepatu,
                                @Field("HargaPerPcsSepatu")Integer HargaPerPcsSepatu,
                                @Field("user_id")String user_id);

    @FormUrlEncoded
    @PUT("shoes")
    Call<ValueNoData>updateTambah(@Field("id")String id,
                            @Field("NamaMerekSepatu")String NamaMerekSepatu,
                                  @Field("ModelSepatu")String ModelSepatu,
                                  @Field("JenisSepatu")String Jenissepatu,
                                  @Field("WarnaSepatu")String WarnaSepatu,
                                  @Field("UkuranSepatu")Integer UkuranSepatu,
                                  @Field("JumlahSepatu")Integer JumlahSepatu,
                                  @Field("HargaPerPcsSepatu")Integer HargaPerPcsSepatu);


    @DELETE("shoes/{id}")
    Call<ValueNoData> deleteTambah(@Path( "id") String id);





}
