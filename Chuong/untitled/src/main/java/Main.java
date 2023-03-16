import Model.Students;
import StudentDao.Studentdao;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    private static Studentdao studentdao = new Studentdao();
    public static void MainMenu ()
    {
        System.out.println("\n----------- QUAN LY THONG TIN SINH VIEN -------------");
        System.out.println("1. Danh sách sinh vien ");
        System.out.println("2. nhap mot sinh vien theo ma");
        System.out.println("3. xoa mot sinh vien theo ma");
        System.out.println("4. Cập nhật thông tin sinh vien");
        System.out.println("5. tinh mot sinh vien theo ho ten hoac ma(gan dung)");
        System.out.println("6. sap xep mot sinh vien theo diem GPA tang dan");
        System.out.println("7. in ra tat ca cac sinh vien nu co GPQ > 2.5");
        System.out.println("8. xap xep sinh vien theo ho ten theo bang chu cai abc");
        System.out.println("0. thoat");
    }
    private static void  option3(Scanner in)
    {
        Students p = new Students();
        System.out.println("\n nhap id muon xoa");
        String id = in.nextLine();
        studentdao.delete(id);
    }

    private static void option2(Scanner in){
        Students p = new Students();
        System.out.print("\tNhập ID: ");
        p.setId(in.nextLine());
        System.out.print("\tNhập tên: ");
        p.setFull_name(in.nextLine());
        System.out.print("\tNhập gender: ");
        p.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập date: ");
        p.setDate(in.nextLine());
        System.out.print("\tNhập address: ");
        p.setAddress(in.nextLine());
        System.out.print("\tNhập phone: ");
        p.setPhone(in.nextLine());
        System.out.println("\tnhap email: ");
        p.setEmail(in.nextLine());
        System.out.println("\tnhap GPA: ");
        p.setGPA(in.nextDouble());
        studentdao.insert(p);

    }
    private static void option4(Scanner in){
        Students p = new Students();
        System.out.println("\n nhap ID san pham muon nhap ");
        String id = in.nextLine();
        System.out.print("\tNhập tên: ");
        p.setFull_name(in.nextLine());
        System.out.print("\tNhập gender: ");
        p.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập date: ");
        p.setDate(in.nextLine());
        System.out.print("\tNhập address: ");
        p.setAddress(in.nextLine());
        System.out.print("\tNhập phone: ");
        p.setPhone(in.nextLine());
        System.out.print("\tnhap email: ");
        p.setEmail(in.nextLine());
        System.out.print("\tnhap GPA: ");
        p.setGPA(in.nextDouble());
       studentdao.update(p,id);

    }
    private static void option7() {
        List<Students> studentsList = studentdao.getALL();
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "gender", "address");
        System.out.println();
        for (int i = 0; i < studentsList.size(); i++) {

            Students s = studentsList.get(i);
            if (s.getGPA()>2.5 && s.getAddress().equals("HN") && s.getGender()==1 ) {
                System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(), s.getAddress());
            }
        }

    }
    /*
    private static void  option6()
    {

        List<Students> productsList = Studentdao.xapxep();
        System.out.printf("%5s %30s %10s %10s ","STT","name","price","color");
        int dem = 5;
        if(productsList.size()<5)
        {
            dem=productsList.size();
        }
        for(int i = 0;i< dem;i++)
        {
            System.out.printf("\n%5d %30s %10d %10s",i,productsList.get(i).getFull_name()
                    ,productsList.get(i).setDate();,productsList.get(i).getProduct_color());
        }
    }

     */
    public static void main(String[] args) {

            int option = -1;
            do {
                MainMenu();
                System.out.print("Nhập lựa chọn: ");
                // Nhập dữ liệu
                try
                {
                    option = Integer.parseInt(in.nextLine());
                } catch (Exception e)
                {
                    System.out.println("Nhập sai định dạng");
                    continue;
                }
                if (option < 1 || option > 8)
                {
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
                }
                switch (option) {
                    case 1:
                        List<Students> studentsList = Studentdao.getALL();
                        System.out.printf("%10s %30s %10s %10s ","MSV","ho_ten","gender","address");
                        for(int i = 0;i< studentsList.size();i++)
                        {
                            System.out.printf("\n%10s %30s %10d %10s",studentsList.get(i).getId(),studentsList.get(i).getFull_name()
                                    ,studentsList.get(i).getGender(),studentsList.get(i).getAddress());
                        }
                        break;
                    case 2:
                        option2(in);
                        break;
                    case 3:
                       option3(in);
                        break;
                    case 4:
                      option4(in);
                        break;
                    case 5:
                        break;
                    case 6:
                        //  option6();
                        break;
                    case 7:
                        option7();
                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                }

            }
            while (option != 0);
            in.close();
        }
}
