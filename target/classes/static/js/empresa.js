// src/main/resources/static/js/empresa.js
document.addEventListener("DOMContentLoaded", function () {
  // Gráfico 1: Empresas por Sector (column)
  fetch('/api/empresa/ramo')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-sector', {
        chart: { type: 'column' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Empresas' } },
        series: [{ name: 'Empresas',  data: data.data.map(item => item.y) }]
      });
    });

  // Gráfico 2: Empresas por Distrito (bar)
  fetch('/api/empresa/distrito')
    .then(response => response.json())
    .then(data => {
      Highcharts.chart('chart-Distrito', {
        chart: { type: 'bar' },
        title: { text: null },
        xAxis: { categories: data.data.map(item => item.name) },
        yAxis: { title: { text: 'Nº de Empresas' } },
        series: [{ name: 'Empresas',  data: data.data.map(item => item.y) }]
      });
    });

  // TABELA 1: Vagas Publicadas por Empresa
  fetch('/api/empresa/vagas')
    .then(response => response.json())
    .then(data => {
      const tbody = document.querySelector('#table-vagas tbody');
      tbody.innerHTML = ''; // Limpa "Carregando..."

      if (data.data.length === 0) {
        tbody.innerHTML = '<tr><td colspan="2" style="text-align: center; color: #666;">Nenhuma empresa encontrada</td></tr>';
        return;
      }

      data.data.forEach(item => {
        const row = `
          <tr>
            <td>${item.name}</td>
            <td style="text-align: right;">${item.y}</td>
          </tr>
        `;
        tbody.insertAdjacentHTML('beforeend', row);
      });
    })
    .catch(() => {
      const tbody = document.querySelector('#table-vagas tbody');
      tbody.innerHTML = '<tr><td colspan="2" style="text-align: center; color: #dc3545;">Erro ao carregar dados</td></tr>';
    });

  // TABELA 2: Tamanho das Empresas
  fetch('/api/empresa/tamanho')
    .then(response => response.json())
    .then(data => {
      const tbody = document.querySelector('#table-tamanho tbody');
      tbody.innerHTML = ''; // Limpa "Carregando..."

      if (data.data.length === 0) {
        tbody.innerHTML = '<tr><td colspan="2" style="text-align: center; color: #666;">Nenhum dado disponível</td></tr>';
        return;
      }

      data.data.forEach(item => {
        const row = `
          <tr>
            <td>${item.name}</td>
            <td style="text-align: right;">${item.y}</td>
          </tr>
        `;
        tbody.insertAdjacentHTML('beforeend', row);
      });
    })
    .catch(() => {
      const tbody = document.querySelector('#table-tamanho tbody');
      tbody.innerHTML = '<tr><td colspan="2" style="text-align: center; color: #dc3545;">Erro ao carregar dados</td></tr>';
    });
});