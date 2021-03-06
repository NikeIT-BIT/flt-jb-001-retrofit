package com.ntarasov.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserResponse {
    @Getter
    @Setter
    @ToString
    public static class Address {
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;
    }
    @Getter
    @Setter
    @ToString
    public static class Company {
        public String name;
        public String catchPhrase;
        public String bs;
    }
    @Getter
    @Setter
    @ToString
    public static class Geo {
        public String lat;
        public String lng;
    }

    public Integer id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

}
