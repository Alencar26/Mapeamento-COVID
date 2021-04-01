

$(document).ready(function(){
	
	var url = window.location;
	
	var objPais = [
		{
			id: "Argentina",
			name: "Argentina"
		}, 
		{
			id: "Bolivia",
			name: "Bolívia"
		},
		{
			id: "Brazil",
			name: "Brasil"
		},
		{
			id: "Chile",
			name: "Chile"
		},
		{
			id: "Colombia",
			name: "Colômbia"
		},
		{
			id: "Ecuador",
			name: "Equador"
		},
		{
			id: "FrenchGuiana",
			name: "Guiana Francesa"
		},
			{
			id: "Guyana",
			name: "Guiana"
		},
			{
			id: "Peru",
			name: "Peru"
		},
		{
			id: "Paraguay",
			name: "Paraguai"
		},
		{
			id: "Suriname",
			name: "Suriname"
		},
		{
			id: "Uruguay",
			name: "Uruguai"
		},
		{
			id: "Venezuela",
			name: "Venezuela"
		}
	]
	
	
    $("#Argentina, #Bolivia, #Brazil, #Chile, #Colombia, #Ecuador, #FrenchGuiana, #Guyana, #Peru, #Paraguay, #Suriname, #Uruguay, #Venezuela").click(function(event) {
		ajaxPost(event);
	});
	
	
	function ajaxPost(event){
	
		var formData = {}
		
		if(event.target.id == "FrenchGuiana"){
			formData = {name: 'French%20Guiana'}
		} else {
			formData = {name: event.target.id}
		}
		
		var nomeObj = objPais.find(element => element.id == event.target.id);
		
		$.ajax({
				type : "POST",
				contentType : "application/json",
				url : url + "countryJSON",
				data : JSON.stringify(formData),
				dataType : "json",
				success : function(result) {
					$("#totalCasos").html(result.cases.toLocaleString());
					$("#totalAtivos").html(result.active.toLocaleString());
					$("#totalObitos").html(result.deaths.toLocaleString());
					$("#totalRecuperados").html(result.recovered.toLocaleString());
					$("#nomePais").html(nomeObj.name);
					$("#bandeira").attr('src',result.countryInfo.flag);
					$("#populacao").html(result.population.toLocaleString());
					
					
					console.log(result.countryInfo.flag)
					console.log(result)
					
					
							if(result.casesPerOneMillion >= 50000){
                        $("#situacao").html("Alta");
                    } else if(result.casesPerOneMillion >= 40000){
                        $("#situacao").html("Constante");
                    } else {
                        $("#situacao").html("Baixo");
                    }
					
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});
	}

})