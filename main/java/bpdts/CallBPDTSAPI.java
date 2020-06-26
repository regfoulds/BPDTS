package bpdts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CallBPDTSAPI {

    public String returnBPDTSAPICall(String url) throws IOException {
        URL bpdtsURL = new URL(url);
        URLConnection yc = bpdtsURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();
        return response.toString();
    }
}
