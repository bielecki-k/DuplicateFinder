import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static String pathToFile = "C:\\tmp\\input.txt";
    private static String directory = "C:\\tmp";
    static Utils utils = new Utils();

    public static void main(String[] args) throws IOException {


        System.out.println("File:" + pathToFile + " is readable: " + utils.checkIfFileIsReadable(pathToFile));

        File dir = new File(directory);
        String[] extensions = new String[] { "txt", "jsp" };
        System.out.println("Getting all files in " + dir.getCanonicalPath()
                + " including those in subdirectories");
        List<File> files = (List<File>) FileUtils.listFiles(dir, null, true);
        for (File file : files) {
            System.out.println("file: " + file.getCanonicalPath());
        }


        try {
            //Using BufferedReader
            readUsingTraditionalWay();
            //Using IOUtils
            readUsingIOUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //reading a file using buffered reader line by line
    public static void readUsingTraditionalWay() throws IOException {
        try(BufferedReader bufferReader = new BufferedReader( new InputStreamReader(
                new FileInputStream(pathToFile) ) )) {
            String line;
            while( ( line = bufferReader.readLine() ) != null ) {
                System.out.println( line );
            }
        }
    }
    //reading a file using IOUtils in one go
    public static void readUsingIOUtils() throws IOException {
        try(InputStream in = new FileInputStream(pathToFile)) {
            System.out.println( IOUtils.toString( in , "UTF-8") );
        }
    }


}
