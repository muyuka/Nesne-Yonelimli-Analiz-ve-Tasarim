package AkilliCihazTasarim;

public class Eyleyici implements IEyleyici,IObserver {
	
	private boolean sogutucuDurumu;
	
	Eyleyici()
	{
		this.sogutucuDurumu = false;
	}
	
	@Override
	public void sogutucuAc()
	{
		if(sogutucuDurumu == false)
		{
			sogutucuDurumu = true;
			System.out.println("Sogutucu Acildi.");
		}
		else
		{
			System.out.println("Sogutucu Zaten Acik!");
		}
	}
	
	@Override
	public void sogutucuKapat()
	{
		if(sogutucuDurumu == true)
		{
			sogutucuDurumu = false;
			System.out.println("Sogutucu Kapatildi.");
		}
		else
		{
			System.out.println("Sogutucu Zaten Kapali!");
		}
	}

	@Override
	public void update(String mesaj) 
	{
		System.out.println("Eyleyici ile olan haberleþme " + mesaj);		
	}
}
