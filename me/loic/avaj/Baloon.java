package me.loic.avaj;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        var longitude = this.coordinates.getLongitude();
        var latitude = this.coordinates.getLatitude();
        var height = this.coordinates.getHeight();
        var weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                height -= 5;
                Logger.log(this + " Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                height -= 3;
                Logger.log(this + " OH MY GOD I CANT SEE ANYTHING");
                break;
            case "SUN":
                longitude += 2;
                height += 4;
                Logger.log(this + " Let's enjoy the good weather and take some pics.");
                break;
            case "SNOW":
                height -= 15;
                Logger.log(this + " It's snowing. We're gonna crash.");
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
}
