package mysql;

import com.google.transit.realtime.GtfsRealtime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaMySQL {


    //database credentials
    static String url = "jdbc:mysql://localhost:3306/gtfsrealtime";
    static String username = "gaurav";
    static String password = "password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

   public static void post(GtfsRealtime.FeedMessage feedMessage) throws Exception {
       String SQL = "INSERT INTO vehiclepositions(position_latitude, position_longitude, position_speed, trip_trip_id, trip_start_time, trip_start_date, trip_route_id, vehicle_id, vehicle_label, timestamp) "
               + "VALUES(?,?,?,?,?,?,?,?,?,?)";

       try (
               Connection conn = connect();
               PreparedStatement statement = conn.prepareStatement(SQL)) {
           int count = 0;

           for (GtfsRealtime.FeedEntity entityItem : feedMessage.getEntityList()) {
               statement.setFloat(1, entityItem.getVehicle().getPosition().getLatitude());
               statement.setFloat(2, entityItem.getVehicle().getPosition().getLongitude());
               statement.setFloat(3, entityItem.getVehicle().getPosition().getSpeed());
               statement.setString(4, entityItem.getVehicle().getTrip().getTripId());
               statement.setString(5, entityItem.getVehicle().getTrip().getStartTime());
               statement.setString(6, entityItem.getVehicle().getTrip().getStartDate());
               statement.setString(7, entityItem.getVehicle().getTrip().getRouteId());
               statement.setString(8, entityItem.getVehicle().getVehicle().getId());
               statement.setString(9, entityItem.getVehicle().getVehicle().getLabel());
               statement.setLong(10, entityItem.getVehicle().getTimestamp());

               statement.addBatch();
               count++;
               // execute every 100 rows or fewer
               if (count % 100 == 0 || count == feedMessage.getEntityCount()) {
                   statement.executeBatch();
               }

           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
}
