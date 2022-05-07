package AkilliCihazTasarim;

public class MerkeziBirim {
	
	private Eyleyici sogutucu;
	private SicaklikAlgilayici algilayici;
	
	MerkeziBirim()
	{
		this.sogutucu = new Eyleyici();
		this.algilayici = new SicaklikAlgilayici();
		
	}
	public void sogutucuAc()
	{
		this.sogutucu.update("Basarili.");
		this.sogutucu.sogutucuAc();
	}
	public void sogutucuKapat()
	{
		this.sogutucu.update("Basarili.");
		this.sogutucu.sogutucuKapat();
	}
	public int sicaklikOku()
	{
		this.algilayici.update("Basarili.");
		return this.algilayici.RastgeleSicaklikUret();
	}
}
