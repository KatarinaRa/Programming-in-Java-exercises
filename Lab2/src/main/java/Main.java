
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var mjerac = new MjeracVode("tcp://localhost:1883","mjerenjevode");

        var senzor1 = new Senzor("temperatura",   "int16",  10,   "celzius", 1500, 15);
        var senzor2 = new Senzor("greaterConsumption", "uint16", 1000, "Bar",     3267, 3);

        mjerac.addSensors(senzor1);
        mjerac.addSensors(senzor2);

        mjerac.start();

    }
}
