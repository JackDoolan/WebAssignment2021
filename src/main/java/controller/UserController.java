package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;
//    UserDAO userDAO;

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
        String address = request.getParameter("userAddress");

        User u1 = new User(email, n, address);
        System.out.println(u1.getName());
        try {

            ArrayList<User> users = UserDAO.instance.list();



           //For loop to save new entries into database
            int count = 0;
            for(int i=-0; i<users.size(); i++)
            {
                if (email.equals(users.get(i).getEmail()))
                {
                    count ++;

                                   }
            }
                if(count ==0)
                {
        UserDAO.instance.save(u1.getEmail(),u1.getName(),u1.getAddress());

                }






//            UserDAO.instance.save(u1);
//            String check = "jack@gmail.com";
//            User user = UserDAO.instance.selectOne(check);
//            System.out.println(u1.getName());

            request.setAttribute("userList", users);
            request.getRequestDispatcher("showUser.jsp").forward(request, response);
        }
        catch (Exception e) {
            System.out.println("information could not be retrieved");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


    }

}
