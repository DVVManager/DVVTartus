package ua.com.tartustour.usermanager;

/**
 * Created by Administrator on 11/6/2016.
 */
public class User {

    private String name;
    private String secondname;
    private String email;
    private String phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getName() {
        return name;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString(){
        return "Name: "+this.getName()+" Secondname: "+this.getSecondname()+"Contacts: "+this.getEmail()+" "+this.getPhone();
    }

}
