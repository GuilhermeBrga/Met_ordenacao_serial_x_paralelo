Integrantes:

    João Guilherme Braga Nascimento / 2210285
    Miguel Tacchi / 2310356

Link para o GitHub:

# Resumo:

Este trabalho propõe uma análise detalhada do desempenho de diferentes algoritmos de busca em ambientes seriais e paralelos, utilizando a linguagem de programação Java. A busca por eficiência computacional é essencial em diversas aplicações, e entender como diferentes algoritmos se comportam em diferentes cenários de processamento é de suma importância. Neste estudo, serão abordados quatro algoritmos de busca populares (Insertion Sort, Bubble Sort, Quick Sort e Selection Sort), tanto em suas implementações sequenciais quanto em versões paralelizadas. Serão realizadas análises comparativas utilizando uma variedade de conjuntos de dados de entrada e ajustando o número de núcleos de processamento. Os resultados serão registrados em arquivos CSV, permitindo uma análise visual através de gráficos ou processamento adicional utilizando Java. 

# Introdução:

A evolução dos sistemas multicore e o aumento da demanda por desempenho computacional tornam essencial o estudo do comportamento de algoritmos em ambientes concorrentes e paralelos. Este trabalho tem como foco analisar o desempenho de quatro algoritmos de ordenação (Bubble Sort, Quick Sort, Selection Sort e Insertion Sort), implementados em Java, avaliando suas versões sequenciais e paralelas. Serão explorados métodos clássicos de ordenação, buscando compreender os impactos do paralelismo no tempo de execução e eficiência geral, especialmente em diferentes tamanhos de conjuntos de dados. A metodologia de teste e os resultados obtidos fornecem uma base para a otimização de sistemas que lidam com grandes volumes de dados. 

# Metodologia:

A metodologia adotada envolve a implementação dos algoritmos de ordenação em Java, tanto em versões sequenciais quanto paralelas, utilizando boas práticas de programação concorrente. Foi desenvolvido um framework de teste para variar o tamanho e a complexidade dos conjuntos de dados, de modo a analisar o comportamento sob diferentes condições. Os quatro algoritmos implementados para análise comparativa incluem: Bubble Sort, Quick Sort, Selection Sort e Insertion Sort. As execuções são realizadas em ambiente controlado, com variação do número de threads (2, 4, 6, 8, 10) e de núcleos disponíveis. Foram coletadas cinco amostras de cada execução para garantir a estabilidade dos dados. Os tempos de execução e métricas relevantes são registrados em arquivos CSV, que posteriormente são analisados estatisticamente para identificar padrões de desempenho e subsidiar a discussão. 

# Resultados e discussão:

Os resultados das execuções serão comparados entre as versões seriais e paralelas, considerando o tamanho e natureza dos conjuntos de dados, variação do número de threads e a média de cinco amostras por execução, conforme detalhado na Metodologia. Os dados coletados são aqui apresentados por meio de gráficos comparativos, permitindo a visualização clara do impacto do paralelismo no desempenho de cada algoritmo.

## Bubble Sort:


| Tamanho dos dados | Tempo serial | Tempo paralelo (2 threads) | Tempo paralelo (4 threads) | Tempo paralelo (6 threads) | Tempo paralelo (8 threads) | Tempo paralelo (10 threads) |
|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
|    5000   | 41 ms   | 1116 ms   |  1447 ms    | 2357 ms   |  2916 ms  |  3431 ms  |
|   50000   | 4138 ms   | 11457 ms | 15420 ms   | 21987 ms  | 32939 ms  | 37864 ms  |
|   100000  | 19580 ms  | 27943 ms | 35407 ms  | 57129 ms  | 75300 ms   | 91515 ms  |
|   500000  | 41591 ms  | 207364 ms | 194635 ms | 223186 ms | 223186 ms | 304943 ms |
|  1000000  | 1774150 ms | 686890 ms | 594364 ms | 648869 ms | 754694 ms | 3033221 ms|    

## Insertion Sort:

| Tamanho dos dados | Tempo serial | Tempo paralelo (2 threads) | Tempo paralelo (4 threads) | Tempo paralelo (6 threads) | Tempo paralelo (8 threads) | Tempo paralelo (10 threads) |
|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
| 5000 |	13 ms	|10 ms	|19 ms|	2 ms 	|0 ms|	0 ms|
| 50000	|512 ms|	127 ms	|46 ms	|28 ms	|26 ms|	18 ms|
| 100000|	4234 ms	|1063 ms|	246 ms|	142 ms|	82 ms|	65 ms|
| 500000|	35270 ms|	9111 ms|	2376 ms|	1167 ms|	824 ms|	725 ms|
| 1000000|	254810 ms|	59256 ms|	18082 ms|	10173 ms|	7668 ms|	5295 ms|

## Quick Sort:

| Tamanho dos dados | Tempo serial | Tempo paralelo (2 threads) | Tempo paralelo (4 threads) | Tempo paralelo (6 threads) | Tempo paralelo (8 threads) | Tempo paralelo (10 threads) |
|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
|5000|	0 ms|	0 ms|	0 ms|	0 ms|	7 ms|	0 ms|
|50000|	11 ms|	17 ms|	3 ms|	3 ms|	3 ms|	2 ms|
|100000|	27 ms|	17 ms|	16 ms|	0 ms|	9 ms|	7 ms|
|500000|	35 ms|	27 ms|	12 ms|	10 ms|	8 ms|	9 ms|
|1000000|	112 ms| 	81 ms|	46 ms|	35 ms|	35 ms|	27 ms|

## Selection Sort:

| Tamanho dos dados | Tempo serial | Tempo paralelo (2 threads) | Tempo paralelo (4 threads) | Tempo paralelo (6 threads) | Tempo paralelo (8 threads) | Tempo paralelo (10 threads) |
|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
|5000|	34 ms|	19 ms|	18 ms|	5 ms|	0 ms|	0 ms|
|50000|	957 ms|	297 ms|	95 ms|	30 ms|	24 ms|	18 ms|
|100000|	7769 ms|	2290 ms|	601 ms|	133 ms|	106 ms|	76 ms|
|500000|	84670 ms|	21451 ms|	5646 ms| 	1231 ms|	764 ms|	633 ms|
|1000000|		655314 ms| 	162774 ms| 	54123 ms|11438 ms|	7073 ms| 	4999 ms|



