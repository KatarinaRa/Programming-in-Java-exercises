package vj1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RGBtoHSLtest {

	@Test
	void test() {
		float[] RGBtoHSLtest = new float[3];
		RGBtoHSLtest = CC.RGBtoHSL(31, 240, 255, RGBtoHSLtest);
		assertEquals(0.5111607313156128, RGBtoHSLtest[0]);
		assertEquals(1.0, RGBtoHSLtest[1]);
		assertEquals(0.5607843399047852, RGBtoHSLtest[2]);
	}

}
