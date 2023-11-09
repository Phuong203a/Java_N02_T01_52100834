package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {
    @Bean(name = "PlainTextWriter")
    @Scope("singleton")
    public PlainTextWriter plainTextWriter(){
        return new PlainTextWriter();
    }

    @Bean(name = "PdfTextWriter")
    @Scope("singleton")
    public PdfTextWriter pdfTextWriter(){
        return new PdfTextWriter();
    }

    @Bean(name = "TextEditor")
    @Scope("singleton")
    public TextEditor textEditor(){
        return new TextEditor();
    }
}
