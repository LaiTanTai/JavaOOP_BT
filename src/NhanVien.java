public class NhanVien extends employee{
    public String Manager = null;
    public NhanVien(int ID , String name ,int phonenum,int workdays,double salary_per_day){
        super(ID,name,phonenum,workdays,100);
    }
    public NhanVien(int ID , String name ,int phonenum,int workdays,double salary_per_day,String manager){
        super(ID,name,phonenum,workdays,100);
        this.Manager = manager;
    }
    @Override
    public double Count_Salary(){
        return 100*super.workdays;
    }
}
