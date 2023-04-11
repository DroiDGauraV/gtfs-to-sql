package iitp.gtfs;

import com.google.transit.realtime.GtfsRealtime.FeedMessage;

import java.net.URL;
import java.util.List;

public class GtfsRealtime {
    //static DataVehiclePositions data;

    public static void main(String[] args) throws Exception {
        //URL urlKingston = new URL("https://api.cityofkingston.ca/gtfs-realtime/vehicleupdates.pb");
        //URL urlTexas = new URL("https://data.texas.gov/download/eiei-9rpf/application%2Foctet-stream");
        //1st 2 lines of do goes here
        URL urlIIITD = new URL("https://opendata.iiitd.edu.in/api/realtime/VehiclePositions.pb?key=fGm5nYfdpA40w8LyZA6h1r2T1rrImh91");
        FeedMessage feed = FeedMessage.parseFrom(urlIIITD.openStream());
        /*either use this line*/
        //JavaMySQL.post(feed);
        /*or this*/
        //for (FeedEntity entityList : feed.getEntityList()) {
        //    if (entityList.hasVehicle()) {
        //        data = new DataVehiclePositions(
        //                entityList.getVehicle().getPosition().getLatitude(),
        //                entityList.getVehicle().getPosition().getLongitude(),
        //                entityList.getVehicle().getPosition().getSpeed(),
        //                entityList.getVehicle().getTrip().getTripId(),
        //                entityList.getVehicle().getTrip().getStartTime(),
        //                entityList.getVehicle().getTrip().getStartDate(),
        //                entityList.getVehicle().getTrip().getRouteId(),
        //                entityList.getVehicle().getVehicle().getId(),
        //                entityList.getVehicle().getVehicle().getLabel(),
        //                entityList.getVehicle().getTimestamp());
        //
        //    }
        //}

        for (com.google.transit.realtime.GtfsRealtime.FeedEntity entityList : feed.getEntityList()) {
            if (entityList.hasVehicle()) {
                System.out.println(entityList.getId());
                System.out.println(entityList.getVehicle()+"\n\n");
            }
        }
        System.out.println(feed.getEntityCount());
        //for (int i = 1; i != 0;) {
        //    URL urlIIITD = new URL("https://opendata.iiitd.edu.in/api/realtime/VehiclePositions.pb?key=fGm5nYfdpA40w8LyZA6h1r2T1rrImh91");
        //    FeedMessage feed = FeedMessage.parseFrom(urlIIITD.openStream());
        //    List<com.google.transit.realtime.GtfsRealtime.FeedEntity> list = feed.getEntityList();
        //    Float lat = list.get(3).getVehicle().getPosition().getLongitude();
        //    System.out.println(lat);
        //    System.out.println(System.currentTimeMillis());
        //    Thread.sleep(500);
        //}
    }
}