package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.User;
import model.UserDAO;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;
    String currentUserEmail="";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("userEmail");
        String n = request.getParameter("userName");
        String password = request.getParameter("userPassword");

        User u1 = new User(email, n, password);
        try {

            ArrayList<User> users = UserDAO.instance.list();

            ArrayList<User> currentUser = new ArrayList<User>();

            //For loop to save new entries into database
            int count = 0;
            for (int i = 0; i < users.size(); i++) {
                if (email.equals(users.get(i).getEmail())) {
                    count++;
                    if (password.equals(users.get(i).getpassword())) {
                        //CODE FOR BOOKS---------------------------------------------------------------------
                        //CODE FOR BOOKS---------------------------------------------------------------------

                        //CODE FOR USERS---------------------------------------------------------------------
                        currentUser.add(users.get(i));
                        currentUserEmail = users.get(i).getEmail();
                        request.setAttribute("userList", currentUser);
                        request.getRequestDispatcher("showUser.jsp").forward(request, response);
                        //CODE FOR USERS---------------------------------------------------------------------
                    } else {
                        System.out.println("Password is incorrect");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                }

            }
            if (!email.equals("") && !password.equals("") & !n.equals("") && count == 0) {
                UserDAO.instance.save(u1.getEmail(), u1.getName(), u1.getpassword());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }


//
//
//            request.setAttribute("myList", listOfBooks);
//            request.getRequestDispatcher("showUser.jsp").forward(request, response);
//            UserDAO.instance.save(u1);
//            String check = "jack@gmail.com";
//            User user = UserDAO.instance.selectOne(check);
//            System.out.println(u1.getName());


        } catch (Exception e) {
            System.out.println("information could not be retrieved");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


    }
    public String getCurrentUserEmail() {
        return currentUserEmail;
    }


}
