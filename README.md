# Poker
Aplicativo em java que simula um jogo semelhante ao Poker
![](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/b5o34hbi.png)

-------------------------------------


Desafio: Crie a classe Carta, que possui um nome e um naipe. Crie os métodos GET e SET para os atributos. Crie agora uma classe Baralho, que possui 52 cartas. No construtor de Baralho, inicialize as 52 cartas. Escreva os seguintes métodos: 

a) embaralha( ) – usando o método Math.random dá para trocar as cartas dentro do baralho, misturando-as (sorteie duas posições e troque-as. Repita este processo diversas vezes). 

b) darCartas( ) – devolve duas cartas, retirada do topo do baralho, se não estiver vazio, ou null. 

c) temCarta( ) – verifica se tem carta no baralho, devolvendo true ou false. A classe Baralho, assim construída, será útil para programar diversos jogos de cartas, através de novas classes que os implementem. 

d) imprimeBaralho( ) – imprime as cartas para verificar como estão dispostas (se estão embaralhadas por exemplo).

- No inicio do programa, pergunte quantas jogadores possui na mesa, retorne duas cartas aleatórias para cada jogador

- Após isso, pergunte para cada jogador se ele quer abandonar a mão ou apostar, se apostar quanto ele aposta repita esse processo até todos apostarem a mesma quantia

- Toda vez q alguém abandonar, reimprimir as mãos dos jogadores restante sem a mão do jogador que abandonou, (o dinheiro q ele já tiver apostado, deve continuar no montante)

- Assim, que todos os jogadores tiverem apostado a mesma quantia, imprima mais 5 cartas e pergunte quem ganhou 

- Imprimir o número do jogador e quanto reais ele levou (soma de todas as apostas)
- adicione um bloco try/catch para validar se o número de participantes é maior do que zero, se for igual ou menor, deve lançar uma exception e ser pega pelo try/catch

