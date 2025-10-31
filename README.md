Integrantes:

    João Guilherme Braga Nascimento / 2210285
    Miguel Tacchi / 2310356

Link para o GitHub:

## Resumo:

Este trabalho propõe uma análise detalhada do desempenho de diferentes algoritmos de busca em ambientes seriais e paralelos, utilizando a linguagem de programação Java. A busca por eficiência computacional é essencial em diversas aplicações, e entender como diferentes algoritmos se comportam em diferentes cenários de processamento é de suma importância. Neste estudo, serão abordados quatro algoritmos de busca populares (Insertion Sort, Bubble Sort, Quick Sort e Selection Sort), tanto em suas implementações sequenciais quanto em versões paralelizadas. Serão realizadas análises comparativas utilizando uma variedade de conjuntos de dados de entrada e ajustando o número de núcleos de processamento. Os resultados serão registrados em arquivos CSV, permitindo uma análise visual através de gráficos ou processamento adicional utilizando Java. 

## Introdução:

A evolução dos sistemas multicore e o aumento da demanda por desempenho computacional tornam essencial o estudo do comportamento de algoritmos em ambientes concorrentes e paralelos. Este trabalho tem como foco analisar o desempenho de quatro algoritmos de ordenação (Bubble Sort, Quick Sort, Selection Sort e Insertion Sort), implementados em Java, avaliando suas versões sequenciais e paralelas. Serão explorados métodos clássicos de ordenação, buscando compreender os impactos do paralelismo no tempo de execução e eficiência geral, especialmente em diferentes tamanhos de conjuntos de dados. A metodologia de teste e os resultados obtidos fornecem uma base para a otimização de sistemas que lidam com grandes volumes de dados. 

## Metodologia:

A metodologia adotada envolve a implementação dos algoritmos de ordenação em Java, tanto em versões sequenciais quanto paralelas, utilizando boas práticas de programação concorrente. Foi desenvolvido um framework de teste para variar o tamanho e a complexidade dos conjuntos de dados, de modo a analisar o comportamento sob diferentes condições. Os quatro algoritmos implementados para análise comparativa incluem: Bubble Sort, Quick Sort, Selection Sort e Insertion Sort. As execuções são realizadas em ambiente controlado, com variação do número de threads (2, 4, 6, 8, 10) e de núcleos disponíveis. Foram coletadas cinco amostras de cada execução para garantir a estabilidade dos dados. Os tempos de execução e métricas relevantes são registrados em arquivos CSV, que posteriormente são analisados estatisticamente para identificar padrões de desempenho e subsidiar a discussão. 

## Resultados e discussão:

Os resultados das execuções serão comparados entre as versões seriais e paralelas, considerando o tamanho e natureza dos conjuntos de dados, variação do número de threads e a média de cinco amostras por execução, conforme detalhado na Metodologia. Os dados coletados são aqui apresentados por meio de gráficos comparativos, permitindo a visualização clara do impacto do paralelismo no desempenho de cada algoritmo.

# Bubble Sort:
