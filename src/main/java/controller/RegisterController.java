package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAO;
import model.User;
import model.UserDAO;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;
    String currentUserEmail="";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
            for (int i = 0; i < users.size(); i++)
            {
                if (email.equals(users.get(i).getEmail()))
                {
                    count++;
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }
            }


            if (!email.equals("") && !password.equals("") & !n.equals("") && count == 0)
            {
                UserDAO.instance.save(u1.getEmail(), u1.getName(), u1.getpassword());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            else if(email.equals("") || password.equals("") || !n.equals(""))
                {
                request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            else{
                request.getRequestDispatcher("register.jsp").forward(request, response);
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



