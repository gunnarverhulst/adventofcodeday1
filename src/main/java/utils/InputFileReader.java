package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public enum InputFileReader {
    INPUT_FILE_READER;

    public Stream<String> readInputFromStream(String filename) {
        try {
            final Path path = Paths.get(filename);
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read " + filename, e);
        }
    }

    public List<String> inputDataAsList(String filename) {

        return readInputFromStream(filename).toList();

    }
}

