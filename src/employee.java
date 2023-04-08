public abstract class employee {
    public String name;
    public int ID;
    public int phonenum;
    public int workdays;
    public double salary_per_day;
    public employee(int ID ,String name , int phonenum,int workdays,double salary_per_day){
        this.ID = ID;
        this.workdays = workdays;
        this.name = name ;
        this.phonenum = phonenum;
        this.salary_per_day = salary_per_day;
    }
    public double Count_Salary(){
        return salary_per_day*workdays;
    }
}
