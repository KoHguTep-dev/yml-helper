package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class YmlReader {

    public byte[] readDatasetConfig(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file on path: " + path, e);
        }
    }
}
