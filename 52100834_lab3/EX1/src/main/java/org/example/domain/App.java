package org.example.domain;

import org.example.DAO.ManufacturerDAO;
import org.example.DAO.MobilePhoneDAO;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        App app = new App();

        int chose;
        do {
            System.out.println("Chose 1: createManufacturer or 2: createPhone or 3: printAllManufacture or 4: printAllPhone or 5: removeManufacturer or 6: removePhone or 7: updateManufacture or 8: updatePhone or 9 getMaxPricePhone or 10 getSortsPhonee or 11 getPriceSamee or 12 getColorPink or 13 getEmployee or 14 getEmployeeSum or 15 Fluttertoast 0: close");

            Scanner sc = new Scanner(System.in);
            chose = sc.nextInt();
            if (chose == 1) {
                app.createManufacturer();

            } else if (chose == 2) {
                app.createPhone();

            } else if (chose == 3) {
                app.printAllManufacture();

            } else if (chose == 4) {
                app.printAllPhone();

            } else if (chose == 5) {
                app.removeManufacturer();

            } else if (chose == 6) {
                app.removePhone();

            } else if (chose == 7) {
                app.updateManufacture();

            } else if (chose == 8) {
                app.updatePhone();

            }
            else if (chose == 9) {
                app.getMaxPricePhone();
            }
            else if (chose == 10) {
                app.getSortsPhonee();
            }
            else if (chose == 11) {
                app.getPriceSamee();
            }

            else if (chose == 12) {
                app.getColorPink();
            }
            else if (chose == 13) {
                app.getEmployee();
            }
            else if (chose == 14) {
                app.getEmployeeSum();
            }
            else if (chose == 15) {
                app.getLast();
            }
            else if (chose == 0) {
                System.exit(0);
            } else {
                System.out.println("ERROR");
            }
        } while (chose < 15 && chose > 0);
    }

    private void createManufacturer() {
        try {
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
            if (manufacturerDAO.add(manufacturer)) {
                System.out.println("Create manufacturer successfully");
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void createPhone() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên phone ");
            String name = sc.nextLine();
            System.out.println("Nhập color ");
            String color = sc.nextLine();
            System.out.println("Nhập price ");
            int price = sc.nextInt();
            System.out.println("Nhập quantity ");
            int quantity = sc.nextInt();
            System.out.println("Nhập country ");
            sc.nextLine();
            String country = sc.nextLine();
            System.out.println("Nhập manufacturer_id ");
            Long manufacturerId = sc.nextLong();

            MobilePhone mobilePhone = new MobilePhone();
            mobilePhone.setName(name);
            mobilePhone.setColor(color);
            mobilePhone.setPrice(price);
            mobilePhone.setQuantity(quantity);
            mobilePhone.setCountry(country);
            mobilePhone.setManufacturerId(manufacturerId);

            MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
            if (mobilePhoneDAO.add(mobilePhone)) {
                System.out.println("Create mobilePhone successfully");
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void printAllManufacture() {
        try {

            ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
            manufacturerDAO.getAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printAllPhone() {
        try {

            MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
            mobilePhoneDAO.getAllPhone();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeManufacturer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id manufacturer cần delete: ");
        Long id = sc.nextLong();
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);

        manufacturerDAO.remove(manufacturer);
    }

    private void removePhone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id manufacturer cần delete: ");
        Long id = sc.nextLong();
        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();

        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setId(id);

        mobilePhoneDAO.remove(mobilePhone);
    }

    private void updateManufacture() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id manufacturer cần updateManufacture: ");
        Long id = sc.nextLong();
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

        manufacturer.setId(id);

        manufacturerDAO.update(manufacturer);

    }

    private void updatePhone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id phone cần updatePhone: ");
        Long id = sc.nextLong();

        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();

        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập tên phone ");
        String name = scan.nextLine();
        System.out.println("Nhập color ");
        String color = scan.nextLine();
        System.out.println("Nhập price ");
        int price = scan.nextInt();
        System.out.println("Nhập quantity ");
        int quantity = scan.nextInt();
        System.out.println("Nhập country ");
        scan.nextLine();
        String country = scan.nextLine();
        System.out.println("Nhập manufacturer_id ");
        Long manufacturerId = scan.nextLong();

        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setName(name);
        mobilePhone.setColor(color);
        mobilePhone.setPrice(price);
        mobilePhone.setQuantity(quantity);
        mobilePhone.setCountry(country);
        mobilePhone.setManufacturerId(manufacturerId);
        mobilePhone.setId(id);
        mobilePhoneDAO.update(mobilePhone);

    }

    private void getMaxPricePhone() {
        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
        mobilePhoneDAO.getHighestPrice();
    }
    private void getSortsPhonee() {
        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
        mobilePhoneDAO.getSortPhone();
    }
    private void getPriceSamee() {
        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
        mobilePhoneDAO.getPriceSame();
    }
    private void getColorPink() {
        MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAO();
        mobilePhoneDAO.getColorPink();
    }
    private void getEmployee() {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturerDAO.getEmploye();
    }
    private void getEmployeeSum() {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturerDAO.getEmployeeSum();
    }
    private void getLast() {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturerDAO.getManufactureLast();
    }
}
