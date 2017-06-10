package com.vbokhan.library.reader;

import com.vbokhan.library.exception.NoFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public Optional<List<String>> readDataFromFile(String fileName) throws NoFileException {
        if (fileName == null || fileName.isEmpty()) {
            throw new NoFileException(String.format("File %s not found", fileName));
        }
        Optional<List<String>> dataFromFile = null;
        try {
            dataFromFile = Optional.ofNullable(Files.lines(new File(fileName).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error with file. " + e.getMessage());
        }
        return dataFromFile;
    }
}
