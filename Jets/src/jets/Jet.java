package jets;

public abstract class Jet {
	private String type;
	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet() {
	}

	public Jet(String type, String model, double speed, int range, long price) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public long getPrice() {
		return price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public void flyNow() {
		
	}

	@Override
	public String toString() {
		return "Jet: " + type + model + speed + range + "$" + price;
	}
	
	
	
	

}
