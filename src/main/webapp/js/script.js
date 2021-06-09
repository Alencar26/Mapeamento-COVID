

$(document).ready(function(){
	
	var url = window.location;
	
  	$('[data-toggle="popover"]').popover();
	
	$("#bandeira").hide();
	$("#bandeira-sm").hide();
	$("#bandeira-md").hide();
	$(".naoMostrar").css("display","none");
	$(".footer").hide();
	
	$("#dataHoje").html(new Date(new Date().setDate(new Date().getDate()-1)).toLocaleDateString());
	
	var paisFinal = "";
	
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
	
	$("#pesquisaGrafico").blur(function(event) {
	
		var ultimosDias = event.target.value;

		var seletor = $("#selectPesquisa option:selected").val();
		
		if(seletor == "mes")
			ultimosDias = ultimosDias * 30;

		if(paisFinal == ""){
			getDataContinent(event, ultimosDias)
			chart.setTitle(seletor == "dia" ? { text: 'Gráfico - Últimos '+ ultimosDias +' dias'} : { text: 'Gráfico - Últimos '+ event.target.value +' meses' })
			
		}else{
			getData(paisFinal, ultimosDias);
		}
	});
	
	function procurarDados(array){
	
		let tamanho = array.length
		let continua = true
		let i = tamanho-1
		
		while(continua){
			
			 if(array[i].new_cases != "0" && array[i].new_cases != 0 && array[i].total_vaccinations != "null"){
			 	$("#hojeCasos").html(Number(array[i].new_cases).toLocaleString());
			 	continua = false;
			 }
			 
			 i--;
		}
		
		let continua_obitos = true
		let j = tamanho-1
					
		while(continua_obitos){
			
			 if(array[j].new_deaths != "0" && array[j].new_deaths != 0 && array[j].total_vaccinations != "null"){
			 	$("#hojeObitos").html(Number(array[j].new_deaths).toLocaleString());
			 	continua_obitos = false;
			 }
			 
			 j--;
		}
					
					
		let continua_vacinas = true
		let k = tamanho-1
		
		try{
			while(continua_vacinas){
				
				 if(array[k].new_vaccinations != "0" && array[k].new_vaccinations != 0 && array[k].new_vaccinations != "null" ){
				 	$("#hojeVacinas").html(Number(array[k].new_vaccinations).toLocaleString());
				 	continua_vacinas = false;
				 } 
				 k--;
			}
		} catch(e){
			k = tamanho-1
			
			while(continua_vacinas){
				
				 if(array[k].new_vaccinations_smoothed != "0" && array[k].new_vaccinations_smoothed != 0 && array[k].new_vaccinations_smoothed != "null" ){
				 	$("#hojeVacinas").html(Number(array[k].new_vaccinations_smoothed).toLocaleString());
				 	continua_vacinas = false;
				 } 
				 k--;
			}
		}
		
		let continua_doses = true
		let m = tamanho-1
		
		while(continua_doses){
			
			 if(array[m].people_vaccinated != "0" && array[m].people_vaccinated != 0 && array[m].people_vaccinated != "null" ){
			 	$("#totalDoses").html(Number(array[m].total_vaccinations).toLocaleString());
			 	continua_doses = false;
			 } 
			 m--;
		}
		
		
		let continua_total = true
		let n = tamanho-1
		
		while(continua_total){
			
			 if(array[n].total_vaccinations != "0" && array[n].total_vaccinations != 0 && array[n].total_vaccinations != "null" ){
			 	$("#totalVacinados").html(Number(array[n].people_vaccinated).toLocaleString());
			 	continua_total = false;
			 } 
			 n--;
		}
		
		let continua_imunizados = true
		let o = tamanho-1
		
		while(continua_imunizados){
			
			 if(array[o].people_fully_vaccinated != "0" && array[o].people_fully_vaccinated != 0 && array[o].people_fully_vaccinated != "null" ){
			 	$("#totalImunizados").html(Number(array[o].people_fully_vaccinated).toLocaleString());
			 	continua_imunizados = false;
			 } 
			 o--;
			  
			if(o == 0){
				$("#totalImunizados").html("Não informado");
				 continua_imunizados = false;
			}
		}
		
	}
	
	function ajaxPost(event){
	
		var formData = {}
		
		if(event.target.id == "FrenchGuiana"){
			formData = {name: 'French%20Guiana'}
			paisFinal = 'French%20Guiana'
		} else {
			formData = {name: event.target.id}
			paisFinal = event.target.id
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
					console.log(result)
					var porcentagemCasos = parseFloat((result.cases * 100) / result.population).toFixed(2);
					var porcentagemAtivos = parseFloat((result.active * 100) / result.cases).toFixed(2);
					var porcentagemCriticos = parseFloat((result.critical * 100) / result.active).toFixed(2);
					var porcentagemObitos = parseFloat((result.deaths * 100) / result.cases).toFixed(2);
					var porcentagemRecuperados = parseFloat((result.recovered * 100) / result.cases).toFixed(2);
					var porcentagemTestes = parseFloat((result.tests * 100) / result.population).toFixed(2);
				
					
					$("#totalCasos").html(result.cases.toLocaleString());
					$("#porcentagemCasos").html(porcentagemCasos + " %");
					
					$("#totalAtivos").html(result.active.toLocaleString());
					$("#porcentagemAtivos").html(porcentagemAtivos + " %");
					
					$("#totalObitos").html(result.deaths.toLocaleString());
					$("#porcentagemObitos").html(porcentagemObitos + " %");
					
					$("#totalRecuperados").html(result.recovered.toLocaleString());
					$("#porcentagemRecuperados").html(porcentagemRecuperados + " %");
					
					$("#nomePais, #nomePais-sm, #nomePais-md").html(nomeObj.name);
					$("#bandeira, #bandeira-sm, #bandeira-md").show();
					$("#bandeira").attr('src',result.countryInfo.flag);
					$("#bandeira-sm").attr('src',result.countryInfo.flag);
			        $("#bandeira-md").attr('src',result.countryInfo.flag);
					$("#populacao").html(result.population.toLocaleString());
					$("#totalTestes").html(result.tests.toLocaleString());
					$("#porcentagemTestes").html(porcentagemTestes + " %");
					
					$("#totalCriticos").html(result.critical.toLocaleString());
					$("#porcentagemCriticos").html(porcentagemCriticos + " %");

					$(".footer").show();
					let array = result.covidData
				
					procurarDados(array)
					
					$(".naoMostrar").css("display","block");
					$(".naoMostrar").css("height","87px");
					
					if(result.oneCasePerPeople <= 20){
                        $("#situacao").html("1 caso a cada "+result.oneCasePerPeople+" pessoas");
                        $("#situacao").css("color", "red");
                       	$("#"+event.target.id).css("fill", "#c62828");
                       	
                    } else if(result.oneCasePerPeople >= 21 && result.oneCasePerPeople <= 50){
                        $("#situacao").html("1 caso a cada "+result.oneCasePerPeople+" pessoas");
                        $("#situacao").css("color", "#F5CA7B");
                        $("#"+event.target.id).css("fill", "#F5CA7B");
                    } else {
                        $("#situacao").html("1 caso a cada "+result.oneCasePerPeople+" pessoas");
                        $("#situacao").css("color", "#5BC1AE");
                         $("#"+event.target.id).css("fill", "#5BC1AE");
                    }
                    
                    getData(event.target.id, 0)
					
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
		zoomType: 'x',
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
	function getData(stringPais, lastDays) {
	
		var ultimosDias = lastDays;

		var seletor = $("#selectPesquisa option:selected").val();
		
		if(seletor == "mes")
			ultimosDias = ultimosDias / 30;

		console.log(lastDays)
		
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
		
		if(lastDays == 0 || ultimosDias == 0){
			lastDays = 30
			ultimosDias = 1
		}
			
		chart.setTitle(seletor == "dia" ? { text: 'Gráfico - Últimos '+ lastDays +' dias'} : { text: 'Gráfico - Últimos '+ ultimosDias +' meses' })
		
		
	    fetch('https://disease.sh/v3/covid-19/historical/'+pais+'?lastdays='+lastDays).then(function(response) {
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
		   	  
		  }
	   	 	
	    })
	  
	}

	function sortfunction(a, b){
	  return (a.x - b.x) //faz com que o array seja ordenado numericamente e de ordem crescente.
	}
	
	function getDataContinent(event, lastDays) {
	
	
		console.log(lastDays)
		 var nomePais = [] 
		 
		 for(var element in objPais){		 
		 	nomePais.push(objPais[element].id)
		 }
		 
		 if(lastDays == 0){
			lastDays = 30
		 }
		
		 fetch('https://disease.sh/v3/covid-19/historical/'+nomePais+'?lastdays='+lastDays).then(function(response) {
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
			   	  	index.y += totalRecuperados[prop] 			   	  
			   	  }
			   	  
			   	  
	    		}
	    	}
	    	
	    	    	
    	  arrayTotalCasos = arrayTotalCasos.sort(sortfunction)
	   	  arrayTotalObitos = arrayTotalObitos.sort(sortfunction)
	   	  arrayTotalRecuperados = arrayTotalRecuperados.sort(sortfunction)
	   	  	   	  		   	  	   	  
	   	  chart.series[0].setData(arrayTotalCasos),
	   	  chart.series[1].setData(arrayTotalObitos),
	   	  chart.series[2].setData(arrayTotalRecuperados)
	   	  
	    })
	}
	
})