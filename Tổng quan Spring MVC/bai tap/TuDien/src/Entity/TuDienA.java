package Entity;

public class TuDienA {
    private String TiengViet;
    private String TiengAnh;

    public TuDienA(String tiengViet, String tiengAnh) {
        TiengViet = tiengViet;
        TiengAnh = tiengAnh;
    }

    public TuDienA() {
    }

    public String getTiengViet() {
        return TiengViet;
    }

    public void setTiengViet(String tiengViet) {
        TiengViet = tiengViet;
    }

    public String getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(String tiengAnh) {
        TiengAnh = tiengAnh;
    }
}
