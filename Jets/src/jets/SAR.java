package jets;

public class SAR extends Jet implements MAYDAY {

	public SAR() {
	}

	public SAR(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void mayday() {
		System.out.println("\nMAYDAY, MAYDAY, MAYDAY.... \nvessel taking on water 350 nautical miles south-south-east of Nassau, "
				+ "4 people on board. \nDispatch all Search and Rescue jets. \nFirst onscene drop datum and commence expanding square search pattern.\n");
		
	}

}
