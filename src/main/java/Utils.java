import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public boolean checkIfFileIsReadable(String pathToFile){

        Path path = Paths.get(pathToFile);
        File file = path.toFile();

        return file.canRead();
    }

}
