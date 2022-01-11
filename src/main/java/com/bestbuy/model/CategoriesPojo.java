package com.bestbuy.model;

public class CategoriesPojo {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static CategoriesPojo getCategoriesPojo(String name,String id){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);
        return categoriesPojo;
    }

    }
