package pl.coderslab.dao;

import pl.coderslab.models.Vehicle;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static Vehicle makeVehicle(String[] strs) {
        return new Vehicle()
                .setId(Integer.parseInt(strs[0]))
                .setModel(strs[1])
                .setBrand(strs[2])
                .setProductionYear(Integer.parseInt(strs[3]))
                .setNextCheckup(LocalDate.parse(strs[4]))
                .setOwner(CustomerDao.loadById(Integer.parseInt(strs[5])));
    }

    private static Vehicle loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeVehicle(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Vehicle> loadMany(String query, String... parameters) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> vehicles.add(makeVehicle(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // crud
    public static ArrayList<Vehicle> loadAll() {
        //language=MySQL
        String query = "SELECT * FROM vehicles";
        return loadMany(query);
    }

    public static Vehicle loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM vehicles WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static Vehicle loadByOwnerId(int id) {
        //language=MySQL
        String query = "SELECT * FROM vehicles WHERE owner_id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static void save(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO vehicles(model, brand, productionYear, nextCheckup, owner_id) VALUES(?, ?, ?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query,
                        vehicle.getModel(),
                        vehicle.getBrand(),
                        String.valueOf(vehicle.getProductionYear()),
                        vehicle.getNextCheckup().toString(),
                        String.valueOf(vehicle.getOwner().getId()));
                if (id != null) {
                    vehicle.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE vehicles SET model = ?, brand = ?, productionYear = ?, nextCheckup = ?, owner_id = ? WHERE id = ?";

            try {
                Integer id = DbService.insertIntoDatabase(query,
                        vehicle.getModel(),
                        vehicle.getBrand(),
                        String.valueOf(vehicle.getProductionYear()),
                        vehicle.getNextCheckup().toString(),
                        String.valueOf(vehicle.getOwner().getId()),
                        String.valueOf(vehicle.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM vehicles WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
