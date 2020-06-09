package dhw;

import dhw.models.Person;
import dhw.service.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * i2N Test
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PersonService personService = new PersonService();
        try {
            List<Person> persons = personService.prepareListPersons(args[0], args[1]);
            System.out.printf("%30s%30s%30s\n", "First_name", "Last_name", "Date_of_birth");
            persons.stream().forEach(person -> System.out.printf("%30s%30s%30s\n", person.getFirst_name(),
                    person.getLast_name(), person.getDate_of_birth()));
        }catch (Exception e){

        }
    }
}
