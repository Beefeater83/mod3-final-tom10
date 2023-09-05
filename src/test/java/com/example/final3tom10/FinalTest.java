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


class FinalTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;

    private Final finalServlet;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        finalServlet=new Final();
    }
    @Test
    public void testForwardToFinal() throws ServletException, IOException {
        when(request.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);

        finalServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

}