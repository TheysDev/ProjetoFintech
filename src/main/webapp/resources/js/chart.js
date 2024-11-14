// Obtendo o contexto do canvas
document.addEventListener("DOMContentLoaded", () => {
    const ctx = document.getElementById("despesas").getContext("2d");

    // Criando o gráfico
    const myChart = new Chart(ctx, {
        type: "bar",
        data: {
            labels: [
                "Jan",
                "Fev",
                "Mar",
                "Abr",
                "Maio",
                "Jun",
                "Jul",
                "Ago",
                "Set",
                "Out",
                "Nov",
                "Des",
            ],
            datasets: [
                {
                    label: "Despesas em 2024",
                    data: [12, 19, 3, 5, 2, 3, 5, 2, 4, 6, 2, 4],
                    backgroundColor: "rgba(245, 66, 66, 1)",
                },
            ],
        },
        options: {
            indexAxis: "y",
            responsive: true,
            plugins: {
                legend: {
                    display: false,
                },
            },
            scales: {
                y: {
                    beginAtZero: true,
                },
            },
        },
    });
});

document.addEventListener("DOMContentLoaded", () => {
    const ctx = document.getElementById("resumo").getContext("2d");

    // Criando o gráfico
    const myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: ["Despesas", "Receita", "Investimentos"],
            datasets: [
                {
                    data: [60, 100, 70],
                    backgroundColor: [
                        "rgba(255, 99, 132, 1)",
                        "rgba(54, 162, 235, 1)",
                        "rgba(255, 206, 86, 1)",
                    ], // Cores dos segmentos
                    borderColor: [
                        "rgba(255, 99, 132, 1)",
                        "rgba(54, 162, 235, 1)",
                        "rgba(255, 206, 86, 1)",
                    ], // Cor das bordas
                    borderWidth: 1,
                },
            ],
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: "top",
                },
                tooltip: {
                    enabled: true,
                },
            },
        },
    });
});
