package bpdts;

public class Utilities {

    /**
     * Returns the distance between two points defined by latitude / longitude  from and to.  The distance will always be defined as positive.
     * This method has been copied from an example - it should be looked into in more detail to determine if it is actually correct
     * @param latitudeFrom
     * @param longitudeFrom
     * @param latitudeTo
     * @param longitudeTo
     * @return
     */
    public static Double getDistanceFromPoint (Double latitudeFrom, Double longitudeFrom, Double latitudeTo, Double longitudeTo) {
        longitudeFrom = Math.toRadians(longitudeFrom);
        latitudeFrom = Math.toRadians(latitudeFrom);
        longitudeTo = Math.toRadians(longitudeTo);
        latitudeTo = Math.toRadians(latitudeTo);

        // Haversine formula
        double dlon = longitudeTo - longitudeFrom;
        double dlat = latitudeTo - latitudeFrom;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(latitudeFrom) * Math.cos(latitudeTo)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 3956;    // radius of earth

        // calculate the result
        return(c * r);
    }


}
