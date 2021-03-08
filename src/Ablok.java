

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author risin
 */
public class Ablok extends Musteri{
    public Ablok(){
         super("A");
    }
    @Override
     public int hesapla(int biletSayisi){
        return biletSayisi*20;
    }
    
}
