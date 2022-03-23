package vj1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RGBtoHSBtest {

	@Test
	void test() {
		float[] RGBtoHSBtest = new float[3];
		RGBtoHSBtest = CC.RGBtoHSB(31, 240, 255, RGBtoHSBtest);
		assertEquals(0.5111607313156128, RGBtoHSBtest[0]);
		assertEquals(0.8784313797950745, RGBtoHSBtest[1]);
		assertEquals(1.0, RGBtoHSBtest[2]);

	}

}
