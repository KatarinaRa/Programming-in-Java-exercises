package vjezba3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.google.gson.Gson;

public class WaterFlowMeter {
	private String topic;
	private String broker;
	private String clientId;
	List<Sensor> sensors;

	public WaterFlowMeter(String topic, String broker, String clientId, List<Sensor> sensors) {
		this.topic = topic;
		this.broker = broker;
		this.clientId = clientId;
		this.sensors = sensors;
	}

	public WaterFlowMeter() {
	}

	public static WaterFlowMeter loadJSON(String file) {

		Gson gson = new Gson();
		try {
			Reader json_file = new FileReader(file);
			WaterFlowMeter obj = gson.fromJson(json_file, WaterFlowMeter.class);
			return obj;
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private String ConvertObjToJSON(Sensor sensor) {
		Gson gson = new Gson();
		sensor.generaterandom();
		String jsonString = gson.toJson(sensor);
		return jsonString;
	}

	public void WaterMeter() throws InterruptedException, MqttException {

		while (true) {

			MemoryPersistence persistence = new MemoryPersistence();
			MqttClient client = new MqttClient(broker, clientId, persistence);
			try {
				MqttConnectOptions connOpts = new MqttConnectOptions();
				connOpts.setCleanSession(true);
				client.connect(connOpts);

				String msg2 = "\nMeasuring data:\n";
				MqttMessage message2 = new MqttMessage(msg2.getBytes());
				client.publish(topic, message2);
				
				System.out.println("\nPublishing message...\n");
				for(Sensor s: sensors) {
			
					MqttMessage message = new MqttMessage(ConvertObjToJSON(s).getBytes());
					System.out.println(message);
					client.publish(topic, message);
				}

				Thread.sleep(5000);
			}

			catch (MqttException greska) {
				System.out.println("Error\n");
				greska.printStackTrace();
			}

			finally {
				client.disconnect();
				client.close();
			}
		}
	}
}