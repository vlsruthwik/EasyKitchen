package com.example.easykitchen;

public class item {

    String dish_name,cost,quant;
    int  imgID;

    public item(String dish_name,String cost, String quant,int imgID){
        this.dish_name = dish_name;
        this.cost = cost;
        this.quant = quant;
        this.imgID = imgID;
    }

    public String getDish_name(){return dish_name;}

    public void setDish_name(String t_dish){this.dish_name = t_dish;}

    public int getImgID(){return imgID;}

    public void setImgID(int t_imgID){this.imgID = t_imgID;}

    public String getCost(){return cost;}

    public void setCost(String t_cost){this.cost = t_cost;}

    public String getQuant(){return quant;}

    public void setQuant(String t_quant){this.quant = t_quant;}
}
