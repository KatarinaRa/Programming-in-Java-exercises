package vjezba3;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class Testers {

	@Test
	public void toStringTest() {
		String expectedString = "{name:" + "Water temperature" + ",data_type:" + "int16" + ",factor:" + 10 + ",min:"
				+ -3266.8 + ",max:" + 3266.8 + ",value:" + 0.0 + ",unit:" + "Celsius" + "}";

		Sensor tester = new Sensor("Water temperature", "int16", 10, -3266.8, 3266.8, 0, "Celsius");
		assertEquals(expectedString, tester.toString());
	}

	@Test
	public void loadJSONTest() {
		Sensor sensor = new Sensor("Consumption 1w1m1y", "uint16", 10, 0.0, 6533.6, 0.0, "m3");
		List<Sensor> sensors = WaterFlowMeter.loadJSON("JSONfile.json").sensors;
		Sensor tester = sensors.get(3);
		assertEquals(sensor.toString(), tester.toString());

	}

}
