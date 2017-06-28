package com.example.kubra.tarifdefterim;
public class TarifModel {
    private String isim,detay,malzemeler;
    public TarifModel(String isim, String detay, String malzemeler) {
        this.isim = isim;
        this.detay = detay;
        this.malzemeler = malzemeler;
    }
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getMalzemeler() {
        return malzemeler;
    }
    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }
}
