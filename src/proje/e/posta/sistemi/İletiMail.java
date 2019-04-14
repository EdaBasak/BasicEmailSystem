/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.e.posta.sistemi;

import java.util.ArrayList;

/**
 *
 * @author Başak
 */
public class İletiMail extends Mail {

    İletiMail() {
        super();
    }
    static ArrayList<Kullanici> ilkGonderenListesi = new ArrayList();//mesajın ilk gelen kullanıcısını bulma?
    Kullanici ilkGonderen;


    public İletiMail(Kullanici ilkGonderen, String baslik, String metin, Kullanici gonderen, Kullanici alan, String gonderimTarihi) {
        super(baslik, metin, gonderen, alan, gonderimTarihi);
        this.ilkGonderen = ilkGonderen;
        ilkGonderenListesi.add(ilkGonderen);
    }
    
    void ilkGondereniBulma() {
                System.out.println("Bu mesaj  " + this.gonderenKullanıcı.kullaniciAdi+ "  tarafından ilk  gönderilmiştir.");
                ilkGonderen.Goster();
       
}
}