package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		
		Game g = new Game("a","b","c","d");
		VideoGames.VideoGame g2 = new VideoGames.VideoGame("a","b","c","d");
		List<VideoGames.VideoGame> foo = new ArrayList<>();
		foo.add(g2);
		
		System.out.println(g);
		
		Isotope sampleA = new Isotope(38, "Strontium-90", "Sr", 28.9, 10.0);
		Isotope sampleB = new Isotope(sampleA, 5);
		Isotope myFav = new Isotope(38, "Strontium-90", "Sr", 28.9);
		
		Duration d = Duration.ofDays((long) (365.25 * 5));
		double decayMass = sampleA.decay(d);

		System.out.println(sampleA);
		System.out.println(sampleB);
		System.out.println(myFav);
		
		int n = 30;
		Duration year = Duration.ofDays(365);
		for (int i = 0; i <= n; i++) {
			sampleA.decay(year);
			System.out.println(sampleA);
		}

		
	}

}
