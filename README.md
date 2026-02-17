## **TODO-List**
Este projeto consiste no desenvolvimento de uma aplicação de gerenciamento de tarefas (TODO-List) em Java, permitindo cadastrar, listar, ordenar e remover tarefas com base em atributos como prioridade, categoria, data e status.

O projeto foi desenvolvido e testado apenas no IntelliJ.

### Como executar:
* Clone o repositório.
* Abra o projeto na IDE (IntelliJ).
* Execute a classe Main localizada na pasta src.
* Utilize o menu exibido no terminal para interagir com o sistema.


#### Observações sobre a solução:
* A aplicação foi estruturada utilizando separação em camadas (model, repository, service e main) para facilitar manutenção e organização.
* O Repository é responsável pelo armazenamento das tarefas.
* O Service contém as regras de negócio, validações e ordenações.
* A ordenação das tarefas é realizada dinamicamente usando Comparator.

#### Autor: Wallace Elpidio Pereira Cardoso