package com.covid.mapcovid.useCase;

import java.util.ArrayList;
import java.util.List;

import com.covid.mapcovid.Interface.IWorkerFetchData;
import com.covid.mapcovid.Model.Entities.CovidData;
import com.covid.mapcovid.Model.Services.WorkerFetchData;

public class CovidDataUseCase implements IWorkerFetchData{

	private List<CovidData> listCovidData = new ArrayList<CovidData>();

	public List<CovidData> execute() throws InterruptedException {
		
		Thread threadUm = this.initializesFetchData();
		
		threadUm.join();
		
		System.out.println(listCovidData.size());
		return listCovidData;
	}

	private Thread initializesFetchData() {
		Thread thread = new Thread(new WorkerFetchData(this));
		thread.start();
		return thread;
	}

	public synchronized void setListCovidData (CovidData covidData) {
		this.listCovidData.add(covidData);
	}
	
	public synchronized List<CovidData> getListCovidData () {
		return this.listCovidData;
	}
	

}
