package in.srini91.learn.java8.dataTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InstantTimeEx {

	public static void main(String[] args) {
		Instant start = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant stop = Instant.now();
		Duration between = Duration.between(start, stop);
		System.out.println(between.toMillis());

		List<Person> persons = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(InstantTimeEx.class.getResourceAsStream("people.txt")))) {
			Stream<String> lines = br.lines();

			lines.map(line -> {
				String[] split = line.split(" ");
				Month month = Month.of(Integer.parseInt(split[2].trim()));
				Person p = new Person(split[0].trim(),
						LocalDate.of(Integer.parseInt(split[1].trim()), month, Integer.parseInt(split[3].trim())));
				persons.add(p);
				return p;
			}).forEach(System.out::println);
			;

		} catch (Exception e) {
			e.printStackTrace();
		}
		persons.forEach(p -> {
			LocalDate now = LocalDate.now();
			Period period = Period.between(p.getDob(), now);
			System.out.println(p.getName() + " was born " + period.get(ChronoUnit.YEARS) + " years and "
					+ period.get(ChronoUnit.MONTHS) + " months " + "[" + p.getDob().until(now, ChronoUnit.MONTHS)
					+ " months]");
		});

//		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
		ZoneId pstId = ZoneId.of("PST8PDT");
		System.out.println(LocalDate.now(indiaZone) + " - " + LocalTime.now(indiaZone));
		System.out.println(LocalDate.now(pstId) + " - " + LocalTime.now(pstId));

		ZonedDateTime zd = ZonedDateTime.now(indiaZone);
		ZonedDateTime pstZd = ZonedDateTime.now(pstId);
		System.out.println(Duration.between(Instant.now(Clock.system(indiaZone)), Instant.now(Clock.system(pstId))));
		System.out.println(
				"IndiaTime : " + zd + " pstTime : " + pstZd + " diff time " + Duration.between(zd, pstZd).getSeconds());
	}
}
