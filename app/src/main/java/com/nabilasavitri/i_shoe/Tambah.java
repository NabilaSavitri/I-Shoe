package com.nabilasavitri.i_shoe;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Tambah implements Parcelable {
        private String id;
        private String NamaMerekSepatu;
        private String ModelSepatu;
        private String JenisSepatu;
        private String WarnaSepatu;
        private Integer UkuranSepatu;
        private Integer JumlahSepatu;
        private Integer HargaPerPcsSepatu;


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_id;


    protected Tambah(Parcel in) {
        id = in.readString();
        NamaMerekSepatu = in.readString();
        ModelSepatu = in.readString();
        JenisSepatu = in.readString();
        WarnaSepatu = in.readString();
        if (in.readByte() == 0) {
            UkuranSepatu = null;
        } else {
            UkuranSepatu = in.readInt();
        }
        if (in.readByte() == 0) {
            JumlahSepatu = null;
        } else {
            JumlahSepatu = in.readInt();
        }
        if (in.readByte() == 0) {
            HargaPerPcsSepatu = null;
        } else {
            HargaPerPcsSepatu = in.readInt();
        }
        user_id = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(id);
        dest.writeString(NamaMerekSepatu);
        dest.writeString(ModelSepatu);
        dest.writeString(JenisSepatu);
        dest.writeString(WarnaSepatu);
        if (UkuranSepatu == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(UkuranSepatu);
        }
        if (JumlahSepatu == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(JumlahSepatu);
        }
        if (HargaPerPcsSepatu == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(HargaPerPcsSepatu);
        }
        dest.writeString(user_id);
    }
    @Override
    public int describeContents(){return 0;}


    public static final Creator<Tambah> CREATOR = new Creator<Tambah>() {
        @Override
        public Tambah createFromParcel(Parcel in) {
            return new Tambah(in);
        }

        @Override
        public Tambah[] newArray(int size) {
            return new Tambah[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getNamaMerekSepatu() {
        return NamaMerekSepatu;
    }

    public void setNamaMerekSepatu(String namaMerekSepatu) {
        NamaMerekSepatu = namaMerekSepatu;
    }

    public String getModelSepatu() {
        return ModelSepatu;
    }

    public void setModelSepatu(String modelSepatu) {
        ModelSepatu = modelSepatu;
    }

    public String getJenisSepatu() {
        return JenisSepatu;
    }

    public void setJenisSepatu(String jenisSepatu) {
        JenisSepatu = jenisSepatu;
    }

    public String getWarnaSepatu() {
        return WarnaSepatu;
    }

    public void setWarnaSepatu(String warnaSepatu) {
        WarnaSepatu = warnaSepatu;
    }

    public Integer getUkuranSepatu() {
        return UkuranSepatu;
    }

    public void setUkuranSepatu(Integer ukuranSepatu) {
        UkuranSepatu = ukuranSepatu;
    }

    public Integer getJumlahSepatu() {
        return JumlahSepatu;
    }

    public void setJumlahSepatu(Integer JumlahSepatu) {
        JumlahSepatu = JumlahSepatu;
    }

    public Integer getHargaPerPcsSepatu() {
        return HargaPerPcsSepatu;
    }

    public void setHargaPerPcsSepatu(Integer hargaPerPcsSepatu) {
        HargaPerPcsSepatu = hargaPerPcsSepatu;
    }

    public String getUser_id() {
        return user_id;
    }

}


