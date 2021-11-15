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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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

      String ID = request.getParameter("bookID");
        String updateTitle = request.getParameter("bookUpdateName");
        String updateAuthor = request.getParameter("bookUpdateAuthor");


        try {
            System.out.println("ID =" +ID);
                if(!updateTitle.equals("") && !updateAuthor.equals("")){
                   BookDAO.updateTitle(ID, updateTitle);
                   BookDAO.updateAuthor(ID,updateAuthor);

                }
                else if(!updateAuthor.equals("")){
                    BookDAO.updateAuthor(ID, updateAuthor);

                }
                else if(!updateTitle.equals("")){
                    BookDAO.updateTitle(ID, updateTitle);

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



