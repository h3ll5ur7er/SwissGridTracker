package ch.hellsurfer.apps.sgt;

import android.location.*;

public class SwissGridCoordinates
{
	private int l,b,h,a;


	public int getL()
	{
		return l;
	}
	public int getB()
	{
		return b;
	}

	public int getH()
	{
		return h;
	}

	public int getA()
	{
		return a;
	}

	public void setA(int a)
	{
		this.a = a;
	}
	public void setH(int h)
	{
		this.h = h;
	}
	public void setL(int l)
	{
		this.l = l;
	}
	public void setB(int b)
	{
		this.b=b;
	}
	
	public static SwissGridCoordinates fromGPS(Location gps)
	{
		SwissGridCoordinates c = new SwissGridCoordinates();
		
		c.setH((int)gps.getAltitude());
		c.setA((int)gps.getAccuracy());

		String BS = gps.convert(gps.getLatitude(),gps.FORMAT_SECONDS);
		String LS = gps.convert(gps.getLongitude(),gps.FORMAT_SECONDS);

		String[] B = BS.split(":");
		String[] L = LS.split(":");
		

		double b_deg = (int)Double.parseDouble(B[0]);
		double b_min = (int)Double.parseDouble(B[1]);
		double b_sec = (int)Double.parseDouble(B[2].replace(',','.'));
		double _b = b_deg*3600+b_min*60+b_sec;
		
		double l_deg = (int)Double.parseDouble(L[0]);
		double l_min = (int)Double.parseDouble(L[1]);
		double l_sec = (int)Double.parseDouble(L[2].replace(',','.'));
		double _l = l_deg*3600+l_min*60+l_sec;
		
		
		double bPr = (_b-169028.66d) / 10000d;
		
		double lPr = (_l-26782.5d) / 10000d;
		
		c.setL((int)(600072.37 + 211455.93 * lPr - 10938.51 * lPr * bPr - 0.36 * lPr * bPr*bPr - 44.54 * lPr*lPr*lPr));
			
		c.setB((int)(200147.07+ 308807.95 * bPr + 3745.25 * lPr*lPr + 76.63 * bPr*bPr- 194.56 * lPr*lPr*bPr+ 119.79 * bPr*bPr*bPr));
		
		return c;
	}

	@Override
	public String toString()
	{
		// TODO: Implement this method
		return l+" / "+b+" / "+h+"+-"+a;
	}
}
