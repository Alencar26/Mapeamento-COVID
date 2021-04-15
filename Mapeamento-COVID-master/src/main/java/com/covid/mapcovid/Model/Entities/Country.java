package com.covid.mapcovid.Model.Entities;

import lombok.Data;

@Data
public class Country {

	private long updated;
	private String country;
	private CountryInfo countryInfo;
	private long cases;
	private long todayCases;
	private long deaths;
	private long todayDeaths;
	private long recovered;
	private long todayRecovered;
	private long active;
	private long critical;
	private long casesPerOneMillion;
	private long deathsPerOneMillion;
	private long tests;
	private long testsPerOneMillion;
	private long population;
	private String continent;
	private int oneCasePerPeople;
	private int oneDeathPerPeople;
	private int oneTestPerPeople;
	private float activePerOneMillion;
	private float recoveredPerOneMillion;
	private float criticalPerOneMillion;

	public Country() {
	}

	public Country(long updated, String country, CountryInfo countryInfo, long cases, long todayCases, long deaths,
			long todayDeaths, long recovered, long todayRecovered, long active, long critical, long casesPerOneMillion,
			long deathsPerOneMillion, long tests, long testsPerOneMillion, long population, String continent,
			int oneCasePerPeople, int oneDeathPerPeople, int oneTestPerPeople, float activePerOneMillion,
			float recoveredPerOneMillion, float criticalPerOneMillion) {
		this.updated = updated;
		this.country = country;
		this.countryInfo = countryInfo;
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
