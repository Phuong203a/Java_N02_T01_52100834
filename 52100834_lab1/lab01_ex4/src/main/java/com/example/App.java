package com.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.File;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String inputUrl = args[0];
        UrlValidator validator = new UrlValidator();

        boolean isValid = validator.isValid(inputUrl);
        if (isValid) {
            System.out.println("Valid");
            try{
                URL url = new URL( inputUrl);
                String filename = FilenameUtils.getName(url.getPath());
                File destination = new File(filename);
                if(!destination .exists()){
                    destination.createNewFile();
                }
                FileUtils.copyURLToFile(url,destination);
                //build maven nhé
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else {
            System.out.println("InValid");

        }
    }
    //em copy y hệt đoạn code đó vào nhé
    
}
// artifact la s
//thôii kệ anh bảo
// bài 3 bài 4 làm chung được