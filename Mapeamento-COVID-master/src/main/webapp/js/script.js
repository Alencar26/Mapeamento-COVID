

$(document).ready(function(){
	
	var url = window.location;
	
	$("#bandeira").hide();
	$("#bandeira-sm").hide();
	$("#bandeira-md").hide();
	
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
		
		$(".mapdiv path").css("fill", "#191A1A");
		
		
		$.ajax({
				type : "POST",
				contentType : "application/json",
				url : url + "countryJSON",
				data : JSON.stringify(formData),
				dataType : "json",
				success : function(result) {
					$("#totalCasos").html(result.cases.toLocaleString());
					$("#percentInfec").html(result.cases.toLocaleString());
					$("#totalAtivos").html(result.active.toLocaleString());
					$("#percentAtiv").html(result.active.toLocaleString());
					$("#totalObitos").html(result.deaths.toLocaleString());
					$("#totalRecuperados").html(result.recovered.toLocaleString());
					$("#nomePais, #nomePais-sm, #nomePais-md").html(nomeObj.name);
					$("#bandeira, #bandeira-sm, #bandeira-md").show();
					$("#bandeira").attr('src',result.countryInfo.flag);
					$("#bandeira-sm").attr('src',result.countryInfo.flag);
			        $("#bandeira-md").attr('src',result.countryInfo.flag);
					$("#populacao").html(result.population.toLocaleString());
					$("#totalTestes").html(result.tests.toLocaleString());
					$("#totalCriticos").html(result.critical.toLocaleString());
					console.log(result)

					
					$("#hojeCasos").html(result.todayCases.toLocaleString());
					$("#hojeObitos").html(result.todayDeaths.toLocaleString());
					$("#hojeRecuperados").html(result.todayRecovered.toLocaleString());
					
					if(result.casesPerOneMillion >= 50000){
                        $("#situacao").html("Alta");
                        $("#situacao").css("color", "red");
                       	$("#"+event.target.id).css("fill", "#c62828");
                    } else if(result.casesPerOneMillion >= 40000){
                        $("#situacao").html("Constante");
                        $("#situacao").css("color", "#F5CA7B");
                        $("#"+event.target.id).css("fill", "#F5CA7B");
                    } else {
                        $("#situacao").html("Baixo");
                        $("#situacao").css("color", "#5BC1AE");
                         $("#"+event.target.id).css("fill", "#5BC1AE");
                    }
					
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});
	}

})