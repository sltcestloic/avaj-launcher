package me.loic.avaj;

public abstract class Aircraft {
    
    protected long id;
    protected String name;
    protected Coordinates coordinates;


    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    
}
