package me.loic.avaj;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        var longitude = this.coordinates.getLongitude();
        var latitude = this.coordinates.getLatitude();
        var height = this.coordinates.getHeight();
        var weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                longitude += 5;
                Logger.log(this + " There is no way it's raining again");
                break;
            case "FOG":
                longitude += 1;
                Logger.log(this + " OH MY GOD I CANT SEE ANYTHING");
                break;
            case "SUN":
                longitude += 10;
                height += 2;
                Logger.log(this + " This is hot.");
                break;
            case "SNOW":
                height -= 12;
                Logger.log(this + " My rotor is going to freeze!");
                break;
            default:
                break;
        }
        height = Math.max(0, Math.min(height, 100));
        this.coordinates = new Coordinates(longitude, latitude, height);
        if (this.coordinates.getHeight() == 0) {
            Logger.log(this + " landing.");
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != null)
			this.weatherTower.unregister(this);
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
