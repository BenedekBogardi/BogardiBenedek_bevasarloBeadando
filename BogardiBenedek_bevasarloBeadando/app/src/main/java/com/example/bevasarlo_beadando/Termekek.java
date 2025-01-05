package com.example.bevasarlo_beadando;

public class Termekek {
    private String nev;
    private Integer egysegAr;
    private Double mennyiseg;
    private String mertekEgyseg;
    private Double bruttoAr;

    public Termekek(String nev, Integer egysegAr, Double mennyiseg, String mertekEgyseg) {
        this.nev = nev;
        this.egysegAr = egysegAr;
        this.mennyiseg = mennyiseg;
        this.mertekEgyseg = mertekEgyseg;
    }

    public String getNev() {
        return nev;
    }

    public Integer getEgysegAr() {
        return egysegAr;
    }

    public Double getMennyiseg() {
        return mennyiseg;
    }

    public Double getBruttoAr() {
        bruttoAr= (double) (Math.round(egysegAr*mennyiseg*100)/100);
        return bruttoAr;
    }

}
