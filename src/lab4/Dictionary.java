package lab4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    private static final String FILE_FORMAT_EXCEPTION = "Invalid amount of args";
    private static final String FILE_READ_EXCEPTION = "Can't read data from file";

    private final Map<String, String> dictionary = new HashMap<>();

    public Dictionary(final File path) throws InvalidFileFormatException, FileReadException {
        fillDataToDictionary(path);
    }

    public void setDictionary(final File path) throws InvalidFileFormatException, FileReadException {
        fillDataToDictionary(path);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    private void fillDataToDictionary(final File path) throws InvalidFileFormatException, FileReadException {
        try (FileReader reader = new FileReader(path)) {
            try (Scanner in = new Scanner(reader)) {
                while (in.hasNextLine()) {
                    String[] words = in.nextLine().split("\\|");
                    if (words.length != 2) {
                        throw new InvalidFileFormatException(FILE_FORMAT_EXCEPTION);
                    }
                    dictionary.put(words[0].toLowerCase(Locale.ROOT), words[1].toLowerCase(Locale.ROOT));
                }
            }
        } catch (IOException e) {
            throw new FileReadException(FILE_READ_EXCEPTION);
        }
    }
}
