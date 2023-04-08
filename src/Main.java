import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static CongTy cty ;
    public static ArrayList<GiamDoc> arrGiamdoc = new ArrayList<GiamDoc>();
    public static ArrayList<TruongPhong> arrTP = new ArrayList<TruongPhong>();
    public static ArrayList<NhanVien> arrNV = new ArrayList<NhanVien>();
    public static void Nhapcongty(){
        System.out.print("Nhập các thông tin lần lượt như Họ Tên , mã số thuế , doanh thu tháng \n");
        String name = scanner.next();
        int ID = scanner.nextInt();
        long salary = scanner.nextLong();
        cty = new CongTy(name,ID,salary);
    }
    public static void PhanboNV(){
        System.out.print("Chọn thứ tự trưởng phòng để quản lý nhân viên : \n");
        for(int i = 0 ; i < arrTP.size() ;i++){
            System.out.print(i + arrTP.get(i).name + "\n");
        }
        System.out.print("Nhập số thứ tự trưởng phòng : ");
        int i = scanner.nextInt();
        String name = arrTP.get(i).name;
        System.out.print("Chọn thứ tự Nhân viên để quản lý nhân viên : \n");
        for(int j = 0 ;j < arrNV.size();j++){
            if(arrNV.get(j).Manager == null){
                System.out.print(j + " " + arrNV.get(j).name + " Chưa được quản lý \n");
            }else{
                System.out.print(j +" "+ arrNV.get(j).name + arrNV.get(j).Manager);
            }
        }
        System.out.print("Nhập thứ tự nhân viên muốn thêm vào quản lý ");
        int k = scanner.nextInt();
        if(arrNV.get(k).Manager!=null){
            System.out.print("Nhân Viên đã dược quản lý trước đó !");
        }else{
            arrTP.get(i).staff +=1 ;
            arrNV.get(k).Manager = arrTP.get(i).name;
            System.out.print("Nhân Viên đã được thêm vào quản lý ");
        }
    }
    public static void CreateNV(){
        System.out.print("Nhập các thông tin giám đốc : \n");
        System.out.print("Nhập số lượng : ");
        int g = scanner.nextInt();
        for(int i = 0 ; i < g ; i++){
            System.out.print("Nhập tên giám đốc thứ " + (i+1) + ": ");
            String nameGD = scanner.next();
            System.out.print("Nhập mã giám đốc : ");
            int IDGD = scanner.nextInt();
            System.out.print("Nhập số điện thoại giám đốc : ");
            int GDphonenum = scanner.nextInt();
            System.out.print("Nhập số ngày làm : ");
            int GDworkday = scanner.nextInt();
            System.out.print("Nhập phần trăm cổ phần : ");
            double rate = scanner.nextDouble();
            GiamDoc gd = new GiamDoc(IDGD,nameGD,GDphonenum,GDworkday,300,rate);
            arrGiamdoc.add(gd);
        }
        System.out.print("Nhập các thông tin Trưởng Phòng \n");
        System.out.print("Nhập số lượng : ");
        int t = scanner.nextInt();
        for(int i = 0 ; i < t ; i++){
            System.out.print("Nhập tên trưởng phòng thứ " + (i+1) + ":");
            String nameTP = scanner.next();
            System.out.print("Nhập mã trưởng phòng : ");
            int IDTP = scanner.nextInt();
            System.out.print("Nhập số điện thoại trưởng phòng : ");
            int TPphonenum = scanner.nextInt();
            System.out.print("Nhập số ngày làm : ");
            int TPworkday = scanner.nextInt();
            TruongPhong tp = new TruongPhong(IDTP,nameTP,TPphonenum,TPworkday);
            arrTP.add(tp);
        }
        System.out.print("Nhập các thông tin Nhân Viên \n ");
        System.out.print("Nhập số lượng : ");
        int n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            System.out.print("Nhập tên nhân viên thứ "+(i+1)+":");
            String nameNV = scanner.next();
            System.out.print("Nhập mã nhân viên : ");
            int IDNV = scanner.nextInt();
            System.out.print("Nhập số điện thoại nhân viên : ");
            int NVphonenum = scanner.nextInt();
            System.out.print("Nhập số ngày làm : ");
            int NVworkday = scanner.nextInt();
            NhanVien nv = new NhanVien(IDNV,nameNV,NVphonenum,NVworkday,100);
            arrNV.add(nv);
        }
    }
    public static void DeleteNV(){
        System.out.print("Hãy chọn danh sách nhân viên muốn xóa\n");
        System.out.print("1 : Giám Đốc ");
        System.out.print("2 : Trưởng Phòng ");
        System.out.print("3 : Nhân Viên ");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                for (int i = 0 ; i < arrGiamdoc.size() ;i++) {
                    System.out.print(i+" " + arrGiamdoc.get(i).name + "\n");
                }
                System.out.print("Chọn giám đốc mà bạn muốn xóa ");
                int j = scanner.nextInt();
                arrGiamdoc.remove(j);
                break;
            case 2:
                for (int i = 0 ; i < arrTP.size() ;i++) {
                    System.out.print(i+" "+ arrTP.get(i).name + "\n");
                }
                System.out.print("Chọn trưởng phòng mà bạn muốn xóa ");
                int k = scanner.nextInt();
                for(int i = 0 ; i < arrNV.size();i++){
                    if(arrNV.get(i).Manager == arrTP.get(k).name){
                        arrNV.get(i).Manager = null;
                        arrTP.get(k).staff -= 1 ;
                    }
                }
                arrTP.remove(k);
                break;
            case 3:
                for (int i = 0 ; i < arrNV.size() ;i++) {
                    System.out.print(i + " " + arrNV.get(i).name + "\n");
                }
                System.out.print("Chọn nhân viên mà bạn muốn xóa ");
                int t = scanner.nextInt();
                for(int i = 0 ; i < arrTP.size();i++){
                    if(arrNV.get(t).Manager == arrTP.get(i).name){
                        arrTP.get(i).staff -= 1 ;
                    }
                }
                arrNV.remove(t);
                break;
        }
    }
    public static void ShowInfo(){
        System.out.print("Thông tin Giám đốc \n");
        for (GiamDoc i : arrGiamdoc) {
            System.out.print(i.name + "\n");
        }
        System.out.print("Thông tin Trưởng Phòng \n");
        for (TruongPhong i : arrTP) {
            System.out.print(i.name + "\n");
        }
        System.out.print("Thông tin Nhân Viên\n");
        for (NhanVien i : arrNV) {
            System.out.print(i.name + "\n");
        }
    }
    public static int CompanyCount() {
        int total=0;
        for (GiamDoc i:
             arrGiamdoc) {
            total+=i.Count_Salary();
        }
        for (TruongPhong i:
             arrTP) {
            total+=i.Count_Salary();
        }
        for (NhanVien i:
             arrNV) {
            total+=i.Count_Salary();
        }
        return total;
    }
    public static void Nhanvienluongcao(){
        NhanVien nv = arrNV.get(0);
        for(int i = 0 ; i < arrNV.size();i++){
            if(arrNV.get(i).Count_Salary() > nv.Count_Salary()){
                nv = arrNV.get(i);
            }
        }
        System.out.print("Nhân viên lương cao nhất có tên là : "+ nv.name);
    }
    public static void maxstaff(){
        TruongPhong max = arrTP.get(0);
        max.staff = 0;
        for(TruongPhong i : arrTP){
            if(i.staff > max.staff){
                max = i;
            }
        }
        System.out.print("Số lượng nhân viên dưới quyền lớn nhất là " + max + "\n");
    }
    public static void Sortingabc(){
        ArrayList<GiamDoc> gd =  arrGiamdoc;
        gd.sort((o1, o2) -> o2.name.charAt(0)-o1.name.charAt(0));
        for (GiamDoc i : arrGiamdoc) {
            System.out.print(i.name + "\n");
        }
        ArrayList<TruongPhong> TP =  arrTP;
        TP.sort((o1, o2) -> o2.name.charAt(0)-o1.name.charAt(0));
        for (TruongPhong i : arrTP) {
            System.out.print(i.name + "\n");
        }
        ArrayList<NhanVien> NV =  arrNV;
        NV.sort((o1, o2) -> o2.name.charAt(0)-o1.name.charAt(0));
        for (NhanVien i : arrNV) {
            System.out.print(i.name + "\n");
        }
    }
    public static void Sortingsalary(){
        ArrayList<GiamDoc> gd =  arrGiamdoc;
        gd.sort((o1, o2) -> (int) (o2.Count_Salary()-o1.Count_Salary()));
        for (GiamDoc i : arrGiamdoc) {
            System.out.print(i.name +" : "+i.Count_Salary());
        }
        ArrayList<TruongPhong> TP =  arrTP;
        TP.sort((o1, o2) -> (int) (o2.Count_Salary()-o1.Count_Salary()));
        for (TruongPhong i : arrTP) {
            System.out.print(i.name+" : "+i.Count_Salary());
        }
        ArrayList<NhanVien> NV =  arrNV;
        NV.sort((o1, o2) -> (int) (o2.Count_Salary()-o1.Count_Salary()));
        for (NhanVien i : arrNV) {
            System.out.print(i.name+" : "+i.Count_Salary());
        }
    }
    public static void Findmaxrate(){
        GiamDoc gd = arrGiamdoc.get(0);
        gd.rate = 0;
        for(int i = 0 ; i < arrGiamdoc.size();i++) {
            if (gd.rate < arrGiamdoc.get(i).rate) {
                gd.rate = arrGiamdoc.get(i).rate;
                gd = arrGiamdoc.get(i);
            }
        }
        System.out.print("Cố phần lớn nhất " + gd);
    }
    public static void CountGD_Salary(){
        for (GiamDoc i:
             arrGiamdoc) {
            double total = 0 ;
            total += i.Count_Salary()*(cty.salary-CompanyCount());
            System.out.print("Lương của từng giám đóc : " + i.name + ":" + total);
        }
    }
    public static void main(String[] args) {

        do{
            System.out.print("Hãy chọn chức năng ! \n");
            System.out.print("1 . Nhập thông tin công ty \n");
            System.out.print("2 . Tạo nhân viên trong công ty \n");
            System.out.print("3 . Xóa nhân viên \n");
            System.out.print("4 . Phân bố nhân viên vào trưởng phòng  \n");
            System.out.print("5 . Xuất thông tin các nhân viên công ty \n");
            System.out.print("6 . Tìm nhân viên thường có lương cao nhất \n");
            System.out.print("7 . Tìm trưởng phòng có số nhân viên dưới quyền nhiều nhất \n");
            System.out.print("8 . Sắp xếp theo thứ tự abc \n");
            System.out.print("9 . Sắp xếp theo thứ tự lương \n");
            System.out.print("10 . Tìm giám đốc có cổ phần nhiều nhất \n");
            System.out.print("11 . Tổng thu nhập của từng giám đốc trong công ty \n");
            System.out.print("12 . Xuất lương của toàn công ty \n");
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    Nhapcongty();
                    break;
                case 2:
                    CreateNV();
                    break;
                case 3 :
                    DeleteNV();
                    break;
                case 4 :
                    PhanboNV();
                    break;
                case 5 :
                    ShowInfo();
                    break;
                case 6 :
                    Nhanvienluongcao();
                    break;
                case 7 :
                    maxstaff();
                    break;
                case 8 :
                    Sortingabc();
                    break;
                case 9 :
                    Sortingsalary();
                    break;
                case 10 :
                    Findmaxrate();
                    break;
                case 11 :
                    CountGD_Salary();
                    break;
                case 12 :
                    System.out.print("Tổng lương của toàn công ty là : " + CompanyCount()+"\n");
            }
        }while(true);
    }
}