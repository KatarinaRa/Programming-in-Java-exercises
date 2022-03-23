
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class MjeracVode
{
    /*private Senzor[] senzori = {
            new Senzor("temperatura",   "int16",  10,   "C"),
            new Senzor("tlak",          "uint16", 1000, "Bar"),
            new Senzor("potrosnja",     "uint16", 0,    "litra"),
            new Senzor("vecaPotrosnja", "uint16", 10,   "m3")
    };*/
    private String topic;
    private String content;
    private String broker;
    private ArrayList<Senzor> senzori = new ArrayList<>();

    public MjeracVode(String broker, String topic) {
        /*this.topic = "mjerenjeprotokavode";*/
        this.broker = broker;
        this.topic = topic;
    }

    public void addSensors(Senzor senzor) {
        senzori.add(senzor);
    }

    private static String SenzorToJSON(Senzor senzor) {
        ObjectMapper mapper = new ObjectMapper();
        String json = new String();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(senzor);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return new RuntimeException(e.getCause()).getMessage();
        }
    }

    /*private Senzor[] defineSensorsByTopic(){
        if(this.topic == "mjerenjeprotokavode"){
            return this.senzori;
        }
        else {
            String[] topicArray = topic.split("\\.");
            int topicLen = topicArray.length;
            Senzor[] senzori2 = new Senzor[topicLen];
            int ctr = 0;
            for(var t : topicArray){
                    if(t.equals("temperatura")){
                        senzori2[ctr] = senzori[0];
                        ctr++;
                    }
                    if(t.equals("tlak")){
                        senzori2[ctr] = senzori[1];
                        ctr++;
                    }
                    if(t.equals("potrosnja")){
                        senzori2[ctr] = senzori[2];
                        ctr++;
                    }
                    if(t.equals("vecaPotrosnja")){
                        senzori2[ctr] = senzori[3];
                        ctr++;
                    }
            }
            return senzori2;
        }
    }*/
    public void start() throws InterruptedException {

        for(var s : senzori) {
            this.content = SenzorToJSON(s);
            int qos = 0;
            //String broker = "tcp://localhost:1883";
            String clientId = "JavaSample";
            MemoryPersistence persistence = new MemoryPersistence();
            try {
                MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                sampleClient.connect(connOpts);
                System.out.println("Publishing message: " + content);
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);


            } catch (MqttException e) {
                System.out.println("reason " + e.getReasonCode());
                System.out.println("msg " + e.getMessage());
                System.out.println("loc " + e.getLocalizedMessage());
                System.out.println("cause " + e.getCause());
                System.out.println("excep " + e);
                e.printStackTrace();
            }
        }
    }
}