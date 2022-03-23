
public class Senzor
{
    private String nazivPodatka;
    private String tipPodatka;
    private int faktor;
    private String mjernaJedinica;
    private double minValue;
    private double maxValue;
    private double result;

    private int desetMinuta;
    private int sat;
    private int dan;
    private int tjedan;
    private int mjesec;
    private int godina;

    public Senzor(String nazivPodatka, String tipPodatka, int faktor, String mjernaJedinica, double maxValue, double minValue) {
        this.nazivPodatka = nazivPodatka;
        this.tipPodatka = tipPodatka;
        this.faktor = faktor;
        this.mjernaJedinica = mjernaJedinica;
        this.minValue = minValue; //korisnik sam moze unit min i max
        this.maxValue = maxValue;
        this.result = ((Math.random() * (maxValue - (minValue))) + (minValue));

        /*if (mjernaJedinica == "C") {
            this.raspon = (int) ((Math.random() * (3266.8 - (-3266.8))) + (-3266.8));
        }
        else if (mjernaJedinica == "Bar") {
            this.raspon = (int) ((Math.random() * (65.336 - (0))) + 0);
        }
        else if (mjernaJedinica == "litra") {
            this.raspon = (int) ((Math.random() * (65336 - (0))) + 0);
            this.desetMinuta = raspon * 10;
            this.sat = raspon * 60;
            this.dan = raspon * 1440;
        }
        else if (mjernaJedinica == "m3") {
            this.raspon = (int) ((Math.random() * (6533.6 - (0))) + 0);
            this.tjedan = raspon * (1440 * 7);
            this.mjesec = raspon * (1440 * 7 * 4);
            this.godina = raspon * (1440 * 365);
        }
        else {
            System.out.println("Greska!");
        }*/
    }

    public String getNazivPodatka() {
        return nazivPodatka;
    }
    public void setNazivPodatka(String nazivPodatka) {
        this.nazivPodatka = nazivPodatka;
    }

    public String getTipPodatka() {
        return tipPodatka;
    }
    public void setTipPodatka(String tipPodatka) {
        this.tipPodatka = tipPodatka;
    }

    public int getFaktor() {
        return faktor;
    }
    public void setFaktor(int faktor) {
        this.faktor = faktor;
    }

    public String getmjernaJedinica() {
        return mjernaJedinica;
    }
    public void setmjernaJedinica(String mjernaJedinica) {
        this.mjernaJedinica = mjernaJedinica;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    /*public int getDesetMinuta() {
        return desetMinuta;
    }
    public int getSat() {
        return sat;
    }
    public int getDan() {
        return dan;
    }
    public int getTjedan() {
        return tjedan;
    }
    public int getMjesec() {
        return mjesec;
    }
    public int getGodina() {
        return godina;
    }*/

}
