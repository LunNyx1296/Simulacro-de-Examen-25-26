package principal;

public class MotorNoElectrico extends Motor {

	private Combustible combustible;

	public MotorNoElectrico(String id, String marca, Combustible combustible) {
		super(id, marca);
		this.combustible = combustible;
	}

	@Override
	public double calcularCosteBase() {
		return combustible == Combustible.DIESEL ? 1500 : 2000;
	}
}