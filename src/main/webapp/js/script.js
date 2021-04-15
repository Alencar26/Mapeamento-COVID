

$(document).ready(function(){
	
	var url = window.location;
	
	$("#bandeira").hide();
	$("#bandeira-sm").hide();
	$("#bandeira-md").hide();
	$("#dataHoje").html(new Date().toLocaleDateString());
	
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
                    
                    getData(event.target.id)
					
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
	    	load: getDataContinent
	    }
	  },
	  legend: {
        itemStyle: {
            color: 'white',
            fontWeight: 'bold'
        }
      },
      lang: {
      	contextButtonTitle: 'Exportar gráfico',
      	decimalPoint: ',',
        thousandsSep: '.',
      	downloadJPEG: 'Baixar imagem JPEG',
		downloadPDF: 'Baixar arquivo PDF',
		downloadPNG: 'Baixar imagem PNG',
		downloadSVG: 'Baixar vetor SVG',
		downloadCSV: 'Baixar arquivo CSV',
		downloadXLS: 'Baixar arquivo XLS',
		printChart: 'Imprimir gráfico',
		viewFullscreen: 'Visualizar Tela Cheia',
		viewData: 'Visualizar dados',
		hideData: 'Esconder dados'
      },
      navigation: {
        menuStyle: {
            background: '#E0E0E0'
        }
      },
      exporting: {
        buttons: {
            contextButton: {
                symbolStroke: "white",
                theme: {
            		fill:"#191A1A"
        		}
            }
        }
      },
	  title: {
	    text: 'COVID-19 - Últimos 30 dias'
	  },
	  subtitle: {
	    text: 'Total de Infectados, Óbitos e Recuperados'
	  },
	  xAxis: {
		  type: 'datetime',
		  labels: {
		    format: '{value:%d-%m-%Y}',
		    style: {
                color: 'white'
            }
		  },
		 
	},
	yAxis: {
	    title: {
	      text: 'Total'
	    },
	    labels: {
		    style: {
                color: 'white'
            }
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
	
	  colors: ['#C6A667', '#fa0103', '#5CC3B0', '#036', '#000'],
	  series: [
	  	{
		    name: "Total de Casos",
		    data: []
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
	function getData(stringPais) {
	
		var pais = ""
		
		if(stringPais.type != "load"){
			if(stringPais == "FrenchGuiana"){
				pais = 'French%20Guiana'
			} else {
				pais = stringPais
			}
		} else {
			pais = "Brazil"
		}
			
	    fetch('https://disease.sh/v3/covid-19/historical/'+pais+'?lastdays=30').then(function(response) {
	      return response.json()
	    }).then(function(data) {
	    
	      if(data.message){
	      
	      }else{
		      var arrayTotalCasos = []	
		      var arrayTotalObitos = []	
		      var arrayTotalRecuperados = []	
		          
		   	  var totalCasos = data.timeline.cases
		   	  
		   	  for (var prop in totalCasos){
		   	  	arrayTotalCasos.push({x: new Date(prop).getTime(),y: totalCasos[prop]}) 
		   	  }
		   	  
		   	  var totalObitos = data.timeline.deaths
		   	  
		   	  for (var prop in totalObitos){
		   	  	arrayTotalObitos.push({x: new Date(prop).getTime(),y: totalObitos[prop]}) 
		   	  }
		   	  
		   	  var totalRecuperados = data.timeline.recovered
		   	  
		   	  for (var prop in totalRecuperados){
		   	  	arrayTotalRecuperados.push({x: new Date(prop).getTime(),y: totalRecuperados[prop]}) 
		   	  }
		   	  	   	  
		   	  arrayTotalCasos = arrayTotalCasos.sort(sortfunction)
		   	  arrayTotalObitos = arrayTotalObitos.sort(sortfunction)
		   	  arrayTotalRecuperados = arrayTotalRecuperados.sort(sortfunction)
		   	  	   	  		   	  	   	  
		   	  chart.series[0].setData(arrayTotalCasos),
		   	  chart.series[1].setData(arrayTotalObitos),
		   	  chart.series[2].setData(arrayTotalRecuperados)
		   	  
		   	  console.log(objPais)
		  }
	   	 	
	    })
	  
	}

	function sortfunction(a, b){
	  return (a.x - b.x) //faz com que o array seja ordenado numericamente e de ordem crescente.
	}
	
	function getDataContinent() {
	
		 var nomePais = [] 
		 
		 for(var element in objPais){		 
		 	nomePais.push(objPais[element].id)
		 }
		
		 fetch('https://disease.sh/v3/covid-19/historical/'+nomePais+'?lastdays=30').then(function(response) {
	      return response.json()
	    }).then(function(data) {
	    
	     	var arrayTotalCasos = []	
		    var arrayTotalObitos = []	
		    var arrayTotalRecuperados = []	
	    	
	    	
	    	for(var element in data[0].timeline.cases){
	    			arrayTotalCasos.push({x: new Date(element).getTime(),y: 0}) 
	    			arrayTotalObitos.push({x: new Date(element).getTime(),y: 0}) 	
	    			arrayTotalRecuperados.push({x: new Date(element).getTime(),y: 0}) 	
	    	}
	    	
	    	for(var element in data){
	   			
	   			dataCountry = data[element]
	   		
	    		if(dataCountry != null){
	    		
	    		  var totalCasos = dataCountry.timeline.cases
		   	  
			   	  for (var prop in totalCasos){
			   	  	 var index = arrayTotalCasos.find(elements => elements.x == new Date(prop).getTime())
			   	  	 index.y += totalCasos[prop] 
			   	  }
			   	    
			   	  var totalObitos = dataCountry.timeline.deaths
			   	  
			   	  for (var prop in totalObitos){
			   	  	 var index = arrayTotalObitos.find(elements => elements.x == new Date(prop).getTime())
			   	  	 index.y += totalObitos[prop] 
			   	  }
			   	  
			   	  var totalRecuperados = dataCountry.timeline.recovered
			   	  
			   	  for (var prop in totalRecuperados){
 					var index = arrayTotalRecuperados.find(elements => elements.x == new Date(prop).getTime())
			   	  	index.y += totalRecuperados[prop] 			   	  }
			   	  
			   	  
	    		}
	    	}
	    	
	    	
	    	console.log(arrayTotalCasos)
	    	
	    	  arrayTotalCasos = arrayTotalCasos.sort(sortfunction)
		   	  arrayTotalObitos = arrayTotalObitos.sort(sortfunction)
		   	  arrayTotalRecuperados = arrayTotalRecuperados.sort(sortfunction)
		   	  	   	  		   	  	   	  
		   	  chart.series[0].setData(arrayTotalCasos),
		   	  chart.series[1].setData(arrayTotalObitos),
		   	  chart.series[2].setData(arrayTotalRecuperados)
		   	  
	    })
	}
	
})