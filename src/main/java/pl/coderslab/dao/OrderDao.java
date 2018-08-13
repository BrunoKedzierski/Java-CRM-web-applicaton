package pl.coderslab.dao;

import pl.coderslab.models.Order;
import pl.coderslab.models.Status;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static Order makeOrder(String[] strs) {
        return new Order()
                .setId(Integer.parseInt(strs[0]))
                .setReceived(LocalDate.parse(strs[1]))
                .setPlanedBeginning(strs[2] != null ? LocalDate.parse(strs[2]) : null)
                .setBegun(strs[3] != null ? LocalDate.parse(strs[3]) : null)
                .setEmployee(EmployeeDao.loadById(Integer.parseInt(strs[4])))
                .setProblemDescription(strs[5])
                .setRepairDescription(strs[6])
                .setStatus(Status.valueOf(strs[7]))
                .setVehicle(VehicleDao.loadById(Integer.parseInt(strs[8])))
                .setPrice(Float.parseFloat(strs[9]))
                .setExpense(Float.parseFloat(strs[10]))
                .setManhours(Integer.parseInt(strs[11]));
    }

    private static Order loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeOrder(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Order> loadMany(String query, String... parameters) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> orders.add(makeOrder(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // crud
    public static ArrayList<Order> loadAll() {
        //language=MySQL
        String query = "SELECT * FROM orders";
        return loadMany(query);
    }

    public static Order loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM orders WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static void save(Order order) {
        if (order.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO orders (received,\n" +
                    "                    planedBeginning,\n" +
                    "                    begun,\n" +
                    "                    employee_id,\n" +
                    "                    problemDescription,\n" +
                    "                    repairDescription,\n" +
                    "                    status,\n" +
                    "                    vehicle_id,\n" +
                    "                    price,\n" +
                    "                    expense,\n" +
                    "                    manhours)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query,
                        order.getReceived().toString(),
                        order.getPlanedBeginning().toString(),
                        order.getBegun().toString(),
                        String.valueOf(order.getEmployee().getId()),
                        order.getProblemDescription(),
                        order.getRepairDescription(),
                        order.getStatus().toString(),
                        String.valueOf(order.getVehicle().getId()),
                        String.valueOf(order.getPrice()),
                        String.valueOf(order.getExpense()),
                        String.valueOf(order.getManhours()));
                if (id != null) {
                    order.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE orders\n" +
                    "SET received           = ?,\n" +
                    "    planedBeginning    = ?,\n" +
                    "    begun              = ?,\n" +
                    "    employee_id        = ?,\n" +
                    "    problemDescription = ?,\n" +
                    "    repairDescription  = ?,\n" +
                    "    status             = ?,\n" +
                    "    vehicle_id         = ?,\n" +
                    "    price              = ?,\n" +
                    "    expense            = ?,\n" +
                    "    manhours           = ?\n" +
                    "WHERE id = ?";

            try {
                DbService.executeUpdate(query,
                        order.getReceived().toString(),
                        order.getPlanedBeginning().toString(),
                        order.getBegun().toString(),
                        String.valueOf(order.getEmployee().getId()),
                        order.getProblemDescription(),
                        order.getRepairDescription(),
                        order.getStatus().toString(),
                        String.valueOf(order.getVehicle().getId()),
                        String.valueOf(order.getPrice()),
                        String.valueOf(order.getExpense()),
                        String.valueOf(order.getManhours()),
                        String.valueOf(order.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM orders WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
