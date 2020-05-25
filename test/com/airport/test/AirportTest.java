package com.airport.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import com.airport.BusinessFlight;
import com.airport.EconomicFlight;
import com.airport.Flight;
import com.airport.Passenger;
import com.airport.PremiumFlight;

public class AirportTest {

	@DisplayName("Given there is a Economic Flight")
	@Nested
	class EconomicFlightTest {
		private Flight economicFlight;
		private Passenger vivek;
		private Passenger harsha;

		@BeforeEach
		void setUp() {
			economicFlight = new EconomicFlight("1");
			vivek = new Passenger("vivek", false);
			harsha = new Passenger("harsha", true);
		}

		@Nested
		@DisplayName("When we have usual Economic passenger")
		class EconomicUsualPassengerTest {

			@Test
			@DisplayName("Then you can add and remove him from Economic flight")
			public void testEconomicFlightUsualPassenger() {
				assertAll("Verify all conditions for usual passenger and a economic flight",
						() -> assertEquals(true, economicFlight.addPassenger(vivek)),
						() -> assertEquals(1, economicFlight.getPassengerList().size()),
						() -> assertEquals(true, economicFlight.removePassenger(vivek)));
			}
		}

		@Nested
		@DisplayName("When we have VIP Economic Passenger")
		class EconomicVipPassengerTest {

			@Test
			@DisplayName("Then you can add and remove him from Economic flight")
			public void testEconomicFlightVipPassenger() {
				assertAll("Verify all conditions for vip passenger and a economic flight",
						() -> assertEquals(true, economicFlight.addPassenger(harsha)),
						() -> assertEquals(1, economicFlight.getPassengerList().size()),
						() -> assertEquals(false, economicFlight.removePassenger(harsha)));
			}
		}
	}

	@DisplayName("Given there is a Business Flight")
	@Nested
	class BusinessFlightTest {
		private Flight businessFlight;
		private Passenger vivek;
		private Passenger harsha;

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2");
			harsha = new Passenger("harsha", false);
			vivek = new Passenger("vivek", true);
		}

		@Nested
		@DisplayName("When we have usual Business flight passenger")
		class BusinessUsualPassengerTest {
			@Test
			@DisplayName("Then you can add and remove him from Business flight")
			public void testBusinessFlightUsualPassenger() {
				assertAll("Verify all conditions for business usual passenger and a business flight",
						() -> assertEquals(false, businessFlight.addPassenger(harsha)),
						() -> assertEquals(0, businessFlight.getPassengerList().size()),
						() -> assertEquals(false, businessFlight.removePassenger(harsha)));
			}
		}
		

		@Nested
		@DisplayName("When we have vip Business flight passenger")
		class BusinessVipPassengerTest {
			@Test
			@DisplayName("Then you can add and remove him from Business flight")
			public void testBusinessFlightVipPassenger() {
				assertAll("Verify all conditions for business vip passenger and a business flight",
						() -> assertEquals(true, businessFlight.addPassenger(vivek)),
						() -> assertEquals(1, businessFlight.getPassengerList().size()),
						() -> assertEquals(false, businessFlight.removePassenger(vivek)));

			}
			
			
			@RepeatedTest(3)
			@DisplayName("then we cannot add more than once business vip passenger")
			public void testBusinessFlightVipPassengerAddOnlyOnce(RepetitionInfo repetitionInfo)
			{
				for(int i=0;i<repetitionInfo.getCurrentRepetition();i++) {
					businessFlight.addPassenger(vivek);
				}
				assertAll("Verify all conditions for business vip passenger cannot add more than one",
						()-> assertEquals(1,businessFlight.getPassengerList().size()),
						()-> assertEquals(false,businessFlight.removePassenger(vivek))
						);
				
			}

		}
	}


	@DisplayName("Givne there is a Premium Flight")
	@Nested
	class PremiumFlightTest{
		private Flight premiumFlight;
		private Passenger vivek;
		private Passenger harsha;
	
		@BeforeEach
		void setUp() {
			premiumFlight=new PremiumFlight("3");
			vivek=new Passenger("vivek", false);
			harsha=new Passenger("harsha",true);
		}
		
		@Nested
		@DisplayName("When we have a Premium usual passenger")
		class PremiumUsualPassenger {

			@Test
			@DisplayName("Then you cannot add or remove from Premium Flight")
			void testPremiumFlightUsualPassenger() {
				assertAll("Verify all conditions for Usual passenger and a Premium flight",
						() -> assertEquals(false, premiumFlight.addPassenger(vivek)),
						() -> assertEquals(0, premiumFlight.getPassengerList().size()),
						() -> assertEquals(false, premiumFlight.removePassenger(vivek)));
			}

		}

		@Nested
		@DisplayName("When we have a Premium VIP passenger")
		class PremiumVipPassenger {

			@Test
			@DisplayName("Then you cannot add or remove from Premium Flight")
			void testPremiumFlightVipPassenger() {
				assertAll("Verify all conditions for VIP passenger and a Premium flight",
						() -> assertEquals(true, premiumFlight.addPassenger(harsha)),
						() -> assertEquals(1, premiumFlight.getPassengerList().size()),
						() -> assertEquals(true, premiumFlight.removePassenger(harsha)));
			}

			@RepeatedTest(3)
			@DisplayName("then we cannot add more than once premium vip passenger")
			public void testPremiumFlightVipPassengerAddOnlyOnce(RepetitionInfo repetitionInfo)
			{
				for(int i=0;i<repetitionInfo.getCurrentRepetition();i++) {
					premiumFlight.addPassenger(harsha);
				}
				assertAll("Verify all conditions for premium vip passenger cannot add more than one",
						()-> assertEquals(1,premiumFlight.getPassengerList().size()),
						()-> assertEquals(true,premiumFlight.removePassenger(harsha))
						);
				
			}
		}

	}

}
