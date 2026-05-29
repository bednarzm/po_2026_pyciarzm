import java.io.File;
import java.util.Arrays;

public class Skaner {
    public static void scanDirectory(String relativePath) {
        File dir = new File(relativePath);

        System.out.println("Zawartość katalogu:");
        File[] filesList = dir.listFiles();

        if (filesList != null) {
            Arrays.stream(filesList)
                    .filter(File::isFile)
                    .forEach(file -> {
                        String name = file.getName();
                        int dotIndex = name.lastIndexOf('.');
                        if (dotIndex > 0) {
                            System.out.println("Plik: " + name.substring(0, dotIndex));
                        } else {
                            System.out.println("Plik: " + name);
                        }
                    });

            Arrays.stream(filesList)
                    .filter(File::isDirectory)
                    .forEach(file -> System.out.println("Katalog " + file.getName()));
        }

        System.out.println("\nŚcieżka bezwzględna: ");
        System.out.println(dir.getAbsolutePath());
    }
}
