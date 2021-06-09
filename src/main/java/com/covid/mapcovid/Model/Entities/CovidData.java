package com.covid.mapcovid.Model.Entities;

import java.util.Arrays;
import java.util.List;

public class CovidData {
	
	private String continent; 
	private String location;
	private String date;
	private String total_cases;
	private String new_cases;
	private String new_cases_smoothed;
	private String total_deaths;
	private String new_deaths;
	private String new_deaths_smoothed;
	private String total_cases_per_million;
	private String new_cases_per_million;
	private String new_cases_smoothed_per_million;
	private String total_deaths_per_million;
	private String new_deaths_per_million;
	private String new_deaths_smoothed_per_million;
	private String reproduction_rate;
	private String icu_patients;
	private String icu_patients_per_million;
	private String hosp_patients;
	private String hosp_patients_per_million;
	private String weekly_icu_admissions;
	private String weekly_icu_admissions_per_million;
	private String weekly_hosp_admissions;
	private String weekly_hosp_admissions_per_million;
	private String total_tests;
	private String new_tests;
	private String total_tests_per_thousand;
	private String new_tests_per_thousand;
	private String new_tests_smoothed;
	private String new_tests_smoothed_per_thousand;
	private String positive_rate;
	private String tests_per_case;
	private String tests_units;
	private String total_vaccinations;
	private String people_vaccinated;
	private String people_fully_vaccinated;
	private String new_vaccinations;
	private String new_vaccinations_smoothed;
	private String total_vaccinations_per_hundred;
	private String people_vaccinated_per_hundred;
	private String people_fully_vaccinated_per_hundred;
	private String new_vaccinations_smoothed_per_million;
	private String stringency_index;
	private String population;
	private String population_density;
	private String median_age;
	private String aged_65_older;
	private String aged_70_older;
	private String gdp_per_capita;
	private String extreme_poverty;
	private String cardiovasc_death_rate;
	private String diabetes_prevalence;
	private String female_smokers;
	private String male_smokers;
	private String handwashing_facilities;
	private String hospital_beds_per_thousand;
	private String life_expectancy;
	private String human_development_index;
	
