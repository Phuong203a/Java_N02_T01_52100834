package org.example;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component("PlainTextWriter")
public class PlainTextWriter implements TextWriter{
    public void write(String content, String fileName) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
        printWriter.println(content);
        printWriter.close();
    }
}
