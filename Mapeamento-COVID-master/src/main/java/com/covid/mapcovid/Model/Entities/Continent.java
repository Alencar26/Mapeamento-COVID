package com.covid.mapcovid.Model.Entities;

import java.util.Arrays;

import lombok.Data;

@Data
public class Continent {

	private String[] countries = new String[13];

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

	public Continent(String[] countries, float updated, ContinentInfo continentInfo, float cases, float todayCases,
			float deaths, float todayDeaths, float recovered, float todayRecovered, float active, float critical,
			float casesPerOneMillion, float deathsPerOneMillion, float tests, float testsPerOneMillion,
			float population, String continent, int oneCasePerPeople, int oneDeathPerPeople, int oneTestPerPeople,
			float activePerOneMillion, float recoveredPerOneMillion, float criticalPerOneMillion) {
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

	public String getPorcentagemInfec() {

		return (this.cases / this.population) * 100 + "%";
	}

	public Object getPorcentagemAtiv() {

		return (this.active / this.cases) * 100 + "%";
	}

	public Object getPorcentagemCritic() {

		return (this.critical / this.active) * 100 + "%";
	}

	public Object getPorcentagemObt() {

		return (this.deaths / this.cases) * 100 + "%";
	}

	public Object getPorcentagemRecup() {

		return (this.recovered / this.cases) * 100 + "%";
	}

}
