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
public class Mail {

    String gondermeTarih;
    static int mailId;
    private int id;
    Kullanici gonderenKullanıcı;
    Kullanici alanKullanıcı;
    private String baslik;
    String metin;
  

    public Mail() {
        Mail.mailId++;
        this.id = Mail.mailId;

    }

    public Mail(String baslik, String metin, Kullanici gonderen, Kullanici alan, String gonderimTarihi) {
        Mail.mailId++;
        this.id = Mail.mailId;
        this.baslik = baslik;
        this.metin = metin;
        this.gonderenKullanıcı = gonderen;
        this.alanKullanıcı = alan;
        this.gondermeTarih = gonderimTarihi;
          
    }

    public int getId() {
        return id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
    public void Goster()
    {
        System.out.println("**************");
          System.out.println(this.getId());
            System.out.println(this.getBaslik());
                  System.out.println(this.metin);
                  
                   System.out.println("**************");
    
    }

}