	@Override
	public String toString() {
		return "CovidData [continent=" + continent + ", location=" + location + ", date=" + date + ", total_cases="
				+ total_cases + ", new_cases=" + new_cases + ", new_cases_smoothed=" + new_cases_smoothed
				+ ", total_deaths=" + total_deaths + ", new_deaths=" + new_deaths + ", new_deaths_smoothed="
				+ new_deaths_smoothed + ", total_cases_per_million=" + total_cases_per_million
				+ ", new_cases_per_million=" + new_cases_per_million + ", new_cases_smoothed_per_million="
				+ new_cases_smoothed_per_million + ", total_deaths_per_million=" + total_deaths_per_million
				+ ", new_deaths_per_million=" + new_deaths_per_million + ", new_deaths_smoothed_per_million="
				+ new_deaths_smoothed_per_million + ", reproduction_rate=" + reproduction_rate + ", icu_patients="
				+ icu_patients + ", icu_patients_per_million=" + icu_patients_per_million + ", hosp_patients="
				+ hosp_patients + ", hosp_patients_per_million=" + hosp_patients_per_million
				+ ", weekly_icu_admissions=" + weekly_icu_admissions + ", weekly_icu_admissions_per_million="
				+ weekly_icu_admissions_per_million + ", weekly_hosp_admissions=" + weekly_hosp_admissions
				+ ", weekly_hosp_admissions_per_million=" + weekly_hosp_admissions_per_million + ", total_tests="
				+ total_tests + ", new_tests=" + new_tests + ", total_tests_per_thousand=" + total_tests_per_thousand
				+ ", new_tests_per_thousand=" + new_tests_per_thousand + ", new_tests_smoothed=" + new_tests_smoothed
				+ ", new_tests_smoothed_per_thousand=" + new_tests_smoothed_per_thousand + ", positive_rate="
				+ positive_rate + ", tests_per_case=" + tests_per_case + ", tests_units=" + tests_units
				+ ", total_vaccinations=" + total_vaccinations + ", people_vaccinated=" + people_vaccinated
				+ ", people_fully_vaccinated=" + people_fully_vaccinated + ", new_vaccinations=" + new_vaccinations
				+ ", new_vaccinations_smoothed=" + new_vaccinations_smoothed + ", total_vaccinations_per_hundred="
				+ total_vaccinations_per_hundred + ", people_vaccinated_per_hundred=" + people_vaccinated_per_hundred
				+ ", people_fully_vaccinated_per_hundred=" + people_fully_vaccinated_per_hundred
				+ ", new_vaccinations_smoothed_per_million=" + new_vaccinations_smoothed_per_million
				+ ", stringency_index=" + stringency_index + ", population=" + population + ", population_density="
				+ population_density + ", median_age=" + median_age + ", aged_65_older=" + aged_65_older
				+ ", aged_70_older=" + aged_70_older + ", gdp_per_capita=" + gdp_per_capita + ", extreme_poverty="
				+ extreme_poverty + ", cardiovasc_death_rate=" + cardiovasc_death_rate + ", diabetes_prevalence="
				+ diabetes_prevalence + ", female_smokers=" + female_smokers + ", male_smokers=" + male_smokers
				+ ", handwashing_facilities=" + handwashing_facilities + ", hospital_beds_per_thousand="
				+ hospital_beds_per_thousand + ", life_expectancy=" + life_expectancy + ", human_development_index="
				+ human_development_index + "]";
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotal_cases() {
		return total_cases;
	}
	public void setTotal_cases(String total_cases) {
		this.total_cases = total_cases;
	}
	public String getNew_cases() {
		return new_cases;
	}
	public void setNew_cases(String new_cases) {
		this.new_cases = new_cases;
	}
	public String getNew_cases_smoothed() {
		return new_cases_smoothed;
	}
	public void setNew_cases_smoothed(String new_cases_smoothed) {
		this.new_cases_smoothed = new_cases_smoothed;
	}
	public String getTotal_deaths() {
		return total_deaths;
	}
	public void setTotal_deaths(String total_deaths) {
		this.total_deaths = total_deaths;
	}
	public String getNew_deaths() {
		return new_deaths;
	}
	public void setNew_deaths(String new_deaths) {
		this.new_deaths = new_deaths;
	}
	public String getNew_deaths_smoothed() {
		return new_deaths_smoothed;
	}
	public void setNew_deaths_smoothed(String new_deaths_smoothed) {
		this.new_deaths_smoothed = new_deaths_smoothed;
	}
	public String getTotal_cases_per_million() {
		return total_cases_per_million;
	}
	public void setTotal_cases_per_million(String total_cases_per_million) {
		this.total_cases_per_million = total_cases_per_million;
	}
	public String getNew_cases_per_million() {
		return new_cases_per_million;
	}
	public void setNew_cases_per_million(String new_cases_per_million) {
		this.new_cases_per_million = new_cases_per_million;
	}
	public String getNew_cases_smoothed_per_million() {
		return new_cases_smoothed_per_million;
	}
	public void setNew_cases_smoothed_per_million(String new_cases_smoothed_per_million) {
		this.new_cases_smoothed_per_million = new_cases_smoothed_per_million;
	}
	public String getTotal_deaths_per_million() {
		return total_deaths_per_million;
	}
	public void setTotal_deaths_per_million(String total_deaths_per_million) {
		this.total_deaths_per_million = total_deaths_per_million;
	}
	public String getNew_deaths_per_million() {
		return new_deaths_per_million;
	}
	public void setNew_deaths_per_million(String new_deaths_per_million) {
		this.new_deaths_per_million = new_deaths_per_million;
	}
	public String getNew_deaths_smoothed_per_million() {
		return new_deaths_smoothed_per_million;
	}
	public void setNew_deaths_smoothed_per_million(String new_deaths_smoothed_per_million) {
		this.new_deaths_smoothed_per_million = new_deaths_smoothed_per_million;
	}
	public String getReproduction_rate() {
		return reproduction_rate;
	}
	public void setReproduction_rate(String reproduction_rate) {
		this.reproduction_rate = reproduction_rate;
	}
	public String getIcu_patients() {
		return icu_patients;
	}
	public void setIcu_patients(String icu_patients) {
		this.icu_patients = icu_patients;
	}
	public String getIcu_patients_per_million() {
		return icu_patients_per_million;
	}
	public void setIcu_patients_per_million(String icu_patients_per_million) {
		this.icu_patients_per_million = icu_patients_per_million;
	}
	public String getHosp_patients() {
		return hosp_patients;
	}
	public void setHosp_patients(String hosp_patients) {
		this.hosp_patients = hosp_patients;
	}
	public String getHosp_patients_per_million() {
		return hosp_patients_per_million;
	}
	public void setHosp_patients_per_million(String hosp_patients_per_million) {
		this.hosp_patients_per_million = hosp_patients_per_million;
	}
	public String getWeekly_icu_admissions() {
		return weekly_icu_admissions;
	}
	public void setWeekly_icu_admissions(String weekly_icu_admissions) {
		this.weekly_icu_admissions = weekly_icu_admissions;
	}
	public String getWeekly_icu_admissions_per_million() {
		return weekly_icu_admissions_per_million;
	}
	public void setWeekly_icu_admissions_per_million(String weekly_icu_admissions_per_million) {
		this.weekly_icu_admissions_per_million = weekly_icu_admissions_per_million;
	}
	public String getWeekly_hosp_admissions() {
		return weekly_hosp_admissions;
	}
	public void setWeekly_hosp_admissions(String weekly_hosp_admissions) {
		this.weekly_hosp_admissions = weekly_hosp_admissions;
	}
	public String getWeekly_hosp_admissions_per_million() {
		return weekly_hosp_admissions_per_million;
	}
	public void setWeekly_hosp_admissions_per_million(String weekly_hosp_admissions_per_million) {
		this.weekly_hosp_admissions_per_million = weekly_hosp_admissions_per_million;
	}
	public String getTotal_tests() {
		return total_tests;
	}
	public void setTotal_tests(String total_tests) {
		this.total_tests = total_tests;
	}
	public String getNew_tests() {
		return new_tests;
	}
	public void setNew_tests(String new_tests) {
		this.new_tests = new_tests;
	}
	public String getTotal_tests_per_thousand() {
		return total_tests_per_thousand;
	}
	public void setTotal_tests_per_thousand(String total_tests_per_thousand) {
		this.total_tests_per_thousand = total_tests_per_thousand;
	}
	public String getNew_tests_per_thousand() {
		return new_tests_per_thousand;
	}
	public void setNew_tests_per_thousand(String new_tests_per_thousand) {
		this.new_tests_per_thousand = new_tests_per_thousand;
	}
	public String getNew_tests_smoothed() {
		return new_tests_smoothed;
	}
	public void setNew_tests_smoothed(String new_tests_smoothed) {
		this.new_tests_smoothed = new_tests_smoothed;
	}
	public String getNew_tests_smoothed_per_thousand() {
		return new_tests_smoothed_per_thousand;
	}
	public void setNew_tests_smoothed_per_thousand(String new_tests_smoothed_per_thousand) {
		this.new_tests_smoothed_per_thousand = new_tests_smoothed_per_thousand;
	}
	public String getPositive_rate() {
		return positive_rate;
	}
	public void setPositive_rate(String positive_rate) {
		this.positive_rate = positive_rate;
	}
	public String getTests_per_case() {
		return tests_per_case;
	}
	public void setTests_per_case(String tests_per_case) {
		this.tests_per_case = tests_per_case;
	}
	public String getTests_units() {
		return tests_units;
	}
	public void setTests_units(String tests_units) {
		this.tests_units = tests_units;
	}
	public String getTotal_vaccinations() {
		return total_vaccinations;
	}
	public void setTotal_vaccinations(String total_vaccinations) {
		this.total_vaccinations = total_vaccinations;
	}
	public String getPeople_vaccinated() {
		return people_vaccinated;
	}
	public void setPeople_vaccinated(String people_vaccinated) {
		this.people_vaccinated = people_vaccinated;
	}
	public String getPeople_fully_vaccinated() {
		return people_fully_vaccinated;
	}
	public void setPeople_fully_vaccinated(String people_fully_vaccinated) {
		this.people_fully_vaccinated = people_fully_vaccinated;
	}
	public String getNew_vaccinations() {
		return new_vaccinations;
	}
	public void setNew_vaccinations(String new_vaccinations) {
		this.new_vaccinations = new_vaccinations;
	}
	public String getNew_vaccinations_smoothed() {
		return new_vaccinations_smoothed;
	}
	public void setNew_vaccinations_smoothed(String new_vaccinations_smoothed) {
		this.new_vaccinations_smoothed = new_vaccinations_smoothed;
	}
	public String getTotal_vaccinations_per_hundred() {
		return total_vaccinations_per_hundred;
	}
	public void setTotal_vaccinations_per_hundred(String total_vaccinations_per_hundred) {
		this.total_vaccinations_per_hundred = total_vaccinations_per_hundred;
	}
	public String getPeople_vaccinated_per_hundred() {
		return people_vaccinated_per_hundred;
	}
	public void setPeople_vaccinated_per_hundred(String people_vaccinated_per_hundred) {
		this.people_vaccinated_per_hundred = people_vaccinated_per_hundred;
	}
	public String getPeople_fully_vaccinated_per_hundred() {
		return people_fully_vaccinated_per_hundred;
	}
	public void setPeople_fully_vaccinated_per_hundred(String people_fully_vaccinated_per_hundred) {
		this.people_fully_vaccinated_per_hundred = people_fully_vaccinated_per_hundred;
	}
	public String getNew_vaccinations_smoothed_per_million() {
		return new_vaccinations_smoothed_per_million;
	}
	public void setNew_vaccinations_smoothed_per_million(String new_vaccinations_smoothed_per_million) {
		this.new_vaccinations_smoothed_per_million = new_vaccinations_smoothed_per_million;
	}
	public String getStringency_index() {
		return stringency_index;
	}
	public void setStringency_index(String stringency_index) {
		this.stringency_index = stringency_index;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getPopulation_density() {
		return population_density;
	}
	public void setPopulation_density(String population_density) {
		this.population_density = population_density;
	}
	public String getMedian_age() {
		return median_age;
	}
	public void setMedian_age(String median_age) {
		this.median_age = median_age;
	}
	public String getAged_65_older() {
		return aged_65_older;
	}
	public void setAged_65_older(String aged_65_older) {
		this.aged_65_older = aged_65_older;
	}
	public String getAged_70_older() {
		return aged_70_older;
	}
	public void setAged_70_older(String aged_70_older) {
		this.aged_70_older = aged_70_older;
	}
	public String getGdp_per_capita() {
		return gdp_per_capita;
	}
	public void setGdp_per_capita(String gdp_per_capita) {
		this.gdp_per_capita = gdp_per_capita;
	}
	public String getExtreme_poverty() {
		return extreme_poverty;
	}
	public void setExtreme_poverty(String extreme_poverty) {
		this.extreme_poverty = extreme_poverty;
	}
	public String getCardiovasc_death_rate() {
		return cardiovasc_death_rate;
	}
	public void setCardiovasc_death_rate(String cardiovasc_death_rate) {
		this.cardiovasc_death_rate = cardiovasc_death_rate;
	}
	public String getDiabetes_prevalence() {
		return diabetes_prevalence;
	}
	public void setDiabetes_prevalence(String diabetes_prevalence) {
		this.diabetes_prevalence = diabetes_prevalence;
	}
	public String getFemale_smokers() {
		return female_smokers;
	}
	public void setFemale_smokers(String female_smokers) {
		this.female_smokers = female_smokers;
	}
	public String getMale_smokers() {
		return male_smokers;
	}
	public void setMale_smokers(String male_smokers) {
		this.male_smokers = male_smokers;
	}
	public String getHandwashing_facilities() {
		return handwashing_facilities;
	}
	public void setHandwashing_facilities(String handwashing_facilities) {
		this.handwashing_facilities = handwashing_facilities;
	}
	public String getHospital_beds_per_thousand() {
		return hospital_beds_per_thousand;
	}
	public void setHospital_beds_per_thousand(String hospital_beds_per_thousand) {
		this.hospital_beds_per_thousand = hospital_beds_per_thousand;
	}
	public String getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(String life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public String getHuman_development_index() {
		return human_development_index;
	}
	public void setHuman_development_index(String human_development_index) {
		this.human_development_index = human_development_index;
	}
	public CovidData(String continent, String location, String date, String total_cases, String new_cases,
			String new_cases_smoothed, String total_deaths, String new_deaths, String new_deaths_smoothed,
			String total_cases_per_million, String new_cases_per_million, String new_cases_smoothed_per_million,
			String total_deaths_per_million, String new_deaths_per_million, String new_deaths_smoothed_per_million,
			String reproduction_rate, String icu_patients, String icu_patients_per_million, String hosp_patients,
			String hosp_patients_per_million, String weekly_icu_admissions, String weekly_icu_admissions_per_million,
			String weekly_hosp_admissions, String weekly_hosp_admissions_per_million, String total_tests,
			String new_tests, String total_tests_per_thousand, String new_tests_per_thousand, String new_tests_smoothed,
			String new_tests_smoothed_per_thousand, String positive_rate, String tests_per_case, String tests_units,
			String total_vaccinations, String people_vaccinated, String people_fully_vaccinated,
			String new_vaccinations, String new_vaccinations_smoothed, String total_vaccinations_per_hundred,
			String people_vaccinated_per_hundred, String people_fully_vaccinated_per_hundred,
			String new_vaccinations_smoothed_per_million, String stringency_index, String population,
			String population_density, String median_age, String aged_65_older, String aged_70_older,
			String gdp_per_capita, String extreme_poverty, String cardiovasc_death_rate, String diabetes_prevalence,
			String female_smokers, String male_smokers, String handwashing_facilities,
			String hospital_beds_per_thousand, String life_expectancy, String human_development_index) {
		super();
		this.continent = continent;
		this.location = location;
		this.date = date;
		this.total_cases = total_cases;
		this.new_cases = new_cases;
		this.new_cases_smoothed = new_cases_smoothed;
		this.total_deaths = total_deaths;
		this.new_deaths = new_deaths;
		this.new_deaths_smoothed = new_deaths_smoothed;
		this.total_cases_per_million = total_cases_per_million;
		this.new_cases_per_million = new_cases_per_million;
		this.new_cases_smoothed_per_million = new_cases_smoothed_per_million;
		this.total_deaths_per_million = total_deaths_per_million;
		this.new_deaths_per_million = new_deaths_per_million;
		this.new_deaths_smoothed_per_million = new_deaths_smoothed_per_million;
		this.reproduction_rate = reproduction_rate;
		this.icu_patients = icu_patients;
		this.icu_patients_per_million = icu_patients_per_million;
		this.hosp_patients = hosp_patients;
		this.hosp_patients_per_million = hosp_patients_per_million;
		this.weekly_icu_admissions = weekly_icu_admissions;
		this.weekly_icu_admissions_per_million = weekly_icu_admissions_per_million;
		this.weekly_hosp_admissions = weekly_hosp_admissions;
		this.weekly_hosp_admissions_per_million = weekly_hosp_admissions_per_million;
		this.total_tests = total_tests;
		this.new_tests = new_tests;
		this.total_tests_per_thousand = total_tests_per_thousand;
		this.new_tests_per_thousand = new_tests_per_thousand;
		this.new_tests_smoothed = new_tests_smoothed;
		this.new_tests_smoothed_per_thousand = new_tests_smoothed_per_thousand;
		this.positive_rate = positive_rate;
		this.tests_per_case = tests_per_case;
		this.tests_units = tests_units;
		this.total_vaccinations = total_vaccinations;
		this.people_vaccinated = people_vaccinated;
		this.people_fully_vaccinated = people_fully_vaccinated;
		this.new_vaccinations = new_vaccinations;
		this.new_vaccinations_smoothed = new_vaccinations_smoothed;
		this.total_vaccinations_per_hundred = total_vaccinations_per_hundred;
		this.people_vaccinated_per_hundred = people_vaccinated_per_hundred;
		this.people_fully_vaccinated_per_hundred = people_fully_vaccinated_per_hundred;
		this.new_vaccinations_smoothed_per_million = new_vaccinations_smoothed_per_million;
		this.stringency_index = stringency_index;
		this.population = population;
		this.population_density = population_density;
		this.median_age = median_age;
		this.aged_65_older = aged_65_older;
		this.aged_70_older = aged_70_older;
		this.gdp_per_capita = gdp_per_capita;
		this.extreme_poverty = extreme_poverty;
		this.cardiovasc_death_rate = cardiovasc_death_rate;
		this.diabetes_prevalence = diabetes_prevalence;
		this.female_smokers = female_smokers;
		this.male_smokers = male_smokers;
		this.handwashing_facilities = handwashing_facilities;
		this.hospital_beds_per_thousand = hospital_beds_per_thousand;
		this.life_expectancy = life_expectancy;
		this.human_development_index = human_development_index;
	}

	public CovidData(String addString) {
		
		String[] arrayOfStrings = addString.split("/");
        
		this.continent 						= (arrayOfStrings.length >= 2) ? arrayOfStrings[1] : "null";
		this.location 						= (arrayOfStrings.length >= 3) ? arrayOfStrings[2] : "null";
		this.date 							= (arrayOfStrings.length >= 4) ? arrayOfStrings[3] : "null";
		this.total_cases 					= (arrayOfStrings.length >= 5) ? arrayOfStrings[4] : "null";
		this.new_cases 						= (arrayOfStrings.length >= 6) ? arrayOfStrings[5] : "null";
		this.new_cases_smoothed 			= (arrayOfStrings.length >= 7) ? arrayOfStrings[6] : "null";
		this.total_deaths 					= (arrayOfStrings.length >= 8) ? arrayOfStrings[7] : "null";
		this.new_deaths 					= (arrayOfStrings.length >= 9) ? arrayOfStrings[8] : "null";
		this.new_deaths_smoothed 			= (arrayOfStrings.length >= 10) ? arrayOfStrings[9] : "null";
		this.total_cases_per_million 		= (arrayOfStrings.length >= 11) ? arrayOfStrings[10] : "null";
		this.new_cases_per_million 			= (arrayOfStrings.length >= 12) ? arrayOfStrings[11] : "null";
		this.new_cases_smoothed_per_million = (arrayOfStrings.length >= 13) ? arrayOfStrings[12] : "null";
		this.total_deaths_per_million 		= (arrayOfStrings.length >= 14) ? arrayOfStrings[13] : "null";
		this.new_deaths_per_million 		= (arrayOfStrings.length >= 15) ? arrayOfStrings[14] : "null";
		this.new_deaths_smoothed_per_million= (arrayOfStrings.length >= 16) ? arrayOfStrings[15] : "null";
		this.reproduction_rate 				= (arrayOfStrings.length >= 17) ? arrayOfStrings[16] : "null";
		this.icu_patients 					= (arrayOfStrings.length >= 18) ? arrayOfStrings[17] : "null";
		this.icu_patients_per_million		= (arrayOfStrings.length >= 19) ? arrayOfStrings[18] : "null";
		this.hosp_patients					= (arrayOfStrings.length >= 20) ? arrayOfStrings[19] : "null";
		this.hosp_patients_per_million 		= (arrayOfStrings.length >= 21) ? arrayOfStrings[20] : "null";
		this.weekly_icu_admissions 				= (arrayOfStrings.length >= 22) ? arrayOfStrings[21] : "null";
		this.weekly_icu_admissions_per_million 	= (arrayOfStrings.length >= 23) ? arrayOfStrings[22] : "null";
		this.weekly_hosp_admissions	 			= (arrayOfStrings.length >= 24) ? arrayOfStrings[23] : "null";
		this.weekly_hosp_admissions_per_million = (arrayOfStrings.length >= 25) ? arrayOfStrings[24] : "null";
		this.new_tests 							= (arrayOfStrings.length >= 26) ? arrayOfStrings[26] : "null";
		this.total_tests 						= (arrayOfStrings.length >= 27) ? arrayOfStrings[25] : "null";
		this.total_tests_per_thousand 			= (arrayOfStrings.length >= 28) ? arrayOfStrings[27] : "null";
		this.new_tests_per_thousand 			= (arrayOfStrings.length >= 29) ? arrayOfStrings[28] : "null";
		this.new_tests_smoothed 				= (arrayOfStrings.length >= 30) ? arrayOfStrings[29] : "null";
		this.new_tests_smoothed_per_thousand	= (arrayOfStrings.length >= 31) ? arrayOfStrings[30] : "null";
		this.positive_rate 						= (arrayOfStrings.length >= 32) ? arrayOfStrings[31] : "null";
		this.tests_per_case 					= (arrayOfStrings.length >= 33) ? arrayOfStrings[32] : "null";
		this.tests_units 						= (arrayOfStrings.length >= 34) ? arrayOfStrings[33] : "null";
		this.total_vaccinations 				= (arrayOfStrings.length >= 35) ? arrayOfStrings[34] : "null";
		this.people_vaccinated 					= (arrayOfStrings.length >= 36) ? arrayOfStrings[35] : "null";
		this.people_fully_vaccinated 			= (arrayOfStrings.length >= 37) ? arrayOfStrings[36] : "null";
		this.new_vaccinations 					= (arrayOfStrings.length >= 38) ? arrayOfStrings[37] : "null";
		this.new_vaccinations_smoothed 			= (arrayOfStrings.length >= 39) ? arrayOfStrings[38] : "null";
		this.total_vaccinations_per_hundred 	= (arrayOfStrings.length >= 40) ? arrayOfStrings[39] : "null";
		this.people_vaccinated_per_hundred 		= (arrayOfStrings.length >= 41) ? arrayOfStrings[40] : "null";
		this.people_fully_vaccinated_per_hundred= (arrayOfStrings.length >= 42) ? arrayOfStrings[41] : "null";
		this.new_vaccinations_smoothed_per_million = (arrayOfStrings.length >= 43) ? arrayOfStrings[42] : "null";
		this.stringency_index 					   = (arrayOfStrings.length >= 44) ? arrayOfStrings[43] : "null";
		this.population 						   = (arrayOfStrings.length >= 45) ? arrayOfStrings[44] : "null";
		this.population_density 				   = (arrayOfStrings.length >= 46) ? arrayOfStrings[45] : "null";
		this.median_age 						   = (arrayOfStrings.length >= 47) ? arrayOfStrings[46] : "null";
		this.aged_65_older                         = (arrayOfStrings.length >= 48) ? arrayOfStrings[47] : "null";
		this.aged_70_older 						   = (arrayOfStrings.length >= 49) ? arrayOfStrings[48] : "null";
		this.gdp_per_capita						   = (arrayOfStrings.length >= 50) ? arrayOfStrings[49] : "null";
		this.extreme_poverty 					   = (arrayOfStrings.length >= 51) ? arrayOfStrings[50] : "null";
		this.cardiovasc_death_rate 				   = (arrayOfStrings.length >= 52) ? arrayOfStrings[51] : "null";
		this.diabetes_prevalence				   = (arrayOfStrings.length >= 53) ? arrayOfStrings[52] : "null";
		this.female_smokers                        = (arrayOfStrings.length >= 54) ? arrayOfStrings[53] : "null";
		this.male_smokers                          = (arrayOfStrings.length >= 55) ? arrayOfStrings[54] : "null";
		this.handwashing_facilities                = (arrayOfStrings.length >= 56) ? arrayOfStrings[55] : "null";
		this.hospital_beds_per_thousand            = (arrayOfStrings.length >= 57) ? arrayOfStrings[56] : "null";
		this.life_expectancy                       = (arrayOfStrings.length >= 58) ? arrayOfStrings[57] : "null";
		this.human_development_index               = (arrayOfStrings.length >= 59) ? arrayOfStrings[58] : "null";
	}
	public CovidData() {
		// TODO Auto-generated constructor stub
	}	
}
