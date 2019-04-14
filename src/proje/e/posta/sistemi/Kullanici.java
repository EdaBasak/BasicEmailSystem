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
public class Kullanici {

    String kullaniciAdi;
    String kullaniciSoyadi;
    String kullaniciAdresi;
    String kullaniciSifresi;
    String gonderenKullanici;
    String gonderenAdresi;
    ArrayList<Mail> gelenMail = new ArrayList();
    ArrayList<Mail> gidenMail = new ArrayList();
    static ArrayList<Mail> spamMail = new ArrayList();
    static ArrayList<Mail> copKutusu = new ArrayList();
    ArrayList<String> kullaniciAdresleri = new ArrayList();
    static Kullanici[] kullanicilar = new Kullanici[1000000];

    void kullaniciEkle(Kullanici k) {
        mailTurBelirle();
        if (mailTurBelirle() == true) {
            for (int i = 0; i < kullanicilar.length; i++) {
                if (Kullanici.kullanicilar[i] != null) {
                    Kullanici.kullanicilar[i] = k;

                } else {
                    System.out.println("Hata ! Kullanıcı eklenemedi.");
                    break;
                }
            }
        }

    }

    boolean mailTurBelirle() {
        if (kullaniciAdresi.endsWith("@gmail.com")) {
            System.out.println("Hoşgeldiniz,  "+kullaniciAdi+ "   Gmail adresiniz ile giriş talebinde bulundunuz.");
        } else if (kullaniciAdresi.endsWith("@hotmail.com")) {
            System.out.println("Hoşgeldiniz  "+kullaniciAdi+"    Hotmail adresiniz ile giriş talebinde bulundunuz.");
        } else if (kullaniciAdresi.endsWith("@stu.fsm.edu.tr")) {
            System.out.println("Hoşgeldiniz"+kullaniciAdi+"Fsmvü öğrenci adresiniz ile giriş talebinde bulundunuz.");
        } else {
            System.out.println("Hata ! Böyle bir mail adresi bulunmamaktadır...");
        }
        return true;

    }

    void mailAl(Mail m) {

        gelenMail.add(m);
    }

    void mailGönder(Kullanici gonderilenKullanici, Mail m) {

        gonderilenKullanici.mailAl(m);
        this.gidenMail.add(m);
    }

    void mailSil(int MailId) {

        for (int i = 0; i < gelenMail.size(); i++) {

            if (this.gelenMail.get(i).getId() == MailId) {
                   copKutusu.add(gelenMail.get(i));
                this.gelenMail.remove(i);
            
            } else {
                System.out.println("Mesajınız silinememiştir.Lütfen tekrar deneyiniz.");
            }
            break;

        }
        for (int i = 0; i < gidenMail.size(); i++) {

            if (this.gidenMail.get(i).getId() == MailId) {
                     copKutusu.add(gidenMail.get(i));
                this.gidenMail.remove(i);
           
            } else {
                System.out.println("Mesajınız silinememiştir.Lütfen tekrar deneyiniz.");
            }

        }
    }

    void mailSil(int id, boolean tamamen) {
        Mail bulunan = null;
        for (int i = 0; i < this.gelenMail.size(); i++) {
            if (this.gelenMail.get(i).getId() == id) {
                bulunan = this.gelenMail.get(i);
                this.gelenMail.remove(i);
                break;
            }
        }

        for (int i = 0; i < this.gidenMail.size(); i++) {
            if (this.gidenMail.get(i).getId() == id) {
                bulunan = this.gidenMail.get(i);
                this.gidenMail.remove(i);
                break;
            }
        }

        if (!tamamen) {
            if (bulunan != null) {
                this.copKutusu.add(bulunan);
            }
        }
    }

    public void mailSayısıBoyutuAsarsaHepsiniSil() {//normalde 5 sayısı 500 olmalıydı.testi kontrol etmek için 5 yazdım.

        if (gelenMail.size() >= 5) {
            System.out.println("UYARI ! Gelen mail sayısı 5'i geçtiği için tüm gelen mailleriniz silinmiştir.");
            gelenMail.clear();
            
        }

        if (gidenMail.size() >= 5) {
            
            System.out.println("UYARI ! Gelen mail sayısı 5'i geçtiği için tüm giden mailleriniz silinmiştir.");
            gidenMail.clear();
        }
    }

    public void copKutusuBoyutuAsarsaHepsiniSil() {
        if (copKutusu.size() >= 1000) {
            copKutusu.clear();
            System.out.println("UYARI ! Çöp kutunuzun mail sayısı 1000'i geçtiği için tüm çöp kutusu mailleriniz silinmiştir.");
        }
    }

    public void copKutusuGoster() {
        for (Mail mail : copKutusu) {
            System.out.println(mail.getId());
            System.out.println(copKutusu.size());

        }
    }

    boolean kullanıcıAdresiEkle(String kullaniciAdresi) {
        for (int i = 0; i < kullaniciAdresleri.size(); i++) {
            if (kullaniciAdresleri.get(i) == null) {
                kullaniciAdresleri.set(i, kullaniciAdresi);
                System.out.println("Kullanıcı adresiniz başarılı bir şekilde eklenmiştir.");
                return true;
            }
        }
        System.out.println("Hata: Kullanıcı adresi eklenememiştir.");
        return false;

    }

    static void spamMesajıEkle(Mail m) {
        spamMail.add(m);
    }

    void mailKonuBaslıgıKontrol(Mail konuBaslıgı, Mail m) {
        if (konuBaslıgı.equals(null)) {
            System.out.println("Hata: Konu başlığı olmayan bir maili gönderemezsiniz.");
            spamMail.add(m);
        } else {

            System.out.println("Konu başlığı eklenmiştir.");

        }

    }

    void gidenMail(Mail Id) {
        gidenMail.add(Id);
    }

    public void gelenKutusuGoster() {
        System.out.println(this.kullaniciAdi + " gelen kutusu");
        for (Mail mail : gelenMail) {
            System.out.println(mail.getId());
            System.out.println(mail.getBaslik());
            System.out.println("******************************");
        }
    }

    public void gidenKutusuGoster() {
        for (Mail mail : gidenMail) {
            mail.Goster();
        }
        System.out.println("******************************");

    }
    public void Goster(){
        System.out.println(this.kullaniciAdi+ "  "+ this.kullaniciSoyadi);
    }

}
