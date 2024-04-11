package me.loic.avaj;

import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class Launcher {

    private static long currentId = 0;

    private static void exit(String message) {
        System.out.println(message);
        System.exit(1);
    }

    public static long nextId() {
        return ++currentId;
    }
    
    private void run(List<String> lines) throws UnknownFlyableTypeException, NumberFormatException {
        WeatherTower tower = new WeatherTower();
    
        if (lines.size() < 1)
            exit("Error: Input file is empty.");

        String firstLine = lines.remove(0);
        if (firstLine.split(" ").length != 1)
            exit("Error: Invalid first line.");
        int iterations = Integer.parseUnsignedInt(firstLine);
    
        for(String line : lines) {
            String[] parts = line.split(" ");
            if (parts.length != 5)
                exit("Error: Invalid line \"" + line + "\"");
            Coordinates coordinates = new Coordinates(Integer.parseUnsignedInt(parts[2]), Integer.parseUnsignedInt(parts[3]), Integer.parseUnsignedInt(parts[4]));
            Flyable flyable = AircraftFactory.getInstance().newAircraft(parts[0], parts[1], coordinates);
            flyable.registerTower(tower);
        };
    
        while (iterations > 0) {
            tower.changeWeather();
            --iterations;
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 1) exit("Usage: Launcher <file path>");
    
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            new Launcher().run(lines);
            Logger.dump("simulation.txt");
        } catch (UnknownFlyableTypeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e.getMessage());
            System.exit(1);
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getFile());
            System.exit(1);
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for " + e.getFile());
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
