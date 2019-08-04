package jets;

public class JetImp extends Jet {

	public JetImp() {
	}

	public JetImp(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public String toString() {
		return "Jet: " + getType() + "\t" + getModel() + "\t" + getSpeed() + "\t" + getRange() + "\t" + "$" + getPrice();
	}
}
	
	
