public class GiamDoc extends NhanVien{
    public double rate ;

    public GiamDoc(int ID, String name, int phonenum, int workdays, double salary_per_day,double rate) {
        super(ID, name, phonenum, workdays, 300);
        this.rate = rate/100;
    }
    @Override
    public double Count_Salary(){
        return 300*workdays;
    }
}
