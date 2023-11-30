package org.example.Domain;

import org.example.DAO.ManufacturerDAO;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App main = new App();
        main.createManufacturer();
    }

    private void createManufacturer(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên xưởng sản xuất: ");
            String name = sc.nextLine();
            System.out.println("Nhập địa điểm xưởng sản xuất: ");
            String location = sc.nextLine();
            System.out.println("Nhập số lượng nhân viên: ");
            int numberEmployee = sc.nextInt();

            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);
            manufacturer.setLocation(location);
            manufacturer.setEmployee(numberEmployee);

            ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
            manufacturerDAO.add(manufacturer);
            System.out.println("Create manufacturer successfully");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
