package com.covid.mapcovid.Model.Services;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.covid.mapcovid.Model.Entities.CovidData;

import com.covid.mapcovid.Interface.IWorkerFetchData;

public class WorkerFetchData implements Runnable {

	private IWorkerFetchData listCovidData;

	public WorkerFetchData(IWorkerFetchData listCovidData) {
		this.listCovidData = listCovidData;
	}

	@Override
	public void run() {
		try {
			List<CovidData> lista = new CsvReader().execute();
			
			lista.forEach((item) -> {
				this.listCovidData.setListCovidData(item);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
