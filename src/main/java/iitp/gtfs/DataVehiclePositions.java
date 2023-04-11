package iitp.gtfs;

public class DataVehiclePositions {
    //dataTypes
    float position_latitude;
    float position_longitude;
    float position_speed;
    String trip_trip_id;
    String trip_start_time;
    String trip_start_date;
    String trip_route_id;
    String vehicle_id;
    String vehicle_label;
    long timestamp;

    public DataVehiclePositions(float position_latitude, float position_longitude, float position_speed, String trip_trip_id, String trip_start_time, String trip_start_date, String trip_route_id, String vehicle_id, String vehicle_label, long timestamp) {
        this.position_latitude = position_latitude;
        this.position_longitude = position_longitude;
        this.position_speed = position_speed;
        this.trip_trip_id = trip_trip_id;
        this.trip_start_time = trip_start_time;
        this.trip_start_date = trip_start_date;
        this.trip_route_id = trip_route_id;
        this.vehicle_id = vehicle_id;
        this.vehicle_label = vehicle_label;
        this.timestamp = timestamp;
    }

    public float getPosition_latitude() {
        return position_latitude;
    }

    public float getPosition_longitude() {
        return position_longitude;
    }

    public float getPosition_speed() {
        return position_speed;
    }

    public String getTrip_trip_id() {
        return trip_trip_id;
    }

    public String getTrip_start_time() {
        return trip_start_time;
    }

    public String getTrip_start_date() {
        return trip_start_date;
    }

    public String getTrip_route_id() {
        return trip_route_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public String getVehicle_label() {
        return vehicle_label;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
