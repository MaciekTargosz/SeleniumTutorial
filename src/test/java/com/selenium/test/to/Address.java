package com.selenium.test.to;

import lombok.Getter;

@lombok.Getter
public class Address {

    private String companyName;
    private String addressPart1;
    private String addressPart2;
    private String city;
    private String postCode;
    private String country;
    private String region;

    public Address withCompanyName(String companyName){
        this.companyName = companyName;
        return this;
    }

    public Address withAddressPart1(String addressPart1){
        this.addressPart1 = addressPart1;
        return this;
    }

    public Address withAddressPart2(String addressPart2){
        this.addressPart2 = addressPart2;
        return this;
    }

    public Address withCity(String city){
        this.city = city;
        return this;
    }

    public Address withPostCode(String postCode){
        this.postCode = postCode;
        return this;
    }

    public Address withCountry(String country){
        this.country = country;
        return this;
    }

    public Address withRegion(String region){
        this.region = region;
        return this;
    }
}
