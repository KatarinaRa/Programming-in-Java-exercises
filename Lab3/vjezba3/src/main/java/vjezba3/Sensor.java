package vjezba3;

public class Sensor {
	private String name;
	private String data_type;
	private int factor;
	private double min;
	private double max;
	private double value;
	private String unit;

	public Sensor(String name, String data_type, int factor, double min, double max, double value, String unit) {
		this.name = name;
		this.data_type = data_type;
		this.factor = factor;
		this.min = min;
		this.max = max;
		this.value = value;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public void generaterandom() {

		if (min < 0)
			value = (int) (Math.random() * (max - (min)) + (min));
		else
			value = (int) (Math.random() * max);

	}

	@Override
	public String toString() {
		return "{name:" + name + ",data_type:" + data_type + ",factor:" + factor + ",min:" + min + ",max:" + max
				+ ",value:" + value + ",unit:" + unit + "}";
	}

}
