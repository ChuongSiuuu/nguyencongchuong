package StudentDao;

import Model.Students;
import Myconnection.Myconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Studentdao {
    public static List<Students> getALL() {
        final  String sql = "select*from `students`";
        List<Students> studentsList = new ArrayList<>();
        try {
            Connection conn = Myconnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Students p = new Students();
                p.setId(rs.getString("id"));
                p.setFull_name(rs.getString("full_name"));
                p.setGender(rs.getInt("gender"));
                p.setDate(rs.getString("date"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setGPA(rs.getDouble("GPA"));
                studentsList.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
    public Students getById(String id) {
        Students s= null;
        try {
            Connection conn = Myconnection.getConnection();
            final String sql = "SELECT * FROM students WHERE id = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setDate(rs.getString("year"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGPA(rs.getDouble("gpa"));

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public void update(Students students, String id) {
        Students tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Sinh vien không tồn tại!");
        }

        final String sql = String.format("UPDATE `students` SET `id`='%s',`full_name`='%s',`gender`='%d',  `date`=`%s`,`address`='%s',`phone`='%s',`email`=`%s`,`GPA`=`%f` WHERE `id` = '%s'",
                students.getId(), students.getFull_name(), students.getGender(),students.getGender(), students.getAddress(), students.getPhone(), students.getEmail(),students.getGPA(),id
        );
        try {
            Connection conn = Myconnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insert(Students s) {

        if (getById(s.getId()) != null) {
            System.out.println("ID này đã tồn tại");
        } else {
            final String sql = String.format("INSERT INTO students VALUES ('%s','%s',%d,'%s','%s','%s','%s','%f')",
                    s.getId(), s.getFull_name(), s.getGender(), s.getDate(), s.getAddress(), s.getEmail(), s.getPhone(), s.getGPA()
            );

            try {
                Connection conn = Myconnection.getConnection();
                Statement stmt = conn.createStatement();

                int rs = stmt.executeUpdate(sql);
                if (rs == 0) {
                    System.out.println("Thêm thất bại!");
                }
                stmt.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(String id) {

        if (getById(id)==null){
            System.out.println("Không tồn tại id này!");
        }
        try {
            Connection conn = Myconnection.getConnection();
            final String sql =String.format("DELETE FROM students WHERE id = '%s' ", id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /*
    public static List<Students> xapxep() {
        final  String sql = "select*from `products` order by product_price desc";
        List<Students> productsList = new ArrayList<>();
        try {
            Connection conn = Myconnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setDate(rs.getString("year"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGPA(rs.getDouble("gpa"));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }


     */

}
