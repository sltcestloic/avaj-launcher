package me.loic.avaj;

public abstract class Flyable {

    protected WeatherTower weatherTower;
    
    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != null)
			this.weatherTower.unregister(this);
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
