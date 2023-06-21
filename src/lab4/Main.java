package lab4;

import java.io.File;

public class Main {
    private static final File PATH_DICT = new File("dictionary.txt");
    private static final File PATH_TEXT = new File("text.txt");

    public static void main(String[] args) {
        try {
            Dictionary myDictionary = new Dictionary(PATH_DICT);
            Translator myTranslator = new Translator(myDictionary, PATH_TEXT);
            for (var el: myTranslator.getTranslatedText()) {
                System.out.println(el);
            }
        } catch (InvalidFileFormatException | FileReadException | InvalidDataException e) {
            System.err.println(e.getMessage());
        }
    }
}
