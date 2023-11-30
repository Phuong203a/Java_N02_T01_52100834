package org.example.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mobile_phone")
public class MobilePhone {

    @Id
    @GeneratedValue()
    public Long id;
    @Column
    public String name;
    @Column
    public int price;
    @Column
    public String color;
    @Column
    public String country;
    @Column
    public int quantity;

    @Override
    public String toString() {
        return "Phone{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Color='" + color + '\'' +
                ", Country='" + country + '\'' +
                ", Quantity=" + quantity +
                '}';
    }

}
