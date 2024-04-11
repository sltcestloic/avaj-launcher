package me.loic.avaj;

public class AircraftFactory {

	private static AircraftFactory instance;

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}
    
    public Flyable newAircraft(String type, String name, Coordinates coordinates) throws UnknownFlyableTypeException {
		switch (type) {
			case "JetPlane":
				return new JetPlane(Launcher.nextId(), name, coordinates);
			case "Helicopter":
				return new Helicopter(Launcher.nextId(), name, coordinates);
			case "Baloon":
				return new Baloon(Launcher.nextId(), name, coordinates);
			default:
				throw new UnknownFlyableTypeException(type);
		}
    }
}
