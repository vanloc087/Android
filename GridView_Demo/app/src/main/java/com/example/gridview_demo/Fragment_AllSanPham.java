package com.example.gridview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class Fragment_AllSanPham extends Fragment {


    public static ArrayList<SanPham> listItems = new ArrayList<>();
    SanPham sp1 = new SanPham(1,R.drawable.sp1,1479000,"COMBO DƯỠNG DA SẠCH MỤN MENLY","22/11/2022","22/01/2023","Sở hữu làn da trắng, sạch mụn không chỉ là mơ ước của riêng phái nữ. Hiểu được tâm lý này của các đấng mài râu, BỘ TỨ DƯỠNG DA SẠCH MỤN MENLY sẽ giúp anh em có được làn da như ý!\n" +
            "Sử dụng trọn bộ mỹ phẩm chăm sóc da bao gồm: Sữa rửa mặt MENY, Toner dưỡng ẩm MENLY, Serum dưỡng trắng MENLY và Kem trị mụn MENLY sẽ mang lại cho bạn những kết quả ngoài mức mong đợi. BỘ TỨ DƯỠNG TRẮNG DA SẠCH MỤN MENLY với chiết xuất từ thiên nhiên giúp làn da nam giới được nâng niu trọn vẹn.","MENLY");
    SanPham sp2 = new SanPham(2,R.drawable.sp2,307000,"TONER SE KHÍT LỖ CHÂN LÔNG MENLY","22/11/2022","22/01/2023","Toner Se khít lỗ chân lông MENLY là sự kết hợp đỉnh cao của nghệ thuật điều chế và khoa học về nguyên liệu thiên nhiên.Với thành phần chính là tinh chất từ cánh hoa cúc Xu Xi, cúc La Mã nổi tiếng với công dụng kháng viêm, làm giảm các triệu chứng mẫn cảm, mụn sưng và giúp làm lành các vết thương nhỏ. Chai Toner được thiết kế dưới dạng vòi xịt phun sương, rất tiện lợi để mang theo sử dụng trong ngày, khi đi chơi xa và dã ngoại, như một dạng xịt khoáng thiên nhiên, giúp làm sạch và dịu da. Nhất là trong tiết trời nắng nóng oi bức.","MENLY");
    SanPham sp3 = new SanPham(3,R.drawable.sp3,397000,"SỬA RỬA MẶT MENLY","22/11/2022","22/01/2023","SỮA RỬA MẶT M.E.N.L.Y là dòng sản phẩm được sản xuất với công thức độc quyền danh riêng cho làn da nam giới. Đây là dòng sữa rửa mặt KHÔNG BỌT đầu tiên cho nam giới tại Việt Nam với độ pH 6.0 đạt CHUẨN đảm bảo lấy sạch bụi bẩn, nhờn thừa nhưng vẫn tuyệt đối AN TOÀN cho da. Với hương thơm tinh dầu nam tính vừa giúp làm sạch, vừa tạo cảm giác thư giãn trong quá trình massage, rửa mặt. Vì là sản phẩm hoàn toàn thiên nhiên nên bạn sẽ KHÔNG phải LO LẮNG về vấn đề ăn mòn da. Hàm lượng dưỡng chất và chiết xuất DỒI DÀO trong SỮA RỬA MẶT M.E.N.L.Y giúp nâng niu và bảo vệ làn da nam giới vượt trội.","MENLY");
    SanPham sp4 = new SanPham(4,R.drawable.sp4,369000,"SỮA TẮM THẢI ĐỘC MENLY","22/11/2022","22/01/2023","Mụn lưng, mụn ngực, viêm lỗ chân lông... có một sản phẩm sẽ giúp bạn tiêu diệt những nỗi lo này! SỮA TẮM THẢI ĐỘC MENLY sẽ là sản phẩm hữu hiệu cho bạn.\n" +
            "Sữa tắm thải độc MENLY được chiết xuất từ:\n" +
            "- Aloe Vera Extract: cung cấp các Vitamin và dưỡng chất cần thiết cho da, duy trì độ ẩm, giúp da luôn mịn màng, mềm mại.\n" +
            "- Calendula Hydrosol (Hydrosol từ Hoa Cúc Xu Xi): giàu flavonoids, giúp chống oxi hoa và ngăn ngừa lão hóa da, đồng thời Calendula Hydrosol còn chứa acid oleanolic giúp làm dịu da, chống kích ứng, giảm stress và bảo vệ da dưới tác hại của môi trường\n" +
            "- Blend Tinh dầu Trị Liệu: kích thích tuần hoàn máu, hương thơm tự nhiên giúp thư giãn, giảm căng thẳng, mệt mỏi.","MENLY");
    SanPham sp5 = new SanPham(5,R.drawable.sp5,372000,"SERUM DƯỠNG TRẮNG DA MENLY","22/11/2022","22/01/2023","Serum là dòng sản phẩm không còn xa lạ với chị em phụ nữ nữa. Tuy nhiên, ít người biết rằng, ngay cả nam giới cũng có thể sử dụng serum để chăm sóc cho làn da của mình.\n" +
            "Trong serum dưỡng trắng MENLY có chứa chủ yếu là Arbutin, Vitamin C-E. Đây đều là các hoạt chất giúp làm sáng da vô cùng an toàn. Không chỉ vậy, chúng còn có tác dụng làm mờ thâm nám, giúp da đều màu hơn và làm da trắng sáng một cách tự nhiên. Làn da của bạn sẽ được quan tâm và chăm sóc toàn diện, giúp các chàng trai có làn da trắng sáng khỏe mạnh, lấy lại tự tin khi giao tiếp cũng như gây ấn tượng với người đối diện","MENLY");
    SanPham sp6 = new SanPham(6,R.drawable.sp6,417000,"EM TRỊ MỤN MENLY","22/11/2022","22/01/2023","- KEM TRỊ MỤN MENLY với thành phần chính gồm: tinh dầu tràm trà, tinh dầu cam thảo và vitamin B3 sẽ ngay lập tức làm GIẢM kích ứng tại vùng da bị mụn, làm dịu da và tiêu diệt vi khuẩn gây nên mụn. Sau khi bôi kem lên vùng da bị mụn, chỉ sau 48h, nốt mụn sẽ giảm sưng viêm và xẹp đi. Đặc biệt sản phẩm không hề gây khô da hoặc kích ứng, sử dụng được cho cả làn da nhạy cảm nhất.","MENLY");
    MainActivity mainActivity = new MainActivity();
    TruyenSanPham truyenSanPham;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listItems.add(sp1);
        listItems.add(sp2);
        listItems.add(sp3);
        listItems.add(sp4);
        listItems.add(sp5);
        listItems.add(sp6);

        truyenSanPham = (TruyenSanPham) getActivity();
        View view =inflater.inflate(R.layout.fragment_allsanpham,container,false);

        MyArrayAdapter adapter = new MyArrayAdapter(getActivity(),R.layout.items_layout,listItems);


        GridView gridView = view.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                truyenSanPham.DataSanPham(listItems.get(arg2));

            }
        });

        return view;

    }




    public static ArrayList<SanPham> getSP(){
        return  listItems;
    }


}
