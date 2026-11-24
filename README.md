# Banco Digital / Digital Bank (Java)

Sistema de **Banco Digital** em linha de comando, desenvolvido em **Java** para a Situação de Aprendizagem **SA D 002 – Desenvolvimento de Sistema em JAVA** (Unidade Curricular: Lógica de Programação – SENAI, Turma 104190, Módulo 1).

**EN:** Command-line **Digital Bank** system, developed in **Java** for Learning Situation **SA D 002 – Java System Development** (Curricular Unit: Programming Logic – SENAI, Class 104190, Module 1).

- **Docente / Instructor:** Victor Moak
- **Grupo / Group:** 02 – Sistema de Banco Digital / Digital Bank SystemN/ Members:
 

---

## Sobre o projeto / About the project

O sistema permite que clientes sejam cadastrados, façam login, realizem transferências entre contas e consultem o extrato. Existe também um **menu de administrador** para modificar os dados dos clientes.

O menu é interativo e permanece em execução até que o usuário escolha encerrar o sistema. Os dados são salvos e lidos de arquivos, então continuam disponíveis após fechar o programa.

**EN:** The system allows customers to be registered, log in, transfer money between accounts and view their statements. There is also an **administrator menu** to modify customer data.

The menu is interactive and keeps running until the user chooses to exit. Data is saved to and read from files, so it remains available after the program is closed.

---

## Checklist de requisitos da avaliação / Evaluation requirements checklist

Os itens **em negrito** são critérios críticos.

**EN:** Items in **bold** are critical criteria.

### Requisitos comuns (Resultado 00) / Common requirements (Result 00)

| Critério | Atendido | Onde / como |
|---|:---:|---|
| **Interface clara e bem estruturada para o usuário** | Sim | Menus numerados, separadores visuais e mensagens de retorno em `view/Menu.java` |
| **Operações estruturadas em funções e/ou arquivos separados** | Sim | Código dividido em pacotes `model`, `service`, `repository`, `view` e `util`, com um método para cada operação |
| **Menu iterativo em execução até o usuário encerrar** | Sim | Laço `do-while` nos menus; só termina na opção **0 – Sair** |
| **Tratamento e validação de possíveis erros** | Sim | `try/catch` para entradas inválidas, validação de CPF, saldo, contas inexistentes e valores negativos (`util/Validador.java`) |
| **Projeto no GitHub** | Sim | _<link do repositório>_ |
| Salvar e ler dados em arquivos (**+1,0 ponto extra**) | Sim | Persistência em `data/clientes.txt` e `data/transacoes.txt` (`repository/ArquivoRepository.java`) |

**EN:**

| Criterion | Met | Where / how |
|---|:---:|---|
| **Clear and well-structured user interface** | Yes | Numbered menus, visual separators and feedback messages in `view/Menu.java` |
| **Operations structured in separate functions and/or files** | Yes | Code split into the `model`, `service`, `repository`, `view` and `util` packages, with one method per operation |
| **Interactive menu that keeps running until the user exits** | Yes | `do-while` loop in the menus; it only ends with option **0 – Exit** |
| **Error handling and validation** | Yes | `try/catch` for invalid input, validation of CPF, balance, nonexistent accounts and negative values (`util/Validador.java`) |
| **Project uploaded to GitHub** | Yes | _<repository link>_ |
| Save and read data from files (**+1.0 extra point**) | Yes | Persistence in `data/clientes.txt` and `data/transacoes.txt` (`repository/ArquivoRepository.java`) |

### Requisitos do Banco Digital (Resultado 02) / Digital Bank requirements (Result 02)

| Critério | Atendido | Opção no menu |
|---|:---:|---|
| **Cadastrar clientes** | Sim | Menu principal → `1 – Cadastrar cliente` |
| **Listar os clientes** | Sim | Menu do administrador → `Listar clientes` |
| **Realizar transferências entre contas** | Sim | Menu do cliente → `Transferir` |
| **Listar clientes** | Sim | Mesma funcionalidade acima, com número da conta, nome e saldo |
| **Realizar login** | Sim | Menu principal → `2 – Login` (número da conta/CPF + senha) |
| **Menu de administrador para modificar dados de clientes** | Sim | Login como admin → `Modificar dados do cliente` |
| Emitir extrato de contas | Sim | Menu do cliente → `Extrato` |

**EN:**

| Criterion | Met | Menu option |
|---|:---:|---|
| **Register customers** | Yes | Main menu → `1 – Register customer` |
| **List customers** | Yes | Administrator menu → `List customers` |
| **Transfer between accounts** | Yes | Customer menu → `Transfer` |
| **List customers** | Yes | Same feature as above, showing account number, name and balance |
| **Log in** | Yes | Main menu → `2 – Login` (account number/CPF + password) |
| **Administrator menu to modify customer data** | Yes | Admin login → `Modify customer data` |
| Issue account statement | Yes | Customer menu → `Statement` |

---

