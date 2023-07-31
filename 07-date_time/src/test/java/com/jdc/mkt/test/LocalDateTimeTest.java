package com.jdc.mkt.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

	// @Test
	void test1() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);

		var ld1 = LocalDate.of(2011, 12, 20);
		System.out.println(ld1);

		var ld2 = LocalDate.ofYearDay(2011, 120);
		System.out.println(ld2);

	}

	// @Test
	void test2() {
		Instant i = Instant.now();
		System.out.println(i);

		var ld = LocalDate.ofInstant(i, ZoneOffset.of(""));
		System.out.println(ld);

		var ldt = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(ldt);
	}

	// @Test
	@DisplayName("3. mechine to human")
	void test3() {
		Instant i = Instant.now();
		var offset_date_time = i.atOffset(ZoneOffset.MAX);
		System.out.println(offset_date_time);

		var zone_date_time = i.atZone(ZoneId.of("Asia/Yangon"));
		System.out.println(zone_date_time);

	}

	//@Test
	void test4() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.get(ChronoField.DAY_OF_YEAR));
		var p = Period.ofMonths(2);
		
		ldt = ldt.plus(p);
		ldt = ldt.minus(p);
		ldt = ldt.with(ChronoField.YEAR, 2020);
		System.out.println(ldt);
		ldt = ldt.plus(60, ChronoUnit.MINUTES);
		System.out.println(ldt.getHour());
		
	}
	@Test 
	void test5() {
		Duration d = Duration.between(LocalTime.now(), LocalTime.of(16, 00));
		LocalTime t = LocalTime.ofSecondOfDay(d.getSeconds());
		System.out.println(t);
		
		Period p = Period.between(LocalDate.now(), LocalDate.of(2024, 04, 20));
		System.out.println(p);
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld.get(ChronoField.MONTH_OF_YEAR));
		System.out.println(ld.getMonth());
	}
}
