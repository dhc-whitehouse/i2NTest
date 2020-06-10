package dhw.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dhw.dao.PersonDAO;
import dhw.models.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    private PersonDAO personDAO;

    @InjectMocks
    private PersonService personService;

    //Define some static test values
    private String daoString;
    /**
     * Setup the common data for the tests to follow.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Map<String, Object> params = new HashMap<>();
        params.put("person_id", "49fdd3c7-971d-4599-9cd7-a6ccf5513995");
        params.put("created_datetime", "2020-04-14 08:17:30.660950");
        params.put("created_by_username", "Unable to get username");
        params.put("updated_datetime", "2020-04-14 08:17:30.660950");
        params.put("updated_by_username", "Unable to get username");
        params.put("first_name", "James");
        params.put("middle_name", "Michael");
        params.put("last_name", "Smith");
        params.put("date_of_birth", "1999-04-14");
        params.put("deleted", "false");
        params.put("gender", 2);
        params.put("ethnicity", 3);
        params.put("nationality", 4);
        params.put("preferred_language", 5);
        params.put("religion", 6);
        params.put("other", null);
        params.put("status_id", 29001);
        params.put("person_reference_number", "LN43385");
        params.put("mobile_phone", null);
        params.put("other_phone", null);
        params.put("email_address", null);
        params.put("staff_allocation", null);
        params.put("preferred_language", null);
        params.put("team_allocation", null);
        params.put("interpreter_required", null);
        params.put("person_custody_details_id", null);
        params.put("team_id", null);
        params.put("org_id", null);
        params.put("area_id", null);
        try {
            daoString = "[" + new ObjectMapper().writeValueAsString(params) + ",";
        }catch (JsonProcessingException e){
        }

        // Second client with same first_name, middle_name, last_name and Date_of_birth to be filtered out
        params.put("person_id", "49fdd3c7-971d-4599-9cd7-a6ccf5513996");
        try {
            daoString += new ObjectMapper().writeValueAsString(params) + ",";
        }catch (JsonProcessingException e){
        }

        // Third client with different middle_name to be kept
        params.put("person_id", "49fdd3c7-971d-4599-9cd7-a6ccf5513997");
        params.put("middle_name", "Michael1");
        try {
            daoString += new ObjectMapper().writeValueAsString(params) + ",";
        }catch (JsonProcessingException e){
        }

        // Client dob after 31.12.99 to be filtered out
        params.put("person_id", "3dc1d79c-2776-4685-8cfa-e525ec776754");
        params.put("first_name", "Solomon");
        params.put("middle_name", "Irvin");
        params.put("last_name", "Juarez");
        params.put("date_of_birth", "2001-10-27");
        try {
            daoString += new ObjectMapper().writeValueAsString(params) + ",";
        }catch (JsonProcessingException e){
        }

        // Client with first name beginning letter C so that first client output from sorted array
        params.put("person_id", "401e7e04-f09f-49de-9558-6a019f581692");
        params.put("first_name", "Christian");
        params.put("middle_name", "Conrad");
        params.put("last_name", "Carroll");
        params.put("date_of_birth", "1972-04-14");
        try {
            daoString += new ObjectMapper().writeValueAsString(params) + "]";
        }catch (JsonProcessingException e){
        }
    }

    @Test
    public void checkPrepareListPersons() {
        doReturn(daoString).when(personDAO).readDataFile(anyString(), anyString());
        try {
            List<Person> persons = personService.prepareListPersons("", "");
            assertEquals(3, persons.size());
            assertEquals("401e7e04-f09f-49de-9558-6a019f581692",persons.get(0).getPerson_id());
            assertEquals("49fdd3c7-971d-4599-9cd7-a6ccf5513995",persons.get(1).getPerson_id());
            assertEquals("49fdd3c7-971d-4599-9cd7-a6ccf5513997",persons.get(2).getPerson_id());
        }catch (Exception e){
            e.printStackTrace();
            fail("Should not have thrown an exception");
        }
    }

    @Test
    public void checkExceptionThrownEmptyFile() {
        daoString = null;
        doReturn(daoString).when(personDAO).readDataFile(anyString(), anyString());
        try {
            List<Person> persons = personService.prepareListPersons("", "");
            fail("Should have thrown an exception");
        } catch (Exception e) {
            assertEquals("Unable to read file or no data read from file", e.getMessage());
        }
    }


    @Test
    public void checkProcessingContinuesForJSonError() {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("person_id", "49fdd3c7-971d-4599-9cd7-a6ccf5513995");
        params1.put("created_datestime", "2020-04-14 08:17:30.660950"); // Incorrect field name
        params1.put("date_of_birth", "1999-04-14");
        try {
            daoString = new ObjectMapper().writeValueAsString(params1);
        }catch (JsonProcessingException e){
        }

        doReturn(daoString).when(personDAO).readDataFile(anyString(), anyString());
        try {
            List<Person> persons = personService.prepareListPersons("", "");
            assertEquals(0, persons.size());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
    @Test
    public void checkPersonexcludedIncorrectDoB() {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("person_id", "49fdd3c7-971d-4599-9cd7-a6ccf5513995");
        params1.put("created_datetime", "2020-04-14 08:17:30.660950"); // Incorrect field name
        params1.put("date_of_birth", "14-04-1999");
        try {
            daoString = new ObjectMapper().writeValueAsString(params1);
        }catch (JsonProcessingException e){
        }

        doReturn(daoString).when(personDAO).readDataFile(anyString(), anyString());
        try {
            List<Person> persons = personService.prepareListPersons("", "");
            assertEquals(0, persons.size());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
