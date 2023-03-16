package Model;

public class Students implements Comparable<Students> {
    private String id;
    private String full_name;
    private int gender;
    private String date;
    private String address;
    private String phone;
    private String email;
    private double GPA;

    public Students() {
    }

    public Students(String id, String full_name, int gender, String date, String address, String phone, String email, double GPA) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Students[" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", GPA=" + GPA +
                ']';
    }

    @Override
    public int compareTo(Students o)
    {
        if(this.GPA > o.GPA){
            return 1;
        }
        else if(this.GPA < o.GPA){
            return  -1;
        }
        return 0;
    }

}
