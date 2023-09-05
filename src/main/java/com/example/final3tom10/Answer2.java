package com.example.final3tom10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/answer2")
public class Answer2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        if (answer.equals("yes")) {
            req.getRequestDispatcher("WEB-INF/question3.jsp").forward(req, resp);
        } else if (answer.equals("no")) {
            req.getSession().setAttribute("reply", "Ты не пошел на переговоры.");
            req.getRequestDispatcher("WEB-INF/final.jsp").forward(req, resp);
        }
    }
}
