package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Product prod1 = (Product) context.getBean("product1");
        System.out.println(prod1);
        Product prod2 = (Product) context.getBean("product2");
        System.out.println(prod2);
    }
}
