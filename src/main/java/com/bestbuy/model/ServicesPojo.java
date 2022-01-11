package com.bestbuy.model;

public class ServicesPojo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ServicesPojo getServicePojo(String name){
      ServicesPojo servicesPojo = new ServicesPojo();
      servicesPojo.setName(name);
      return servicesPojo;
    }
}
