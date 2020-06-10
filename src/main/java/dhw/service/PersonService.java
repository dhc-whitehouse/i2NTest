package dhw.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dhw.dao.PersonDAO;
import dhw.models.Person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonService {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final LocalDate CUTOFF_DATE = LocalDate.parse("1999-12-31", DTF);
    private LocalDate dob = null;
    PersonDAO personDAO = new PersonDAO();
    /**
     *
     * @param datafileLocation  Location of file of person data
     * @param charEncoding      Character coding used by person data
     * @return List<Person>     List of distinct persons filtered by birth date and sorted by firstName and LastName
     * @throws Exception
     */

    public List<Person> prepareListPersons(String datafileLocation, String charEncoding)throws Exception{

        // Obtain a string representation of the contents of person test data.json in character coding of project
        String data = personDAO.readDataFile(datafileLocation, charEncoding);
        if (data == null || data.trim().isEmpty()) {
            System.err.println("Empty file read at " + datafileLocation);
            throw new Exception("Unable to read file or no data read from file");
        }

        // Use Jackson object mapper to map a Json string into the Person object

        String [] personsStr = data.substring(data.indexOf("{"),data.length()-1).split("\\},");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // Obtain a List of person objects
        List<Person> persons = Arrays.stream(personsStr).
                map(str -> {
                    try{
                        Person ps =  objectMapper.readValue(str + "}", Person.class);
                        return ps;
                    }catch (Exception e){
                        Person personErr = new Person();
                        personErr.setPerson_id("Invalid person");
                        return personErr;
                    }
                })
                .collect(Collectors.toList());

        // Filter persons removing persons born after 31Dec99, sort by first name and last name, choose distinct
        // persons using hashCode and equals methods from Person class
        Function<Person, String> byFirstName = Person::getFirst_name;
        Function<Person, String> byLastName = Person::getLast_name;
        Comparator<Person> byFirstLastName = Comparator.comparing(byFirstName).thenComparing(byLastName);
        List<Person> personsFilterDistinctSorted = new ArrayList<>(personsStr.length - 1);
        return personsFilterDistinctSorted = persons.stream().filter(person -> {
                    if (person.getDate_of_birth() == null){
                        return false;
                    }
                    try {
                        dob = LocalDate.parse(person.getDate_of_birth(), DTF);
                    } catch (DateTimeParseException e) {
                        return false;
                    }
                    return (dob.isBefore(CUTOFF_DATE) || person.getPerson_id().equals("Invalid person"));
                })
                .sorted(byFirstLastName)
                .distinct()
                .collect(Collectors.toList());
    }


}
