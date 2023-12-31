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

class Answer2Test {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;

    private Answer2 answer2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        answer2 = new Answer2();
    }
    @Test
    public void testRedirectToQuestion3WhenYes() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("yes");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("WEB-INF/question3.jsp")).thenReturn(requestDispatcher);

        answer2.doPost(request, response);
        verify(requestDispatcher).forward(request, response);
    }
    @Test
    public void testRedirectToFinalWhenNo() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("no");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("WEB-INF/final.jsp")).thenReturn(requestDispatcher);

        answer2.doPost(request, response);
        verify(session).setAttribute("reply", "Ты не пошел на переговоры.");
        verify(requestDispatcher).forward(request, response);
    }

}