package bpdts;

import java.io.IOException;
import java.util.*;

public class TestServices {

    BPDTSServices bpdtsServices = new BPDTSServices();

    /**
     * Returns a list of People who live in the city passed to this method. People will not have the city included in their details
     * @param city
     * @return
     * @throws IOException
     */
    List<Person> inCity (String city) throws IOException {
        return bpdtsServices.getPeopleInCity(city);
    }

    /**
     * Returns a list of people who live within the distance. People will not have the city included in their details
     * @param distance from point given by latitude and longitude
     * @param latitude of point to be measured from
     * @param longitude of point to be measured from
     * @return
     */
    List<Person> withinDistanceOfPoint (Double distance, Double latitude, Double longitude) throws IOException {
        List <Person> returnList = new ArrayList<>();

        bpdtsServices.getAllPeople().stream().
                filter(person -> Utilities.getDistanceFromPoint(latitude, longitude, person.getLatitude(), person.getLongitude()) <= distance).
                forEach(person -> returnList.add(person));

        return returnList;
    }

    /**
     * Convenience method to return a list of people who live in a city or live within the specified distance of the point defined by
     * the latitude and longitude (degrees).
     * It is expected that the latitude and longitude will correspond to the city, however the calling process must determine the
     * correct latitude and longitude to use.
     * People will have the city included in their details
     * @param city    city which people live in
     * @param distance  from latitude / longitude for people to be included in the list
     * @param latitude  latitude of point where distance measure is taken
     * @param longitude longitude of point where distance measure is taken
     * @return  A list of unique Person objects satisfying the criteria and including the city for each
     */
    List<Person> inCityOrWithinDistanceOfCity (String city, Double distance, Double latitude, Double longitude) throws IOException {

        // used to remove duplicates and to get full details of each person - although not a requirement we will get the results in id order also
        Set<String> peopleIds = new TreeSet<>();
        List<Person> peopleList = new ArrayList<>();

        withinDistanceOfPoint(distance, latitude, longitude).stream().forEach(person -> peopleIds.add(person.getId()));
        inCity(city).stream().forEach(person -> peopleIds.add(person.getId()));

        peopleIds.stream().forEach(id -> {
            try {
                peopleList.add(bpdtsServices.getPersonById(id));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return peopleList;
    }

}
