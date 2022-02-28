package com.example.thuongki1_ver2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int manghinhbai[] = {
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};

    CountDownTimer Timer;
    int lichSuMay1 = 0;
    int lichSuMay2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1 = findViewById(R.id.imageview1);
        ImageView iv2 = findViewById(R.id.imageview2);
        ImageView iv3 = findViewById(R.id.imageview3);
        ImageView iv4 = findViewById(R.id.imageview4);
        ImageView iv5 = findViewById(R.id.imageview5);
        ImageView iv6 = findViewById(R.id.imageview6);
        TextView tv_Ketqua = findViewById(R.id.textView_Ketqua);
        TextView tv_DiemMay = findViewById(R.id.tv_diemMay);
        TextView tv_DiemNguoiChoi = findViewById(R.id.tv_diemNguoiChoi);
        Button btn_RutBai = findViewById(R.id.btn_RutLaBai);
        TextView tv_LichSu = findViewById(R.id.tv_lichsu);
        EditText et_ThoiGian = findViewById(R.id.et_ThoiGian);
        TextView tv_DemNguoc = findViewById(R.id.tv_DemNguoc);
        Button btn_Dung = findViewById(R.id.btn_Dung);
        btn_RutBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_ThoiGian.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Bạn cần nhập thời gian chơi trước !");
                    builder.setTitle("Thông báo!");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    //finish();
                                }
                            }
                    );
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else {
                    int thoiGian = Integer.parseInt(et_ThoiGian.getText().toString()) * 1000;
                    Timer = new CountDownTimer(thoiGian, 2000) {
                        @Override
                        public void onTick(long l) {
                            tv_DemNguoc.setText(String.valueOf(l / 2000));
                            int[] saulabai = laySauSoNgauNhien(0, 51);
                            int[] balabaimay = {saulabai[0], saulabai[1], saulabai[2]};
                            int[] balabainguoichoi = {saulabai[3], saulabai[4], saulabai[5]};
                            iv1.setImageResource(manghinhbai[saulabai[0]]);
                            iv2.setImageResource(manghinhbai[saulabai[1]]);
                            iv3.setImageResource(manghinhbai[saulabai[2]]);
                            iv4.setImageResource(manghinhbai[saulabai[3]]);
                            iv5.setImageResource(manghinhbai[saulabai[4]]);
                            iv6.setImageResource(manghinhbai[saulabai[5]]);
                            tv_DiemMay.setText(tinhKetQua(balabaimay));
                            tv_DiemNguoiChoi.setText(tinhKetQua(balabainguoichoi));
                            if (tinhKetQuaManchoi(balabaimay) > tinhKetQuaManchoi(balabainguoichoi)) {
                                tv_Ketqua.setText("Máy 1 Thắng");
                                lichSuMay1++;
                            } else {
                                tv_Ketqua.setText("Máy 2 Thắng");
                                lichSuMay2++;
                            }
                            tv_LichSu.setText("Máy 1 win: " + lichSuMay1 + " |  Máy 2 win: " + lichSuMay2);
                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();

                }

            }
        });
        btn_Dung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer.cancel();
            }
        });
    }
    //---------------------------------------------------


    private String tinhKetQua(int[] arr) {
        String ketQua = "";
        if (tinhSoTay(arr) == 3)
            ketQua = "3 Tây";
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if (tong % 10 == 0)
                ketQua = "Bù, số tây là: " + tinhSoTay(arr);
            else
                ketQua = (tong % 10) + ", số tây là: " + tinhSoTay(arr);
        }
        return ketQua;
    }

    private int tinhKetQuaManchoi(int[] arr) {
        int ketQua;
        if (tinhSoTay(arr) == 3)
            ketQua = 11;
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if (tong % 10 == 0)
                ketQua = 0;
            else
                ketQua = (tong % 10);
        }
        return ketQua;
    }

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 13 >= 10 && arr[i] > 10)
                k++;

        return k;
    }

    private int[] laySauSoNgauNhien(int min, int max) {
        int sauso[] = new int[6];
        int i = 0;
        sauso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, sauso))
                sauso[i++] = k;

        } while (i < 6);
        return sauso;
    }


    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k)
                return true;
        return false;

    }


    private int random(int min, int max) {

        return min + (int) (Math.random() * ((max - min) + 1));

    }
}
