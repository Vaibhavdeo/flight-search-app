package com.search.flight.util;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import com.search.flight.beans.FlightDetails;

public class FlightUtility {
	
	private final static Logger LOGGER = Logger.getLogger(FlightUtility.class.getName());
	public static List<FlightDetails> listFlight = new ArrayList<>();
	
	public static List<FlightDetails> loadFlightDataProvider(String provider, char delimeter) throws IOException {
		
		listFlight.clear();
		ClassPathResource res = new ClassPathResource(provider);
		URI paths = res.getURI();
		Path path = Paths.get(paths);
		try (Reader reader = Files.newBufferedReader(path);
				@SuppressWarnings("static-access")
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.DEFAULT.withDelimiter(delimeter)
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
				LOGGER.info("Record No - " + csvRecord.getRecordNumber());
				LOGGER.info("Record No - " + details.getOrigin());
				LOGGER.info("Record No - " + details.getDestination());
				listFlight.add(details);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listFlight;

	}
		
}
