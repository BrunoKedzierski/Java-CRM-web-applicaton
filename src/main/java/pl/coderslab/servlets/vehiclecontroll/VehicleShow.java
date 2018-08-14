package pl.coderslab.servlets.vehiclecontroll;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VehicleShow", urlPatterns = "/vehicle-show")
public class VehicleShow extends HttpServlet {
    private static String mode;

    @Override
    public void init() throws ServletException {
        mode = "show";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("show".equals(mode)) {
            mode = "edit";
        } else {
            mode = "show";
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Vehicle> vehicles = VehicleDao.loadAll();
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("mode", mode);
        getServletContext().getRequestDispatcher("/vehicles.jsp").forward(request, response);

    }
}
