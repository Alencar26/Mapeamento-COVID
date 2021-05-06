package com.covid.mapcovid.Model.Entities;

import java.util.Arrays;

public class Continent {


       private String [] countries = new String [13];
       
	    private float updated;
	    private ContinentInfo continentInfo;
	    private float cases;
	    private float todayCases;
	    private float deaths;
	    private float todayDeaths;
	    private float recovered;
	    private float todayRecovered;
	    private float active;
	    private float critical;
	    private float casesPerOneMillion;
	    private float deathsPerOneMillion;
	    private float tests;
	    private float testsPerOneMillion;
	    private float population;
	    private String continent;
	    private int oneCasePerPeople;
	    private int oneDeathPerPeople;
	    private int oneTestPerPeople;
	    private float activePerOneMillion;
	    private float recoveredPerOneMillion;
	    private float criticalPerOneMillion;

	    public Continent() {
	    	
	    	
	    }

	    public Continent(String [] countries, float updated, ContinentInfo continentInfo, float cases, float todayCases, float deaths, float todayDeaths, float recovered, float todayRecovered, float active, float critical, float casesPerOneMillion, float deathsPerOneMillion, float tests, float testsPerOneMillion, float population, String continent, int oneCasePerPeople, int oneDeathPerPeople, int oneTestPerPeople, float activePerOneMillion, float recoveredPerOneMillion, float criticalPerOneMillion) {
	        this.countries = countries;
	    	this.updated = updated;
	        this.continentInfo = continentInfo;
	        this.cases = cases;
	        this.todayCases = todayCases;
	        this.deaths = deaths;
	        this.todayDeaths = todayDeaths;
	        this.recovered = recovered;
	        this.todayRecovered = todayRecovered;
	        this.active = active;
	        this.critical = critical;
	        this.casesPerOneMillion = casesPerOneMillion;
	        this.deathsPerOneMillion = deathsPerOneMillion;
	        this.tests = tests;
	        this.testsPerOneMillion = testsPerOneMillion;
	        this.population = population;
	        this.continent = continent;
	        this.oneCasePerPeople = oneCasePerPeople;
	        this.oneDeathPerPeople = oneDeathPerPeople;
	        this.oneTestPerPeople = oneTestPerPeople;
	        this.activePerOneMillion = activePerOneMillion;
	        this.recoveredPerOneMillion = recoveredPerOneMillion;
	        this.criticalPerOneMillion = criticalPerOneMillion;
	    }

	    
	    public float getUpdated() {
	        return updated;
	    }

	    public void setUpdated(float updated) {
	        this.updated = updated;
	    }

	    public ContinentInfo getContinentInfo() {
	        return continentInfo;
	    }

	    public void setContinentInfo(ContinentInfo continentInfo) {
	        this.continentInfo = continentInfo;
	    }

	    public float getCases() {
	        return cases;
	    }

	    public void setCases(float cases) {
	        this.cases = cases;
	    }

	    public float getTodayCases() {
	        return todayCases;
	    }

	    public void setTodayCases(float todayCases) {
	        this.todayCases = todayCases;
	    }

	    public float getDeaths() {
	        return deaths;
	    }

	    public void setDeaths(float deaths) {
	        this.deaths = deaths;
	    }

	    public float getTodayDeaths() {
	        return todayDeaths;
	    }

	    public void setTodayDeaths(float todayDeaths) {
	        this.todayDeaths = todayDeaths;
	    }

	    public float getRecovered() {
	        return recovered;
	    }

	    public void setRecovered(float recovered) {
	        this.recovered = recovered;
	    }

	    public float getTodayRecovered() {
	        return todayRecovered;
	    }

	    public void setTodayRecovered(float todayRecovered) {
	        this.todayRecovered = todayRecovered;
	    }

	    public float getActive() {
	        return active;
	    }

	    public void setActive(float active) {
	        this.active = active;
	    }

	    public float getCritical() {
	        return critical;
	    }

	    public void setCritical(float critical) {
	        this.critical = critical;
	    }

	    public float getCasesPerOneMillion() {
	        return casesPerOneMillion;
	    }

	    public void setCasesPerOneMillion(float casesPerOneMillion) {
	        this.casesPerOneMillion = casesPerOneMillion;
	    }

	    public float getDeathsPerOneMillion() {
	        return deathsPerOneMillion;
	    }

	    public void setDeathsPerOneMillion(float deathsPerOneMillion) {
	        this.deathsPerOneMillion = deathsPerOneMillion;
	    }

	    public float getTests() {
	        return tests;
	    }

	    public void setTests(float tests) {
	        this.tests = tests;
	    }

	    public float getTestsPerOneMillion() {
	        return testsPerOneMillion;
	    }

	    public void setTestsPerOneMillion(float testsPerOneMillion) {
	        this.testsPerOneMillion = testsPerOneMillion;
	    }

	    public float getPopulation() {
	        return population;
	    }

	    public void setPopulation(float population) {
	        this.population = population;
	    }

	    public String getContinent() {
	        return continent;
	    }

	    public void setContinent(String continent) {
	        this.continent = continent;
	    }

	    public int getOneCasePerPeople() {
	        return oneCasePerPeople;
	    }

	    public void setOneCasePerPeople(int oneCasePerPeople) {
	        this.oneCasePerPeople = oneCasePerPeople;
	    }

	    public int getOneDeathPerPeople() {
	        return oneDeathPerPeople;
	    }

	    public void setOneDeathPerPeople(int oneDeathPerPeople) {
	        this.oneDeathPerPeople = oneDeathPerPeople;
	    }

	    public int getOneTestPerPeople() {
	        return oneTestPerPeople;
	    }

	    public void setOneTestPerPeople(int oneTestPerPeople) {
	        this.oneTestPerPeople = oneTestPerPeople;
	    }

	    public float getActivePerOneMillion() {
	        return activePerOneMillion;
	    }

	    public void setActivePerOneMillion(float activePerOneMillion) {
	        this.activePerOneMillion = activePerOneMillion;
	    }

	    public float getRecoveredPerOneMillion() {
	        return recoveredPerOneMillion;
	    }

	    public void setRecoveredPerOneMillion(float recoveredPerOneMillion) {
	        this.recoveredPerOneMillion = recoveredPerOneMillion;
	    }

	    public float getCriticalPerOneMillion() {
	        return criticalPerOneMillion;
	    }

	    public void setCriticalPerOneMillion(float criticalPerOneMillion) {
	        this.criticalPerOneMillion = criticalPerOneMillion;
	        
	    }

		@Override
		public String toString() {
			return "Continent [countries=" + Arrays.toString(countries) + ", updated=" + updated + ", continentInfo="
					+ continentInfo + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths=" + deaths
					+ ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", todayRecovered=" + todayRecovered
					+ ", active=" + active + ", critical=" + critical + ", casesPerOneMillion=" + casesPerOneMillion
					+ ", deathsPerOneMillion=" + deathsPerOneMillion + ", tests=" + tests + ", testsPerOneMillion="
					+ testsPerOneMillion + ", population=" + population + ", continent=" + continent
					+ ", oneCasePerPeople=" + oneCasePerPeople + ", oneDeathPerPeople=" + oneDeathPerPeople
					+ ", oneTestPerPeople=" + oneTestPerPeople + ", activePerOneMillion=" + activePerOneMillion
					+ ", recoveredPerOneMillion=" + recoveredPerOneMillion + ", criticalPerOneMillion="
					+ criticalPerOneMillion + "]";
			
			
		}
	}

