package pl.coderslab.dao;

import pl.coderslab.models.Employee;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static Employee makeEmployee(String[] strs) {
        return new Employee()
                .setId(Integer.parseInt(strs[0]))
                .setName(strs[1])
                .setSurname(strs[2])
                .setAddress(strs[3])
                .setPhone(strs[4])
                .setNote(strs[5])
                .setManhourValue(Float.parseFloat(strs[6]));
    }

    private static Employee loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeEmployee(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Employee> loadMany(String query, String... parameters) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> employees.add(makeEmployee(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // crud
    public static ArrayList<Employee> loadAll() {
        //language=MySQL
        String query = "SELECT * FROM employees";
        return loadMany(query);
    }

    public static Employee loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM employees WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static void save(Employee employee) {
        if (employee.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO employees(name, surname, address, phone, note, manhourValue) VALUES(?, ?, ?, ?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query,
                        employee.getName(),
                        employee.getSurname(),
                        employee.getAddress(),
                        employee.getPhone(),
                        employee.getNote(),
                        String.valueOf(employee.getManhourValue()));
                if (id != null) {
                    employee.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE employees SET name = ?, surname = ?, address = ?, phone = ?, note = ?, manhourValue = ? WHERE id = ?";

            try {
                DbService.executeUpdate(query,
                        employee.getName(),
                        employee.getSurname(),
                        employee.getAddress(),
                        employee.getPhone(),
                        employee.getNote(),
                        String.valueOf(employee.getManhourValue()),
                        String.valueOf(employee.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM employees WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