## Checklist de tarefas / Task checklist

Progresso do desenvolvimento do grupo. Troque `[ ]` por `[x]` quando a tarefa estiver concluída.

**EN:** The group's development progress. Replace `[ ]` with `[x]` when a task is done.

### Estrutura geral / General structure
- [ ] Criar o repositório no GitHub e subir o projeto
- [ ] Organizar o código em pacotes e classes separados
- [ ] Criar o menu principal interativo (roda até o usuário escolher sair)
- [ ] Implementar a validação e o tratamento de erros nas entradas
- [ ] Salvar e ler os dados em arquivos (ponto extra)

**EN:**
- [ ] Create the GitHub repository and upload the project
- [ ] Organize the code into separate packages and classes
- [ ] Create the interactive main menu (runs until the user chooses to exit)
- [ ] Implement input validation and error handling
- [ ] Save and read data from files (extra point)

### Funcionalidades do Banco Digital / Digital Bank features
- [ ] Cadastrar clientes
- [ ] Listar clientes
- [ ] Realizar login
- [ ] Realizar transferências entre contas
- [ ] Criar o menu de administrador
- [ ] Modificar dados de clientes (administrador)
- [ ] Emitir extrato de contas

**EN:**
- [ ] Register customers
- [ ] List customers
- [ ] Log in
- [ ] Transfer between accounts
- [ ] Create the administrator menu
- [ ] Modify customer data (administrator)
- [ ] Issue account statements

### Entrega / Delivery
- [ ] Testar todas as funcionalidades e os casos de erro
- [ ] Revisar o README (nomes, link do GitHub, login de teste)
- [ ] Preparar a apresentação de até 15 minutos
- [ ] Entregar o código-fonte na data combinada

**EN:**
- [ ] Test all features and error cases
- [ ] Review the README (names, GitHub link, test login)
- [ ] Prepare the presentation of up to 15 minutes
- [ ] Submit the source code on the agreed date

---

## Funcionalidades / Features

### Menu principal / Main menu
```
===== BANCO DIGITAL =====
1 - Cadastrar cliente
2 - Login
0 - Sair
```

**EN:**
```
===== DIGITAL BANK =====
1 - Register customer
2 - Login
0 - Exit
```

### Menu do cliente (após login) / Customer menu (after login)
```
===== BEM-VINDO(A), <nome> =====
1 - Consultar saldo
2 - Depositar
3 - Transferir
4 - Extrato
0 - Sair da conta
```

**EN:**
```
===== WELCOME, <name> =====
1 - Check balance
2 - Deposit
3 - Transfer
4 - Statement
0 - Log out
```

### Menu do administrador / Administrator menu
```
===== ÁREA ADMINISTRATIVA =====
1 - Listar clientes
2 - Modificar dados do cliente
0 - Sair da conta
```

**EN:**
```
===== ADMINISTRATIVE AREA =====
1 - List customers
2 - Modify customer data
0 - Log out
```

### Detalhes de cada operação / Details of each operation

- **Cadastro de cliente:** informa nome, CPF, senha e saldo inicial. O sistema gera o número da conta automaticamente e impede CPF duplicado.
- **Listagem de clientes:** mostra número da conta, nome, CPF e saldo de todos os clientes cadastrados.
- **Login:** autentica com credenciais e direciona para o menu do cliente ou do administrador. Após 3 tentativas erradas, volta ao menu principal.
- **Transferência entre contas:** pede a conta de destino e o valor. Valida se a conta existe, se o valor é positivo e se há saldo suficiente. O débito e o crédito são feitos juntos e os dois lados registram a transação.
- **Extrato:** lista as movimentações da conta (depósitos, transferências enviadas e recebidas) com data, tipo, valor e saldo final.
- **Modificar dados (administrador):** permite alterar nome, senha e outros dados cadastrais de um cliente escolhido pelo número da conta.

**EN:**
- **Customer registration:** enter name, CPF, password and initial balance. The system generates the account number automatically and prevents duplicate CPFs.
- **Customer listing:** shows account number, name, CPF and balance of all registered customers.
- **Login:** authenticates with credentials and routes to the customer or administrator menu. After 3 wrong attempts, it returns to the main menu.
- **Transfer between accounts:** asks for the destination account and the amount. Validates that the account exists, that the amount is positive and that the balance is sufficient. The debit and the credit are done together and both sides record the transaction.
- **Statement:** lists the account's transactions (deposits, sent and received transfers) with date, type, amount and final balance.
- **Modify data (administrator):** allows changing the name, password and other registration data of a customer chosen by account number.

---

## Tratamento e validação de erros / Error handling and validation

- Entradas não numéricas onde se espera número (`InputMismatchException` / `NumberFormatException`)
- Campos obrigatórios vazios
- CPF com formato inválido ou já cadastrado
- Valores zero ou negativos em depósitos e transferências
- Saldo insuficiente
- Transferência para a própria conta
- Conta de origem ou destino inexistente
- Login com dados incorretos
- Arquivo de dados ausente ou corrompido (o sistema cria um novo e avisa o usuário)

