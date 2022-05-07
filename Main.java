package AkilliCihazTasarim;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		try 
		{
			Connection baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz","postgres", "1234");
			String kullanici_adi;
			String sifre;
			Scanner giris = new Scanner(System.in);
			MerkeziBirim merkezi_birim = new MerkeziBirim();
			if(baglanti == null)
			{
				System.out.println("Ba�lanti Ba�arisiz...");
			}
			while(true)
			{
				System.out.println("Lutfen Kullanici Adinizi Giriniz: ");
				kullanici_adi = giris.nextLine();
				String sorgu = "SELECT *  FROM \"Kullanici\" WHERE kullanici_adi='" + kullanici_adi + "'";
				Statement stmt = baglanti.createStatement();
                ResultSet rs = stmt.executeQuery(sorgu);
                baglanti.close();
                
                if(rs.next() == true)
                {
                	System.out.println("�ifre Giriniz:");
                	sifre = giris.nextLine();
                	String sifre_tmp = rs.getString("sifre");
                	if(sifre.equals(sifre_tmp))
                	{
                		System.out.println("Giri� ba�ar�l�. Ho�geldiniz " + kullanici_adi);
                		break;
                	}
                	System.out.println("Girilen sifre dogru degildir. �slem Sonlandirildi.");
                	System.exit(0);
                }
                else
                {
                	System.out.println("B�yle bir kullan�c� ad� bulunamad�. �sleminiz sonlandirildi.");
                	System.exit(0);
                }
			}
			
			while(true)
			{
				int secim;
				System.out.println("----------��lemler----------");
                System.out.println("1-S�cakl�k Oku");
                System.out.println("2-So�utucu A�");
                System.out.println("3-So�utucu Kapat");
                System.out.println("4-��k��");
                
                int islem = giris.nextInt();
                switch(islem)
                {
                	case 1:              		
	                	System.out.println("Sicaklik: " + merkezi_birim.sicaklikOku());   
	                	System.out.println("Menu icin 1, cikis icin 2'ye basiniz!");
	                	secim = giris.nextInt();
	                	if(secim==1) continue;
	                	else
	                	{
	                		System.out.println("Basariyla Cikis Yapildi.");
	                		System.exit(0);
	                	}
	                	
                	case 2:
                		merkezi_birim.sogutucuAc();
                		System.out.println("Menu icin 1, cikis icin 2'ye basiniz!");
                		secim = giris.nextInt();
	                	if(secim==1) continue;
	                	else
	                	{
	                		System.out.println("Basariyla Cikis Yapildi.");
	                		System.exit(0);
	                	}
                	case 3:
                		merkezi_birim.sogutucuKapat();
                		System.out.println("Menu icin 1, cikis icin 2'ye basiniz!");
                		secim = giris.nextInt();
	                	if(secim==1) continue;
	                	else
	                	{
	                		System.out.println("Basariyla Cikis Yapildi.");
	                		System.exit(0);
	                	}
                	case 4:
                		System.out.println("Basariyla Cikis Yapildi.");
                		System.exit(0);
                }
                break;
			}
		}
		
		catch(SQLException ex)
		{
			System.out.println("error - "+ex.getMessage());
		}
	}
}
