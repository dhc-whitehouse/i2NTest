package dhw.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonDAO {/**
 *
 * @param datafileLocation  Location of file of person data
 * @param charEncoding      Character coding used by person data
 * @return String           All data read from datafileLocation and converted
 *                          from charEncoding CharacterSet to IDE CharacterSet
 * @throws Exception        In case of error when reading file
 */
 //   public static String readDataFile(String datafileLocation, String charEncoding) {
    public String readDataFile(String datafileLocation, String charEncoding) {
        try {
            byte[] jk = Files.readAllBytes(Paths.get(datafileLocation));
            return new String(jk, 0, jk.length, charEncoding);
        }catch (IOException e) {
            System.err.println("Error occurred reading file at " + datafileLocation);
            e.printStackTrace();
            return null;
        }catch (OutOfMemoryError e){
            System.err.println("Datafile at " + datafileLocation + " is too large to read");
            e.printStackTrace();
            return null;
        }catch (SecurityException e){
            System.err.println("Security exception when reading datafile at " + datafileLocation);
            return null;
        }
    }
}
