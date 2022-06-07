import org.apache.commons.vfs2.FileContent;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommonFileUtils {

    public boolean checkIfFileIsReadable(String pathToFile){

        Path path = Paths.get(pathToFile);
        File file = path.toFile();

        return file.canRead();
    }

    public void printFilesInDirectory(String directory) throws IOException {
        File dir = new File(directory);
        System.out.println("Getting all files in " + dir.getCanonicalPath()
                + " including those in subdirectories");
        List<File> files = (List<File>) org.apache.commons.io.FileUtils.listFiles(dir, null, true);
        for (File file : files) {
            System.out.println("file: " + file.getCanonicalPath());
        }
    }

    public void readAttributes(String directory) throws IOException, URISyntaxException {

        try (StandardFileSystemManager fsManager = new StandardFileSystemManager()) {
            final URI folderUri = new URI(directory);

            fsManager.init();

            try (final FileObject localFileObject = fsManager.resolveFile(folderUri)) {
                final FileObject[] children = localFileObject.getChildren();
                for (FileObject child : children) {
                    try (final FileContent content = child.getContent()) {
                        System.out.println("Modification [timestamp=" + content.getLastModifiedTime() + "] [file/dir=" + child.getName().getBaseName() + "]");
                    }
                }
            }
        }

    }




}
