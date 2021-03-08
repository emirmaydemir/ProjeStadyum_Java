

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author risin
 */
public class Bblok extends Musteri{
      public Bblok(){
        super("B");
    }
    @Override
     public int hesapla(int biletSayisi){
        return biletSayisi*15;
    }
      
    
}