**EN:**
- Non-numeric input where a number is expected (`InputMismatchException` / `NumberFormatException`)
- Empty required fields
- CPF with invalid format or already registered
- Zero or negative values in deposits and transfers
- Insufficient balance
- Transfer to the same account
- Nonexistent source or destination account
- Login with incorrect data
- Missing or corrupted data file (the system creates a new one and warns the user)

---

## Estrutura do projeto / Project structure

```
banco-digital/
├── src/
│   └── banco/
│       ├── Main.java
│       ├── model/
│       │   ├── Cliente.java
│       │   ├── Conta.java
│       │   └── Transacao.java
│       ├── service/
│       │   ├── AuthService.java
│       │   └── BancoService.java
│       ├── repository/
│       │   └── ArquivoRepository.java
│       ├── view/
│       │   └── Menu.java
│       └── util/
│           └── Validador.java
├── data/
│   ├── clientes.txt
│   └── transacoes.txt
└── README.md
```

Ajuste os nomes acima para ficarem iguais aos arquivos reais do seu projeto.

**EN:** Adjust the names above to match the actual files in your project.

---

## Persistência de dados / Data persistence

Os dados são gravados em arquivos de texto dentro da pasta `data/`:

- `clientes.txt`: um cliente por linha, com campos separados por `;`
- `transacoes.txt`: um registro por movimentação (conta, tipo, valor, data)

Os arquivos são **lidos ao iniciar** o sistema e **atualizados a cada operação** que altera dados.

**EN:** Data is written to text files inside the `data/` folder:

- `clientes.txt`: one customer per line, with fields separated by `;`
- `transacoes.txt`: one record per transaction (account, type, amount, date)

Files are **read on startup** and **updated on every operation** that changes data.

---

## Como executar / How to run

**Pré-requisito:** JDK 17 ou superior instalado (`java -version` e `javac -version` devem funcionar).

**EN:** **Prerequisite:** JDK 17 or higher installed (`java -version` and `javac -version` must work).

### 1. Clonar o repositório / Clone the repository

**Windows (CMD/PowerShell) e/and macOS (Terminal):**
```bash
git clone <link-do-repositorio>
cd banco-digital
```

### 2. Compilar / Compile

**Windows (CMD/PowerShell):**
```bat
javac -d out -sourcepath src src\banco\Main.java
```

**macOS (Terminal):**
```bash
javac -d out -sourcepath src src/banco/Main.java
```

### 3. Executar / Run

**Windows (CMD/PowerShell):**
```bat
java -cp out banco.Main
```

**macOS (Terminal):**
```bash
java -cp out banco.Main
```

Também é possível abrir a pasta no IntelliJ IDEA, Eclipse ou VS Code e executar a classe `Main`.

**EN:** You can also open the folder in IntelliJ IDEA, Eclipse or VS Code and run the `Main` class.

---

## Acesso inicial / Initial access

| Perfil / Profile | Usuário / User | Senha / Password |
|---|---|---|
| Administrador / Administrator | _<admin>_ | _<senha / password>_ |
| Cliente de teste / Test customer | _<conta/CPF / account/CPF>_ | _<senha / password>_ |

---

## Roteiro de demonstração (15 min) / Demo script (15 min)

1. Mostrar o menu principal e a estrutura do código (pacotes e classes).
2. Cadastrar dois clientes.
3. Fazer login com o primeiro cliente e consultar o saldo.
4. Realizar uma transferência para o segundo cliente.
5. Emitir o extrato dos dois clientes.
6. Testar erros: saldo insuficiente, conta inexistente, valor negativo, login inválido.
7. Entrar como administrador, listar clientes e modificar os dados de um deles.
8. Encerrar o sistema, abrir novamente e mostrar que os dados foram mantidos (arquivos).

**EN:**
1. Show the main menu and the code structure (packages and classes).
2. Register two customers.
3. Log in with the first customer and check the balance.
4. Make a transfer to the second customer.
5. Issue the statement for both customers.
6. Test errors: insufficient balance, nonexistent account, negative amount, invalid login.
7. Log in as administrator, list customers and modify the data of one of them.
8. Exit the system, start it again and show that the data was kept (files).

---

## Tecnologias / Technologies

- Java 17+
- Git e/and GitHub
- Persistência em arquivos de texto / Persistence in text files (`java.io` / `java.nio.file`)

---

## Autores (ordem alfabética) / Authors (alphabetical order)

| Nome / Name | GitHub |
|---|---|
| _<nome 1 / name 1>_ | _<@usuario / @user>_ |
| _<nome 2 / name 2>_ | _<@usuario / @user>_ |
| _<nome 3 / name 3>_ | _<@usuario / @user>_ |

---

## Licença / License

Projeto acadêmico desenvolvido para fins educacionais.

**EN:** Academic project developed for educational purposes.
