package com.database.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;

import com.MockitoExtension;
import com.airport.Flight;
import com.database.Database;
import com.database.DatabaseUtil;

@ExtendWith(MockitoExtension.class)
public class StatisticsTest {

	@Spy
	private Database database;
	
	private List<List<String>> queriedData;
	private List<Flight> flightList;
	
	@BeforeEach
	void before() {
		queriedData=new ArrayList<>();
		List<String> row1=Arrays.asList("1","e","vivek", "false","349");
		List<String> row2=Arrays.asList("2","b","harsha", "true","278");
		List<String> row3=Arrays.asList("3","e","vivek", "false","319");
		List<String> row4=Arrays.asList("4","p","harsha", "true","817");
		List<String> row5=Arrays.asList("5","e","vivek", "false","623");
		List<String> row6=Arrays.asList("6","e","harsha", "true","978");
		
		queriedData.add(row1);
		queriedData.add(row2);
		queriedData.add(row3);
		queriedData.add(row4);
		queriedData.add(row5);
		queriedData.add(row6);
	}
	
	@Test
	void testQueriedData() {
		when(database.queryFlightDatabase()).thenReturn(queriedData);
		
		flightList=DatabaseUtil.buildFlightList(queriedData);
		assertEquals(6,database.queryFlightDatabase().size());
		assertEquals(6,flightList.size());
		assertEquals(560.666, database.averageDistance(flightList),0.001);
		assertEquals(278,database.minimumDistance(flightList));
		assertEquals(978, database.maximumDistance(flightList));
	}
}
