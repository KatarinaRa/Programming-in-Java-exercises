package vjezba3;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

	public static void main(String[] args) throws InterruptedException, MqttException {
		WaterFlowMeter m = WaterFlowMeter.loadJSON("JSONfile.json");
		m.WaterMeter();
	}
}
