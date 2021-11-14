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
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        UserController userController = new UserController();
        String t = request.getParameter("bookTitle");
        String a = request.getParameter("bookAuthor");

        ArrayList<Book> listOfBooks = new ArrayList();

        Book b1 = new Book(t, a);
        listOfBooks.add(b1);
        System.out.println("DO POST BookController");
        try {
            System.out.println("Try is Tried?");
            System.out.println("penis" + userController.getCurrentUserEmail());
           System.out.println(BookDAO.instance.selectOne(userController.getCurrentUserEmail()));
            System.out.println("Try is ran");

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("myList", listOfBooks);
        request.getRequestDispatcher("showBooks.jsp").forward(request, response);
    }

}
