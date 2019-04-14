/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.e.posta.sistemi;

/**
 *
 * @author Başak
 */
public class Test {

    public static void main(String[] args) {
        Kullanici k1 = new Kullanici();
        k1.kullaniciAdi = "Kıymet";
        k1.kullaniciSoyadi = "Erdemir";
        k1.kullaniciSifresi = "1234";
        k1.kullaniciAdresi="kiymeterdemir@gmail.com";
        k1.kullanıcıAdresiEkle("kiymeterdemiiir@otmail.com");
        

        Kullanici k2 = new Kullanici();
        k2.kullaniciAdi = "Sena";
        k2.kullaniciSoyadi = "Kavuncu";
        k2.kullaniciSifresi = "11111";
        k2.kullaniciAdresi="senakavuncu@hotmail.com";
        
        Kullanici k3=new Kullanici();
        k3.kullaniciAdi="Ahmet";
        k3.kullaniciSoyadi="Ak";
        k3.kullaniciSifresi="7896";
        k3.kullaniciAdresi="ahmetak@stu.fsm.edu.tr";
        
        Kullanici k4=new Kullanici();
        k4.kullaniciAdi="Gökhan";
        k4.kullaniciSoyadi="Töre";
        k4.kullaniciSifresi="1903";
        k4.kullaniciAdresi="nisanhilal3@xmail.com";
        
        Kullanici k5=new Kullanici();
        k5.kullaniciAdi="Cenk";
        k5.kullaniciSoyadi="Tosun";
        k5.kullaniciSifresi="bjk3";
        k5.kullaniciAdresi="cenktosun@stu.fsm.edu.tr";
        
        Kullanici k6=new Kullanici();
        k6.kullaniciAdi="Mustafa";
        k6.kullaniciSoyadi="Pektemet";
        k6.kullaniciSifresi="basak";
        k6.kullaniciAdresi="mustafa.pektemet@stu.fsm.edu.tr";
        
        Kullanici k7=new Kullanici();
        k7.kullaniciAdi="Emre";
        k7.kullaniciSoyadi="Mor";
        k7.kullaniciSifresi="mor";
        k7.kullaniciAdresi="emre.mor@hotmail.com";
       
        k2.mailTurBelirle();        
        Mail m1=new Mail("Sınav","sınav tarihleri",k1,k2,"27.12.2017");
        Mail m2=new Mail("Okul","Okul bilgisi",k1,k2,"28.12.2017");
        Mail m3= new Mail("Futbol","Halısaha davet",k3,k4,"03.11.2017");
        Mail m4=new Mail("Yemeksepeti","yemeksipariş",k3,k4,"02.11.2017");
        Mail m5=new Mail("Cinemaximum","Biletalma",k3,k4,"09.11.2017");
        Mail m6=new Mail("Alısveris siparis","Bershka",k4,k5,"01.12.2017");
        Mail m7=new Mail("Oyun sipariş","iade",k5,k6,"01.03.2017");
        Mail m8=new Mail("Trendyol","Sipariş",k5,k6,"01.03.2018");
        Mail m9=new Mail("Ios","sistem uyarısı",k5,k6,"01.03.2003");
        Mail m10=new Mail("Fsmvü","puansonucu",k6,k7,"01.01.2011");
        
       //TEST:1
        k1.mailGönder(k2, m1);
        k1.mailGönder(k2, m2);
        k2.gelenKutusuGoster();
        k2.mailSil(2);
        k2.gelenKutusuGoster();
        k1.mailTurBelirle();
        k1.gidenKutusuGoster();
        System.out.println("Toplam giden mailiniz: "+ k1.gidenMail.size());
        
       //TEST2
        k3.mailGönder(k4, m1);
        k3.mailGönder(k4, m2);
        k3.mailGönder(k4, m3);
        k3.mailGönder(k4, m4);
        k3.mailGönder(k4, m5);
        k4.mailTurBelirle();
        k4.gelenKutusuGoster();
        System.out.println("Toplam gelen mailiniz:  "+ k4.gelenMail.size());
        k3.mailSil(5, true);
        k3.mailSil(4, true);
        k3.mailSil(3, true);
        k3.gelenKutusuGoster();
        System.out.println("Toplam gelen mailiniz:  "+ k3.gelenMail.size());
        k4.gidenKutusuGoster();
        System.out.println("Toplam giden mailiniz:  "+ k4.gidenMail.size());
        
        //TEST:3
        k5.mailGönder(k6, m1);
        k5.mailGönder(k6, m2);
        k5.mailGönder(k6, m3);
        k5.mailGönder(k6,m4);
        k5.mailGönder(k6,m5);
        k5.mailGönder(k6, m6);
        k5.gelenKutusuGoster();
        k5.mailSayısıBoyutuAsarsaHepsiniSil();
        k5.gelenKutusuGoster();
        System.out.println("Gelen kutusundaki mesaj sayınız:  " +k5.gelenMail.size());
        
        //TEST:4
        k6.gidenKutusuGoster();
        k6.mailSayısıBoyutuAsarsaHepsiniSil();
        k6.gidenKutusuGoster();
        System.out.println("Giden kutusundaki mesaj sayısı:  "+ k6.gidenMail.size());
        
        EklentiMail em1=new EklentiMail("resimler", "doğum günü resimlerin ektedir", k6, k7, "01.04.2018");
        em1.eklentiEkle("resim1", 15);
        em1.eklentiEkle("resim2", 6);
        k6.mailGönder(k7, em1);
        k6.gidenKutusuGoster();
        
       
        İletiMail im1=new İletiMail(k7, "baslık", "metin", k6, k7, "01.01.2018");
        im1.ilkGondereniBulma();
        im1.Goster();
       
        
        

    }
}
