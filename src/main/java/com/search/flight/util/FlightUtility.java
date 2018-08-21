package com.search.flight.util;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import com.search.flight.beans.FlightDetails;

public class FlightUtility {

	public static List<FlightDetails> loadFlightData() throws IOException {

		List<FlightDetails> listFlight = new ArrayList<FlightDetails>();
		ClassPathResource res = new ClassPathResource("provider.csv");
		URI paths = res.getURI();
		Path path = Paths.get(paths);

		try (Reader reader = Files.newBufferedReader(path);
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withSkipHeaderRecord()
						.withHeader("Origin", "Departure Time", "Destination",
								"Destination Time", "Price")
						.withIgnoreHeaderCase().withTrim());) {
			for (CSVRecord csvRecord : csvParser) {
				FlightDetails details = new FlightDetails();
				details.setOrigin(csvRecord.get(0).trim());
				details.setDepartureTime(csvRecord.get(1).trim());
				details.setDestination(csvRecord.get(2).trim());
				details.setDestinationTime(csvRecord.get(3).trim());
				details.setPrice(csvRecord.get(4));

				System.out
						.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("Origin : " + details.getOrigin());
				System.out.println("Departure Time : "
						+ details.getDepartureTime());
				System.out.println("Destination : " + details.getDestination());
				System.out.println("Destination Time: "
						+ details.getDestinationTime());
				System.out.println("Price : " + details.getPrice());
				System.out.println("---------------\n\n");
				listFlight.add(details);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listFlight;

	}

}
