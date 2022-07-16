package com.example.easykitchen;

public class item {

    String dish_name,status;
    int cost,quant;
    int  imgID;

    public item(String dish_name,int cost, int quant,String status){
        this.dish_name = dish_name;
        this.cost = cost;
        this.quant = quant;
        this.imgID = imgID;
        this.status = status;
    }

    public String getDish_name(){return dish_name;}

    public void setDish_name(String t_dish){this.dish_name = t_dish;}

    public int getImgID(){return imgID;}

    public void setImgID(int t_imgID){this.imgID = t_imgID;}

    public int getCost(){return cost;}

    public void setCost(int t_cost){this.cost = t_cost;}

    public int getQuant(){return quant;}

    public void setQuant(int t_quant){this.quant = t_quant;}

    public String getStatus(){return status;}

    public void setStatus(String t_status){this.status = t_status;}
}
