package dhw.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dhw.dao.PersonDAO;
import dhw.models.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

   // @Mock
  //  private PersonDAO personDAO;

    //Define some static test values
    private String DAO_STRING;
    /**
     * Setup the common data for the tests to follow.
     */
    @Before
    public void setUp() {
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
            DAO_STRING = new ObjectMapper().writeValueAsString(params);
        }catch (JsonProcessingException e){
        }
    }
    @Test
    public void checkPrepareListPersons() {
     //   when(personDAO.readDataFile(anyString(), anyString())).thenReturn(DAO_STRING);
//        PersonDAO mockDAO = Mockito.mock(PersonDAO.class);
//        PersonService ps = mock(PersonService.class);
//        doReturn(DAO_STRING).when(mockDAO).readDataFile(anyString(), anyString());
//        try {
//            List<Person> persons = personService.prepareListPersons("", "");
//            assertEquals(1, persons.size());
//            assertEquals("49fdd3c7-971d-4599-9cd7-a6ccf5513995",persons.get(1).getPerson_id());
//        }catch (Exception e){
//    e.printStackTrace();
//        }
        }
}
