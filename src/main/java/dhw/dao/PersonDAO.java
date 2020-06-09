package dhw.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonDAO {
    public static String readDataFile(String datafileLocation, String charEncoding) throws Exception {
        try {
            byte[] jk = Files.readAllBytes(Paths.get(datafileLocation));
            return new String(jk, 0, jk.length, charEncoding);
        }catch (IOException e) {
            System.err.println("Error occurred reading file at " + datafileLocation);
            e.printStackTrace();
            throw new Exception("Unable to read file");
        }catch (OutOfMemoryError e){
            System.err.println("Datafile at " + datafileLocation + " is too large to read");
            e.printStackTrace();
            throw new Exception("Datafile is too large to read");
        }catch (SecurityException e){
            System.err.println("Security exception when reading datafile at " + datafileLocation);
            throw new Exception("Security exception when reading datafile");
        }
    }
}
