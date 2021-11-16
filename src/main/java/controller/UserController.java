package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookDAO;
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



        String bookToDeleteEmail = request.getParameter("userEmailToDelete");

        try {

            UserDAO.instance.deleteUser(bookToDeleteEmail);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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

                    if (password.equals(users.get(i).getpassword())) {
                        count++;

                        HttpSession session = request.getSession();
                        session.setAttribute("userName", users.get(i).getName());
                        session.setAttribute("userEmail", email);

                        currentUser.add(users.get(i));
                        currentUserEmail = users.get(i).getEmail();

                        //CODE FOR USERS---------------------------------------------------------------------
                    } else
                        {
                        System.out.println("Password is incorrect");
//                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                }
                else {
                    System.out.println("Email is incorrect");
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            }
            if(count>0){
                request.setAttribute("userList", currentUser);
                request.getRequestDispatcher("showUser.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        catch (Exception e)
        {
            System.out.println("information could not be retrieved");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}



