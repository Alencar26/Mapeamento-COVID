
# Mapeamento-COVID

Aplicação web em Java que tem como objetivo mostrar um dashboard dos casos da Covid-19 na América latina.

Projeto desenvolvido no 5° período do curso de Engenharia de Software, nas matérias de Programação Avançada, Prática Profissional com Dados e Prática Profissional em Engenharia de Software. 


![Logo](./mapeamento_covid.png)

    
## 

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)

  
## Tela do Projeto

![gif](http://g.recordit.co/YKfi6VqOKx.gif)

  
## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

  
## Tecnologias Utilizadas

**Frontend:** [JSP](https://www3.ntu.edu.sg/home/ehchua/programming/java/JSPByExample.html), [JQuery](https://jquery.com/), [Bootstrap](https://getbootstrap.com/), [Highcharts](https://www.highcharts.com/blog/products/highcharts/)

**Backend:** [Java](https://www.java.com/pt-BR/), [Spring Boot](https://spring.io/projects/spring-boot), [Tomcat](https://tomcat.apache.org/), [Gson](https://github.com/google/gson)

  
## Api Utilizada

No projeto em questão optamos pela [disease.sh](https://disease.sh/), uma API aberta focada em estatísticas relacionadas à doenças. 

Inclusive recomendada pelo Postman.

[Repositório](https://github.com/disease-sh/api) da disease-sh caso queira contribuir para esse magnífico projeto.

## Referências da API

#### Pegar informações na América do sul

```http
  GET https://corona.lmao.ninja/v2/continents/${continent}?yesterday&strict&query
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `continent` | `string` | **Obrigatório**. Informar o continente *South%20America*|

#### Pegar informação por país

```http
  GET https://corona.lmao.ninja/v2/countries/${county}?yesterday&strict&query
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `county`      | `string` | **Obrigatório**. Nome do país que deseja puxar informações |

#### Pegar informações de cada país por períodos

```http
  GET https://disease.sh/v3/covid-19/historical/${county}?lastdays=${lastdays}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `county`  | `string` | **Obrigatório**. Nome do país que deseja puxar informações |
| `lastdays`| `integer`| **Obrigatório**. Informe quantos dias atrás deseja-se puxar as informações|


  
## Autores

- [Júlia Louback](https://github.com/JuliaLouback)
- [André Alencar](https://github.com/Alencar26)
- [Leonardo Kamers](https://github.com/kamers07leo)
- [Júlio Ferens](https://github.com/julioferens)

  
## Licença

Este projeto está sob a licença [MIT](https://choosealicense.com/licenses/mit/)

  