package com.example.final3tom10;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/answer3")
public class Answer3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        if (answer.equals("yes")) {
            req.getRequestDispatcher("WEB-INF/win.jsp").forward(req, resp);
        } else if (answer.equals("no")) {
            req.getSession().setAttribute("reply", "Тебя разоблачили");
            req.getRequestDispatcher("WEB-INF/final.jsp").forward(req, resp);
        }
    }
}
