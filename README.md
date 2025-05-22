
# SpotiFEI 

## 1. Sobre o Projeto

Esse é o SpotiFEI, um projeto que desenvolvi com o objetivo de simular uma plataforma de streaming de música, parecido com o Spotify. A ideia principal aqui foi juntar os conhecimentos de Java, banco de dados e interfaces gráficas pra criar um sistema funcional, com foco na experiência do usuário e na organização do código.

Ao longo do desenvolvimento, busquei aplicar boas práticas de programação, como o uso do padrão MVC (Model-View-Controller), além de reforçar conceitos de orientação a objetos e manipulação de dados com JDBC.

---

## 2. O que o sistema faz

O sistema permite que um usuário entre com login, visualize músicas disponíveis, curta, adicione em playlists e veja o histórico do que já foi ouvido. Também é possível editar dados e navegar entre várias telas de forma intuitiva. Aqui vai um resumo das principais funções:

- Cadastro e login de usuários
- Listagem de músicas
- Curtidas (favoritas)
- Criação e gerenciamento de playlists
- Histórico de execuções
- Interface com botões e ícones para facilitar o uso

Tentei deixar a navegação bem simples, usando imagens e uma interface amigável.

---

## 3. Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
src/
├── controller/       # Controladores das ações do sistema
├── DAO/              # Classes que lidam com o banco de dados
├── model/            # Classes que representam os dados (Aluno, Música etc.)
├── view/             # Telas da interface gráfica
├── images/           # Ícones e imagens usados na interface
├── main.java         # Arquivo principal que inicia a aplicação
spotifei.sql          # Script de criação do banco de dados
```

As views foram feitas com Java Swing, e cada tela tem seu `.form` (gerado pelo NetBeans) e seu `.java` com a lógica associada. A conexão com o banco fica centralizada na classe `Conexao.java`.

---

## 4. Tecnologias que usei

- **Java** (usei JDK 8)
- **Swing** pra parte visual
- **PostgreSQL** pra armazenar os dados
- **NetBeans** como IDE principal

---

## 5. Como rodar

Se quiser rodar o projeto, é só seguir esses passos:

1. **Abra no NetBeans**  
   Vá em "Abrir Projeto" e selecione a pasta `spoti-fei`.

2. **Crie o banco de dados**  
   No seu PostgreSQL, execute o script `spotifei.sql` que está na raiz do projeto.

3. **Configure a conexão**  
   Na classe `Conexao.java`, coloque seus dados (host, usuário, senha, nome do banco).

4. **Rode o projeto**  
   Execute `main.java` e o sistema vai abrir a interface inicial.

---

## 6. Considerações finais

Esse projeto foi bem legal de fazer. Pude aplicar bastante coisa que aprendi e também entender melhor como é estruturar uma aplicação maior em Java. Além disso, foi um ótimo exercício pra pensar em usabilidade e deixar a interface clara.

Claro que ainda dá pra melhorar muita coisa: como colocar um player real de música, adicionar mais segurança no login (tipo criptografia de senha), ou até levar tudo isso pra web ou mobile. Mas como projeto acadêmico, acho que cumpre bem o papel.

Se quiser dar uma olhada no código, fique à vontade!

---

