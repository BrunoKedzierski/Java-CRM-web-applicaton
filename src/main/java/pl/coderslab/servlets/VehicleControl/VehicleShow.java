package pl.coderslab.servlets.VehicleControl;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static pl.coderslab.dao.VehicleDao.loadAll;

@WebServlet(name = "VehicleShow", urlPatterns = "/vehicles-show")
public class VehicleShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = VehicleDao.loadAll();
        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/VehicleView/vehicles.jsp").forward(request,response);
    }
}
