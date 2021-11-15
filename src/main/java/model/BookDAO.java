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

    public static Connection getConnection() throws Exception {


        Class.forName("org.hsqldb.jdbcDriver");


        Connection con = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

        return con;
    }

    public ArrayList<Book> selectOne(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK where USEREMAIL ='" + email +"'");
        ArrayList<Book> books = new ArrayList<>();
        while(rs.next()) {

            if(rs.getString("USEREMAIL").equals(email)) {

                Book b = new Book(rs.getString("BOOKID"), rs.getString("BOOKTITLE"), rs.getString("BOOKAUTHOR"));
books.add(b);


            }

        }
        return books;

    }


    public static void save(String email, String title, String author) throws Exception{

        Connection conn = getConnection();
           PreparedStatement psmt = conn.prepareStatement("INSERT INTO BOOK VALUES(null, +'"+email+"','"+title+"','"+author+"')");
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }


    public static void updateTitle(String ID, String title) throws Exception{

        Connection conn = getConnection();
        System.out.println(ID + "," + title);
        PreparedStatement psmt = conn.prepareStatement("UPDATE BOOK SET BOOKTITLE = '"+title+"' where BOOKID = '"+ID+"'");
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

    public static void updateAuthor(String ID, String author) throws Exception{

        Connection conn = getConnection();
        System.out.println(ID + "," + author);
        PreparedStatement psmt = conn.prepareStatement("UPDATE BOOK SET BOOKAUTHOR = '"+author+"' where BOOKID = '"+ID+"'");
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }



    public void delete(String email, String title) throws Exception
    {
        System.out.println("BOOKDAO : "+ email + ", " + title);
        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("DELETE FROM BOOK WHERE USEREMAIL = '"+email+"' AND BOOKTITLE = '"+title+"'");
        System.out.println(psmt);
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }






}
