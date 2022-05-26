package com.example.gridview_demo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment_ChiTietSanPham extends Fragment {

    ImageView hinhanh;
    TextView tv_ten;
    TextView tv_dongia;
    TextView tv_hsd;
    TextView tv_NSX;
    TextView tv_thuonghieu;
    TextView tv_mota;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_chitietsanpham,container,false);

         hinhanh = view.findViewById(R.id.imageView_avt);
         tv_ten = view.findViewById(R.id.textView_Ten);
         tv_dongia = view.findViewById(R.id.textView_DonGia);
         tv_hsd = view.findViewById(R.id.textView_HSD);
         tv_NSX = view.findViewById(R.id.textView_NSX);
         tv_thuonghieu = view.findViewById(R.id.textView_ThuongHieu);
         tv_mota = view.findViewById(R.id.textView_MoTa);

        return view;
    }

    public void setChiTietSanPham(SanPham sanPham){
        hinhanh.setImageResource(sanPham.getHinhAnh());
        tv_ten.setText(sanPham.getTen());
        tv_dongia.setText(sanPham.getDonGia()+" VNĐ");
        tv_hsd.setText(sanPham.getHanSuDung());
        tv_NSX.setText(sanPham.getNgaySX());
        tv_thuonghieu.setText(sanPham.getThuongHieu());
        tv_mota.setText(sanPham.getMoTa());
    }

}
