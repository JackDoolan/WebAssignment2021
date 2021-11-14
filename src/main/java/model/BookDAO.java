package model;

import java.sql.*;
import java.util.ArrayList;

public enum BookDAO {
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

    public Book selectOne(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USE BOOK where USEREMAIL ='" + email +"'");
        while(rs.next()) {

            if(rs.getString("USEREMAIL").equals(email)) {

                Book b = new Book(rs.getString("BOOKTITLE"), rs.getString("BOOKAUTHOR"));

                return b;

            }

        }
        return null;
    }


    public void save(String email, String name, String password) throws Exception{

        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO USER VALUES('"+email+"','"+name+"','"+password+"' )");


//        psmt.setString(1, u.getEmail());
//        psmt.setString(2, u.getName());
//        psmt.setString(3,u.getPassword());
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
            User u = new User(rs.getString("email"), rs.getString("name"), rs.getString("password"));
            listOfUsers.add(u);

        }
        rs.close();
        stmt.close();
        conn.close();
        return listOfUsers;
    }

}
