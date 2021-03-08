


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author risin
 */
public class Musteri {
    private String musteriAdi;
    private String musteriSoyadi;
    private String MusteriNo;
    private String musteriTcKimlik;
    private String biletTur;
    private String musteriBlok;
    private int musteriKoltukNo;

    Scanner input=new Scanner(System.in);
    
    public Musteri(String musteriBlok){
        System.out.println("Musteri adini giriniz");
        this.musteriAdi=input.nextLine();
        System.out.println("Musteri soyadini giriniz");
        this.musteriSoyadi=input.nextLine();
        System.out.println("Musteri telefon numarasini giriniz");
        this.MusteriNo=input.nextLine();
        System.out.println("Musteri Tc giriniz");
        this.musteriTcKimlik=input.nextLine();
        this.musteriBlok=musteriBlok;
        this.musteriKoltukNo=musteriKoltukNo;
       
    }

    public Musteri(String musteriAdi, String musteriSoyadi, String MusteriNo, String musteriTcKimlik, String biletTur, String musteriBlok, int musteriKoltukNo) {
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.MusteriNo = MusteriNo;
        this.musteriTcKimlik = musteriTcKimlik;
        this.biletTur = biletTur;
        this.musteriBlok = musteriBlok;
        this.musteriKoltukNo = musteriKoltukNo;
    }
    
    public int hesapla(int biletSayisi){
        return biletSayisi*10;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public String getMusteriNo() {
        return MusteriNo;
    }

    public void setMusteriNo(String MusteriNo) {
        this.MusteriNo = MusteriNo;
    }

    public String getMusteriTcKimlik() {
        return musteriTcKimlik;
    }

    public void setMusteriTcKimlik(String musteriTcKimlik) {
        this.musteriTcKimlik = musteriTcKimlik;
    }

    public String getMusteriBlok() {
        return musteriBlok;
    }

    public void setMusteriBlok(String musteriBlok) {
        this.musteriBlok = musteriBlok;
    }

    public String getBiletTur() {
        return biletTur;
    }

    public void setBiletTur(String biletTur) {
        this.biletTur = biletTur;
    }

    public int getMusteriKoltukNo() {
        return musteriKoltukNo;
    }

    public void setMusteriKoltukNo(int musteriKoltukNo) {
        this.musteriKoltukNo = musteriKoltukNo;
    }
    
    
    
    
    
}

