package com.covid.mapcovid.Model.Enums;

public enum Countries{

    Argentina("Argentina"),
    Brazil("Brasil"),
    Bolivia("Bolívia"),
    Chile("Chile"),
    Colombia("Colômbia"),
    Ecuador("Equador"),
    FalklandIslandsMalvinas("Ilhas Malvinas"),
    FrenchGuiana("Guiana Francesa"),
    Guyana("Guiana"),
    Paraguay("Paraguai"),
    Peru("Peru"),
    Suriname("Suriname"),
    Uruguay("Uruguai"),
    Venezuela("Venezuela");

    private String country;
	
	Countries(String country){
		this.country = country;
	}
	
	public String getCountries() {
		return country;
	}
}
