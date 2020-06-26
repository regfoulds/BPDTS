package bpdts;

import java.io.IOException;

public class BPDTSMain {

    public static void main (String [] args) throws IOException {

        // Run the TestServices API to return all people living in London or within 60 miles of London
        Double latLondon = 51.5074;
        Double longLondon = 0.1278;
        TestServices testServices = new TestServices();
        for (Person p : testServices.inCityOrWithinDistanceOfCity("London", 60d, latLondon, longLondon))
            System.out.println(p);
    }
}
