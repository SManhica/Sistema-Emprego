// src/main/resources/static/js/dashboard.js
document.addEventListener("DOMContentLoaded", function () {
  fetch('/api/dashboard/vagas-por-sector')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-vagas-sector', {
        chart: { type: 'pie' },
        title: { text: null },
        series: [{
          name: 'Vagas',
          colorByPoint: true,
          data: data.data.map(item => ({ name: item.name, y: item.y }))
        }]
      });
    });

  fetch('/api/dashboard/candidatos-por-genero')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-genero', {
        chart: { type: 'pie' },
        title: { text: null },
        series: [{ name: 'Candidatos', data: data.data.map(item => ({ name: item.name, y: item.y })) }]
      });
    });

  fetch('/api/dashboard/vagas-por-mes')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-vagas-tempo', {
        chart: { type: 'line' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Vagas Publicadas' } },
        series: [{ name: 'Vagas', data: data.data.map(item => item.y) }]
      });
    });

  fetch('/api/dashboard/top-servicos')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-cidades', {
        chart: { type: 'bar' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Candidatos' } },
        series: [{ name: 'Candidatos', data: data.data.map(item => item.y) }]
      });
    });
});