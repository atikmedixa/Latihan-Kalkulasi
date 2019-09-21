package com.example.latihankalkulasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var inputSatu: EditText //inisialisasi atau pengenalan variabel
    lateinit var inputDua: EditText
    lateinit var btnTambah: Button
    lateinit var btnKurang: Button
    lateinit var btnKali: Button
    lateinit var btnBagi: Button
    lateinit var hasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputSatu = findViewById(R.id.input_satu) //untuk menemukan id yang ada di xml
        inputDua = findViewById(R.id.input_dua)
        btnTambah = findViewById(R.id.button_tambah)
        btnKurang = findViewById(R.id.button_kurang)
        btnKali = findViewById(R.id.button_kali)
        btnBagi = findViewById(R.id.button_bagi)
        hasil = findViewById(R.id.hasil_hitung)

        btnTambah.setOnClickListener(this) //aktifin tombol button
        btnKurang.setOnClickListener(this)
        btnKali.setOnClickListener(this)
        btnBagi.setOnClickListener(this)
    }

    override fun onClick(v: View) { //untuk mengaktifkan tombol input
        val angkaSatu = inputSatu.text.toString().trim() //variabelnya tidak dapat diuabh
        val angkaDua = inputDua.text.toString().trim()
        var inputKosong = false //dapat diubah

        when { //seperti switch case
            angkaSatu.isEmpty() -> { //menampilkan allert error atau ketika tombol di klik,jk data null(kosong)
                inputKosong = true
                inputSatu.error = "Angka ke-1 kosong"
            }
            angkaDua.isEmpty() -> {
                inputKosong = true
                inputDua.error = "Angka ke-2 kosong"
            }
        }

        if (v.id == R.id.button_tambah) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() + angkaDua.toDouble() //immutable
                hasil.text = hasilHitung.toString()

            }
        }

        if (v.id == R.id.button_kurang) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() - angkaDua.toDouble()
                hasil.text = hasilHitung.toString()

            }
        }

        if (v.id == R.id.button_kali) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() * angkaDua.toDouble()
                hasil.text = hasilHitung.toString()

            }
        }

        if (v.id == R.id.button_bagi) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() / angkaDua.toDouble()
                hasil.text = hasilHitung.toString()
            }
        }
    }
}
