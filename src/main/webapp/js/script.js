

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
					$("#totalAtivos").html(result.active.toLocaleString());
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
	
	
	
	var options = {
	  chart: {
	    type: 'spline',
	    events: {
	    	load: getData
	    }
	  },
	  title: {
	    text: 'COVID-19'
	  },
	  subtitle: {
	    text: 'Total de Infectados, Óbitos e Recuperados'
	  },
	  xAxis: {
		  type: 'datetime',
		  labels: {
		    format: '{value:%d-%m-%Y}',
		}
	},
	yAxis: {
	    title: {
	      text: 'Total'
	    },
	    min: 0
	  },
	 tooltip: {
        shared: true,
        crosshairs: true
    },
	
	  plotOptions: {
	    series: {
	      marker: {
	        enabled: true
	      }
	    }
	  },
	
	  colors: ['#6CF', '#39F', '#06C', '#036', '#000'],
	  series: [
	  	{
		    name: "Total de Casos",
		    data: [],
	    },
	    {
		    name: "Total de Óbitos",
		    data: [] 
		},
		{
		    name: "Total de Recuperados",
		    data: [] 
		}
	  ],
	  responsive: {
		    rules: [{
		      condition: {
		        maxWidth: 700
		      },
		      chartOptions: {
		        plotOptions: {
		          series: {
		            marker: {
		              radius: 2.5
		            }
		          }
		        }
		      }
		    }]
		}
	};
	var chart = Highcharts.chart('container', options)
	
	// Data
	function getData() {
	    fetch('https://disease.sh/v3/covid-19/historical/brazil?lastdays=30').then(function(response) {
	      return response.json()
	    }).then(function(data) {
	    
	      var arrayTotalCasos = []	
	      var arrayTotalObitos = []	
	      var arrayTotalRecuperados = []	
	          
	   	  var totalCasos = data.timeline.cases
	   	  
	   	  for (var prop in totalCasos){
	   	  	var dateFinal = parseDate(prop)
	   	  	arrayTotalCasos.push({x: new Date(prop).getTime(),y: totalCasos[prop]}) 
	   	  }
	   	  
	   	  var totalObitos = data.timeline.deaths
	   	  
	   	  for (var prop in totalObitos){
	   	  	var dateFinal = parseDate(prop)
	   	  	arrayTotalObitos.push({x: new Date(prop).getTime(),y: totalObitos[prop]}) 
	   	  }
	   	  
	   	  var totalRecuperados = data.timeline.recovered
	   	  
	   	  for (var prop in totalRecuperados){
	   	  	var dateFinal = parseDate(prop)
	   	  	arrayTotalRecuperados.push({x: new Date(prop).getTime(),y: totalRecuperados[prop]}) 
	   	  }
	   	  	   	  
	   	  arrayTotalCasos = arrayTotalCasos.sort(sortfunction)
	   	  arrayTotalObitos = arrayTotalObitos.sort(sortfunction)
	   	  arrayTotalRecuperados = arrayTotalRecuperados.sort(sortfunction)
	   	  	   	  
	   	  chart.series[0].setData(arrayTotalCasos),
	   	  chart.series[1].setData(arrayTotalObitos),
	   	  chart.series[2].setData(arrayTotalRecuperados)
	   	  
	   	  
	   	  console.log(arrayTotalCasos)
	   	   console.log(arrayTotalObitos)
	   	  	   
	    })
	  
	}
	
	function parseDate(str)	{
	  var parts = str.split('/');
	  	  
	  return Date.UTC("20"+parts[2], parts[1] - 1, parts[0]); 
	}

	function sortfunction(a, b){
	  return (a.x - b.x) //faz com que o array seja ordenado numericamente e de ordem crescente.
	}
})