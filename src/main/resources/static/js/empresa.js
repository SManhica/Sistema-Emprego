// src/main/resources/static/js/empresa.js
document.addEventListener("DOMContentLoaded", function () {
  fetch('/api/empresa/ramo')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-sector', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Empresas' } },
        series: [{ name: 'Empresas', data: data.data.map(item => item.y) }]
      });
    });

  fetch('/api/empresa/distrito')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-Distrito', {
        chart: { type: 'bar' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Empresas' } },
        series: [{ name: 'Empresas', data: data.data.map(item => item.y) }]
      });
    });

   fetch('/api/empresa/vagas')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-vagas', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Vagas' } },
        series: [{ name: 'Vagas',  data: data.data.map(item => item.y ) }],
        exporting: {
          showTable: true 
        }
      });
    });

  fetch('/api/empresa/tamanho')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-tamanho', {
        chart: { type: 'pie' },
        title: { text: null },
        series: [{
          name: 'Empresas',
          colorByPoint: true,
          data: data.data.map(item => ({ name: item.name, y: item.y }))
        }]
      });
    });
});