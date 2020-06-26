package bpdts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class BPDTSServices {

    private String peopleInCityURL = "https://bpdts-test-app-v3.herokuapp.com/city/{city}/users";
    private String peopleURL = "https://bpdts-test-app-v3.herokuapp.com/users";
    private String personByIdURL = "https://bpdts-test-app-v3.herokuapp.com/user/{id}";
    private CallBPDTSAPI callBPDTSInfo = new CallBPDTSAPI();
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Person> getPeopleInCity (String city) throws IOException {
        String url = peopleInCityURL.replace("{city}", city);
        String peopleString = callBPDTSInfo.returnBPDTSAPICall(url);
        return objectMapper.readValue(peopleString, new TypeReference<List<Person>>(){});
    }

    public List<Person> getAllPeople () throws IOException {
        String peopleString = callBPDTSInfo.returnBPDTSAPICall(peopleURL);
        return objectMapper.readValue(peopleString, new TypeReference<List<Person>>(){});
    }

    public Person getPersonById (String id) throws IOException {
        String url = personByIdURL.replace("{id}", id);
        String personString = callBPDTSInfo.returnBPDTSAPICall(url);
        return objectMapper.readValue(personString, new TypeReference<Person>(){});
    }
}
