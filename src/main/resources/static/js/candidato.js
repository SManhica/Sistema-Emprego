// src/main/resources/static/js/candidato.js
document.addEventListener("DOMContentLoaded", function () {
  fetch('/api/candidato/genero')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-genero', {
        chart: { type: 'pie' },
        title: { text: null },
        series: [{
          name: 'Candidatos',
          colorByPoint: true,
          data: data.data.map(item => ({ name: item.name, y: item.y }))
        }]
      });
    });

  fetch('/api/candidato/idade')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-idade', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { type: 'category' },
        yAxis: { title: { text: 'Nº de Candidatos' } },
        series: [{ name: 'Faixa Etária', data: data.data.map(item => ({ name: item.name, y: item.y })) }]
      });
    });

  fetch('/api/candidato/distrito')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-cidade', {
        chart: { type: 'bar' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Candidatos' } },
        series: [{ name: 'Distrito', data: data.data.map(item => item.y) }]
      });
    });

  fetch('/api/candidato/formacao')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-formacao', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { type: 'category' },
        yAxis: { title: { text: 'Nº de Candidatos' } },
        series: [{ name: 'Formação', data: data.data.map(item => ({ name: item.name, y: item.y })) }]
      });
    });
});