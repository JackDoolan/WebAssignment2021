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
 * Servlet implementation class AllUsersController
 */
@WebServlet("/AllUsersController")
public class AllUsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsersController() {
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


        ArrayList<User> allUsers = new ArrayList<>();





    try {
           allUsers = UserDAO.instance.selectAll();
           for(int i =0; i<allUsers.size(); i++){
               System.out.println(allUsers.get(i).getEmail());
               System.out.println(allUsers.get(i).getName());
               System.out.println(allUsers.get(i).getpassword());
           }

        request.setAttribute("myUserList", allUsers);
        request.getRequestDispatcher("showAllUsers.jsp").forward(request, response);




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



