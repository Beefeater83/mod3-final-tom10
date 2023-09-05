package com.example.final3tom10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;


class GreetingServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;

    private GreetingServlet greetingServlet;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        greetingServlet = new GreetingServlet();
    }
    @Test
    public void testValidUserNameAndNumberOfGames() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("Sergey");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("WEB-INF/question1.jsp")).thenReturn(requestDispatcher);

        greetingServlet.doPost(request, response);

        verify(session).setAttribute("username", "Sergey");
        verify(session).setAttribute("numberOfGames", 1);
        verify(requestDispatcher).forward(request, response);
    }

}