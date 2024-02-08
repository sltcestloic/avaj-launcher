package me.loic.avaj;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    
    private static List<String> lines = new ArrayList<>();

	public static void log(String line) {
		lines.add(line);
	}

	public static void dump(String dest) throws IOException {
		Files.write(Paths.get(dest), Logger.lines, StandardCharsets.UTF_8);
	}
}
