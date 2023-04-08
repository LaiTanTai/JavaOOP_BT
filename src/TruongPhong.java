public class TruongPhong extends NhanVien {
    public int staff = 0;

    public TruongPhong(int ID, String name, int workdays,int phonenum) {
        super(ID, name, workdays,phonenum,200);
    }
    @Override
    public double Count_Salary(){
        return 200*workdays+staff*100;
    }

}
