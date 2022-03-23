package vj1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RGBtoCMYKtest {

	@Test
	void test() {
		float[] RGBtoCMYKtest = new float[4];
		RGBtoCMYKtest = CC.RGBtoCMYK(31, 240, 255, RGBtoCMYKtest);
		assertEquals(0.8784313797950745, RGBtoCMYKtest[0]);
		assertEquals(0.05882352590560913, RGBtoCMYKtest[1]);
		assertEquals(0.0, RGBtoCMYKtest[2]);
		assertEquals(0.0, RGBtoCMYKtest[3]);

	}

}
