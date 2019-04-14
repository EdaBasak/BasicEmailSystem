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
public class EklentiMail extends Mail {

    public EklentiMail(String baslik, String metin, Kullanici gonderen, Kullanici alan, String gonderimTarihi) {
        super();
        this.setBaslik(baslik);
        this.metin = metin;
        this.gonderenKullanıcı = gonderen;
        this.alanKullanıcı = alan;
        this.gondermeTarih = gonderimTarihi;

    }

    protected String metin;
    private int boyut;  //Girilen boyutun birimini mb olarak kabul ettim.
    String eklentiTur;
    ArrayList<String> eklenti = new ArrayList();// herhangi bi zip dosyası veya fotograf olabilir

    void eklentiEkle(String eklentiTur, int boyut) {
        if (this.boyut + boyut < 25) {
            eklenti.add(eklentiTur);
            this.boyut += boyut;
        } else {
            System.out.println("UYARI ! Girdiğiniz boyut geçerli değildir.Kontrol edip tekrar deneyiniz.");
        }

    }

    public void Goster() {
          System.out.println("**************");
        System.out.println(this.getId());
        System.out.println(this.getBaslik());
        System.out.println(this.metin);
        for (String ek : eklenti) {
            System.out.println("ek :"+ek);
        }
          System.out.println("**************");

    }

}
