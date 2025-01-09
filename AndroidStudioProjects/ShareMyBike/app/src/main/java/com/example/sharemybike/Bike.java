package com.example.sharemybike;

public class Bike
{
    private int img;
    private String CiudadBici;
    private String dueñoBici;
    private String lugarBici;
    private String DescripcionBici;

    public Bike() {
    }

    public Bike(int img, String ciudadBici, String lugarBici,  String dueñoBici, String descripcionBici) {
        this.img = img;
        CiudadBici = ciudadBici;
        this.lugarBici = lugarBici;
        this.dueñoBici = dueñoBici;
        DescripcionBici = descripcionBici;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCiudadBici() {
        return CiudadBici;
    }

    public void setCiudadBici(String ciudadBici) {
        CiudadBici = ciudadBici;
    }

    public String getDueñoBici() {
        return dueñoBici;
    }

    public void setDueñoBici(String dueñoBici) {
        this.dueñoBici = dueñoBici;
    }

    public String getLugarBici() {
        return lugarBici;
    }

    public void setLugarBici(String lugarBici) {
        this.lugarBici = lugarBici;
    }

    public String getDescripcionBici() {
        return DescripcionBici;
    }

    public void setDescripcionBici(String descripcionBici) {
        DescripcionBici = descripcionBici;
    }
}
