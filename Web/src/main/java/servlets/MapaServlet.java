package servlets;

import controller.Controller;
import domain.Results;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/MapaServlet")
public class MapaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BigDecimal x = new BigDecimal(request.getParameter("x"));
        BigDecimal y = new BigDecimal(request.getParameter("y"));
        Controller controller = new Controller();
        List<Results> list =controller.start(x, y);
        request.setAttribute("x", x);
        request.setAttribute("y", y);
        request.setAttribute("list", list);
        request.getRequestDispatcher("mapa.jsp").forward(request, response);
    }
}