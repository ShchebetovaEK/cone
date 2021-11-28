package by.tms.figure.reader;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ConeReader {

    public static final Logger logger = LogManager.getLogger();

    public Optional<List<String>> getLines(String filename) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            logger.info("Success, we are read filename {}" , filename);
            return Optional.of(reader.lines().collect(Collectors.toList()));
        } catch (IOException e) {
            logger.error("can't read a filename " + filename, e);
            return Optional.empty();
        }
    }

}