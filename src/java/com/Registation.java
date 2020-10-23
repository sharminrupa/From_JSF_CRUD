package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "st", eager = true)
@SessionScoped

public class Registation {

    private int id;
    private String name;
    private String mobile;
    private String email;
    private String gender;
    //private String[] education;
    private String applay;
    private String date;
    private String address;
    private List<Registation> reg = null;
    private Connection conn = null;
    private PreparedStatement pst = null;

    public void init(){
        try {
            reg = new ArrayList<>();
            conn = DBAccess.getconn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Registation> getShowData() {  
        init();
        try {
            String sql = "select * from forms";
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Registation r = new Registation();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setMobile(rs.getString("mobile"));
                r.setEmail(rs.getString("email"));
                r.setGender(rs.getString("gender"));
                //r.setEducation(rs.getString("education"));
                r.setApplay(rs.getString("applay"));
                r.setDate(rs.getString("date"));
                r.setAddress(rs.getString("address"));
                reg.add(r);
            }

        } catch (SQLException ex) {

        }
        return reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setNumber(String number) {
        this.mobile = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String[] getEducation() {
//        return education;
//    }
//
//    public void setEducation(String[] education) {
//        this.education = education;
//    }
    public String getApplay() {
        return applay;
    }

    public void setApplay(String applay) {
        this.applay = applay;
    }

    public void send() {
        System.out.println("Date........." + date);
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

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Registation> getReg() {
        return reg;
    }

    public void setReg(List<Registation> reg) {
        this.reg = reg;
    }

}
