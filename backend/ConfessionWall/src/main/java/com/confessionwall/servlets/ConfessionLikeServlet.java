package com.confessionwall.servlets;

import com.confessionwall.dao.ConfessionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/confessions/likes")
public class ConfessionLikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConfessionDAO confessionDAO;

    @Override
    public void init() {
        confessionDAO = new ConfessionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Get the confession ID from the query parameter (e.g., /api/likes?id=5)
        String idParam = request.getParameter("id");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (idParam == null || idParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Missing confession ID\"}");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            
            // 2. Call the DAO to increment the like count
            confessionDAO.incrementLikes(id);

            // 3. Return success
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Like added successfully\"}");

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid ID format\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }
}