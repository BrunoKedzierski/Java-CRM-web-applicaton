package pl.coderslab.servlets.VehicleControl;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Customer;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "VehicleEdit", urlPatterns = "/vehicle-edit")
public class VehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String idStr = request.getParameter("idV");
        String brand = request.getParameter("brand");
        String productionYearStr = request.getParameter("year");
        LocalDate nextCheckup = LocalDate.parse(request.getParameter("checkup"));
        String customer_idStr = request.getParameter("id");
        int customer_id = Integer.parseInt(customer_idStr);
        int productionYear = Integer.parseInt(productionYearStr);
        int id = Integer.parseInt(idStr);
        Customer customer = CustomerDao.loadById(customer_id);
        Vehicle vehicle = new Vehicle(id,model,brand,productionYear,nextCheckup,customer);
        VehicleDao.save(vehicle);


        response.sendRedirect("/vehicles-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        ArrayList<Customer> customers = CustomerDao.loadAll();
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/VehicleView/VehicleEditForm.jsp").forward(request,response);
    }
}
