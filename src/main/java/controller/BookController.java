package controller;//package edu.ait.controller;

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
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String bookToDeleteTitle = request.getParameter("bookToDelete");
        String bookToDeleteEmail = request.getParameter("userEmail");
        System.out.println(bookToDeleteEmail + ", " + bookToDeleteTitle);
        try {

            BookDAO.instance.delete(bookToDeleteEmail, bookToDeleteTitle);

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

        String t = request.getParameter("bookTitle");
        String a = request.getParameter("bookAuthor");
         String userEmail = request.getParameter("userEmail");


        ArrayList<Book> listOfBooks = null;



        try {

            if(!t.equals("") && !a.equals(""))
            {
                BookDAO.save(userEmail,t,a);
                listOfBooks = BookDAO.instance.selectOne(userEmail);
                request.setAttribute("myList", listOfBooks);
                request.getRequestDispatcher("showBooks.jsp").forward(request, response);

            }
            listOfBooks = BookDAO.instance.selectOne(userEmail);





        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("myList", listOfBooks);
        request.getRequestDispatcher("showBooks.jsp").forward(request, response);
    }





}
