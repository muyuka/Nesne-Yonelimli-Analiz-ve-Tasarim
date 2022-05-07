package AkilliCihazTasarim;
import java.util.Random;
public class SicaklikAlgilayici implements ISicaklikAlgilayici,IObserver {
	int sicaklik;
	public int RastgeleSicaklikUret()
	{
		Random rastgeleSicaklik = new Random();
		sicaklik = rastgeleSicaklik.nextInt(40);
		return sicaklik;
	}
	@Override
	public void update(String mesaj) 
	{
		System.out.println("Sicaklik Algilayici Cihaz ile olan haberleþme " + mesaj);
	}
}
