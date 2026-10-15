# Operação REBOOT — registro da equipe

Equipe: X

Integrantes: Davi Israel e Erik Bueno

## Missão 1 — Inventário
Previsão ANTES de executar (vetor final, tamanho, capacidade e deslocamentos):

- Inicialmente foi visualizado que a criação do Loop estava incorreta e 
por conta disso, apresentava alguns erros de inserção e remoção

Resultado observado na versão inicial:

- Na versão inicial estava retornando valores incorretos e muitas vezes
valores repetidos 

Causa da falha e correção (explique; não basta colar o código):

- A causa das falhas estavam nos métodos de inserir e remover, a principio
o erro estava no loop 

Custo de inserir no início e no fim com espaço; por quê?

- O custo de inserir no inicio se a lista está vazia é teoricamente custo 0
Após, o custo de inserir no fim e no inicio é baseado no tamanho da lista,
pois irá precisar deslocar os elementos da mesma

Quem programou / quem testou / quem explicou:

- No geral programamos juntos, e testamos juntos


## Missão 2 — Fila circular
Previsão ANTES de executar (posições físicas, início, fim, tamanho e ordem lógica):

Resultado observado:

- Inicialmente o esperado era que não fosse possível fazer o processo coircular
ao rodar os testes foi visto que isto de fato ocorria mesmo

Causa da falha e correção:

- Não consegui obter as correçõs das falhas... Mas acredito que o
método está correto

Como distinguir cheia de vazia? Como obter O(1) nas operações?

- É possível verificar se a fila está cheia ou vazia a partir dos métodos
Booleans criados, onde podemos verificar através do lenght ou apenas retornando
o tamanho

Quem programou / quem testou / quem explicou:

- A questão 2 Davi Israel Quirino foi quem programou e testou a mesma

## Missão 3 — Escalonador
Previsão ANTES de executar (turno, processo, executado, restante, fila):

Ordem de conclusão e tempo total:

Causa das falhas e correções:

Por que um processo volta ao fim? Por que preservar o array de entrada?

Quem programou / quem testou / quem explicou:

## Fechamento individual (cada integrante responde)
Nome: Davi Israel Quirino

1. Tamanho e capacidade são a mesma coisa?

- Não, tamanho seria o que está ocupado do Array, enquanto capacidade seria 
o quanto poderia estar suportando ( em código seria size / lenght )

2. A fila pode começar fisicamente no índice 2?

- Se for uma fila circular, é possível começar no índice 2 sim, porém caso
seja uma fila normal, não seria possível

3. O primeiro processo a chegar precisa terminar primeiro?

- Referente ao exercicio de escalonador, não cheguei a verificar o erro

4. Qual conteúdo você precisa praticar mais?

- Acredito que as filas e as pilhas no momento seriam uma boa prática

## Desafio extra, se houver tempo
Novo cenário de teste, resultado esperado e qual erro ele detecta:
