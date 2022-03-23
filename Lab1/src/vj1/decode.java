package vj1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class decode {

	@Test
	void test() {
		CC decodeTest = new CC(0, 0, 0);
		decodeTest = CC.decode("0x1FF0FF");
		int rt = decodeTest.getR();
		int gt = decodeTest.getG();
		int bt = decodeTest.getB();
		assertEquals(31, rt);
		assertEquals(240, gt);
		assertEquals(255, bt);

	}

}
