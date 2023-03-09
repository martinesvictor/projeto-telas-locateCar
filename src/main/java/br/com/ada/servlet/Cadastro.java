package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marca = req.getParameter("marca");
        String modelo = req.getParameter("modelo");
        String placa = req.getParameter("placa");
        String proprietario = req.getParameter("proprietario");

        if (marca.equals("") || modelo.equals("") || placa.equals("") || proprietario.equals("")) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos.</h3>");
        } else {
            req.setAttribute("marca", marca);
            req.setAttribute("modelo", modelo);
            req.setAttribute("placa", placa);
            req.setAttribute("proprietario", proprietario);

            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

            rd.forward(req, resp);
        }


    }
}
