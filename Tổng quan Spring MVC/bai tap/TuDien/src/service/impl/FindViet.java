package service.impl;

import Entity.TuDienA;
import org.springframework.stereotype.Service;
import service.FindWord;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindViet implements FindWord {

    public static List<TuDienA> tuDienArrayList = new ArrayList<>();

    static {
        TuDienA tuDien = new TuDienA("Hello", "Xin Chào");
        TuDienA tuDien2 = new TuDienA("World", "Thế Giới");
        TuDienA tuDien3 = new TuDienA("Pen", "Bút Chì");
        tuDienArrayList.add(tuDien);
        tuDienArrayList.add(tuDien2);
        tuDienArrayList.add(tuDien3);

    }

    @Override
    public String findw(String w) {
        for (TuDienA tuDien : tuDienArrayList) {
            if (tuDien.getTiengViet().equals(w)) {
                return tuDien.getTiengAnh();
            }
        }
        return "không tìm thấy ";
    }
}
