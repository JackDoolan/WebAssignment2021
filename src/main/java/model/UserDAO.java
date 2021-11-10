package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public enum UserDAO {
    instance;

    //CRUD
    //Create - Insert - save
    //Read - Select - list
    //Update - Update - update
    //Delete - Delete - remove

    public Connection getConnection() throws Exception {


        Class.forName("org.hsqldb.jdbcDriver");


        Connection con = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

        return con;
    }

    public User selectOne(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email +"'");
        while(rs.next()) {

            if(rs.getString("email").equals(email)) {

                User u = new User(rs.getString("email"),rs.getString("name"), "blank");
                return u;
            }

        }
        return null;
    }


    public void save(User u) throws Exception{

        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO USER(email, name, address) VALUES (?,?,?)");


        psmt.setString(1, u.getEmail());
        psmt.setString(2,  u.getName());
        psmt.setString(3,u.getAddress());
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

    public ArrayList<User> list() throws Exception{

        ArrayList<User> listOfUsers = new ArrayList();

        Connection conn = getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
        while (rs.next()) {
            User u = new User(rs.getString("email"), rs.getString("name"), rs.getString("address"));
            listOfUsers.add(u);

        }
        rs.close();
        stmt.close();
        conn.close();
        return listOfUsers;
    }

}
