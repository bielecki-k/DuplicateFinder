import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class Main {

    private static final String pathToFile = "C:\\tmp\\input.txt";
//    private static final String directory = "C:\\tmp";
    static CommonFileUtils utils = new CommonFileUtils();

    public static void main(String[] args) throws IOException, URISyntaxException {


//        System.out.println("File:" + pathToFile + " is readable: " + utils.checkIfFileIsReadable(pathToFile));
//
//        utils.printFilesInDirectory(directory);

        String directory2 = "C:/tmp";
        utils.readAttributes(directory2);





        try {
            readUsingTraditionalWay();
            readUsingIOUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readUsingTraditionalWay() throws IOException {
        try(BufferedReader bufferReader = new BufferedReader( new InputStreamReader(
                new FileInputStream(pathToFile) ) )) {
            String line;
            while( ( line = bufferReader.readLine() ) != null ) {
                System.out.println( line );
            }
        }
    }

    public static void readUsingIOUtils() throws IOException {
        try(InputStream in = new FileInputStream(pathToFile)) {
            System.out.println( IOUtils.toString( in , StandardCharsets.UTF_8) );
        }
    }


}
