package me.loic.avaj;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {
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
                latitude += 5;
                Logger.log(this + " It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                latitude += 1;
                Logger.log(this + " OH MY GOD I CANT SEE ANYTHING");
                break;
            case "SUN":
                latitude += 10;
                height += 2;
                Logger.log(this + " Let's enjoy the good weather and take some pics.");
                break;
            case "SNOW":
                height -= 7;
                Logger.log(this + " OMG! Winter is coming!");
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
