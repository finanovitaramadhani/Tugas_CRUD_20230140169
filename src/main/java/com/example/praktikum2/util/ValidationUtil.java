package com.example.praktikum2.util;

public class ValidationUtil {

    public static void validateKtp(String nomorKtp,
                                   String namaLengkap,
                                   String alamat,
                                   String jenisKelamin){

        if(nomorKtp == null || nomorKtp.isEmpty()){
            throw new RuntimeException("Nomor KTP tidak boleh kosong");
        }

        if(namaLengkap == null || namaLengkap.isEmpty()){
            throw new RuntimeException("Nama lengkap tidak boleh kosong");
        }

        if(alamat == null || alamat.isEmpty()){
            throw new RuntimeException("Alamat tidak boleh kosong");
        }

        if(jenisKelamin == null || jenisKelamin.isEmpty()){
            throw new RuntimeException("Jenis kelamin tidak boleh kosong");
        }

    }

}
