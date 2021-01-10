package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Model;

public class Users
{
    private String name, phone, password, image, address;

    public Users()
    {

    }

    public Users(String name, String phone, String password, String image, String address) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.image = image;
        this.address = address;
    }
}
