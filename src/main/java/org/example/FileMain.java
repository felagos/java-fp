package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var resourceName = "file.txt";
        var url = FileMain.class.getResource(resourceName);
        var path = Paths.get(url.toURI());

        try(var lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
    }
}
