package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectorServlet")
public class SelectorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        choiseApk(request, response);
    }

    private void choiseApk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("btWeather") != null) {
            request.getRequestDispatcher("homeWeather.html").forward(request, response);
        }
        if (request.getParameter("btEarthquakes") != null) {
            request.getRequestDispatcher("homeMap.jsp").forward(request, response);
            response.sendRedirect("homeMap.jsp");
        }
    }
}
