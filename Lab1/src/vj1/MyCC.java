package vj1;

public class MyCC {
	public static void main(String[] args) {

		String hexColor = "0x1FF0FF";

		CC c = CC.decode(hexColor);

		float[] hsbCode = new float[3];
		float[] hslCode = new float[3];
		float[] cmykCode = new float[4];

		CC.RGBtoHSB(c.getR(), c.getG(), c.getB(), hsbCode);
		System.out.println("Boja u HEX formatu: 0x" + Integer.toHexString(c.getRGB() & 0x00FFFFFF));
		System.out.println("Boja u RGB formatu: " + c.getR() + ", " + c.getG() + ", " + c.getB());
		System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " + hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");
		CC.RGBtoHSL(c.getR(), c.getG(), c.getB(), hslCode);
		System.out.println("Boja HSL formatu: " + hslCode[0] * 360 + "°,  " + hslCode[1] * 100 + "%, " + hslCode[2] * 100 + "%");
		CC.RGBtoCMYK(c.getR(), c.getG(), c.getB(), cmykCode);
		System.out.println("Boja u CMYK formatu: " + cmykCode[0] + ", " + cmykCode[1] + ", " + cmykCode[2] + ", " + cmykCode[3]);

	}

}


