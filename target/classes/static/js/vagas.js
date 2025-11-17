// src/main/resources/static/js/vagas.js
document.addEventListener("DOMContentLoaded", function () {
  fetch('/api/vaga/sector')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-vagas-sector', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { type: 'category' },
        yAxis: { title: { text: 'Número de Vagas' } },
        series: [{ name: 'Vagas', data: data.data.map(item => ({ name: item.name, y: item.y })) }]
      });
    });

  fetch('/api/vaga/estado-tabela')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-vagas-estado-tabela', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { type: 'category' },
        yAxis: { title: { text: 'Número de Vagas' } },
        series: [{ name: 'Vagas', data: data.data.map(item => item.y) }],
        exporting: { showTable: true }
      });
    });

  fetch('/api/vaga/mes')
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

  fetch('/api/vaga/estado')
    .then(response => response.json())
    .then(data => {
      const colorsEstado = {
        'Ativas': '#28a745',
        'Fechadas': '#dc3545',
        'Pendente': '#ffc107'
      };
      Highcharts.chart('chart-vagas-estado', {
        chart: { type: 'pie' },
        title: { text: null },
        plotOptions: {
          pie: {
            colors: Object.keys(colorsEstado).map(key => colorsEstado[key])
          }
        },
        series: [{
          name: 'Vagas',
          data: data.data.map(item => ({ name: item.name, y: item.y }))
        }]
      });
    });
});