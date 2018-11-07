![Mercado Libre](https://static.eventials.com/media/64292b1c2b2e13ead8788fc8a2b8edc8c1db4ecd/46ee958d54ac6b84de632a7fa39dae693d9b9a5e/1495032909/mercadolibre.jpg)

Um diferencial foi a padronização do Adapter para as listas e ViewHolder, onde todas as listas que precisam ser criadas seguem um mesmo contrato, tornando mais pratico o desenvolvimento.

Também foi pensando a falta de memória ou quando uma atividade precisa ser encerrada pelo sistema operacional Android, portando irão ver a presença de "InstanceState" e "onSaveInstanceState" no qual internamente o Android Annotations salvas os objetos no Bundle da Activity, e o recupera quando volta para atividade, economizando portando requisições desnecessárias ou perdas de dados quando por exemplo o usuário atende um telefonema e volta para o aplicativo.

O foco dessa POC foi focado em arquitetura MVP.

-----Frameworks-----

- Android Annotations
- Retrofit
- Gson
- EventBus
- Picasso

# Entendendo o Projeto

Esse projeto utiliza o conceito MVP (Model View Presenter) com **UseCases**, ou seja, temos a camada da **View** que se comunica com o **Presenter** no qual se comunica com os **UseCases** e os mesmo se comunicam com os Serviços(**core**).

![Scheme](images/print1.png)

**APP**

* Tela - **View** responsável por mostrar informações ao usuário, como **Activity, Fragment, Dialog e etc**. 

![Scheme](images/print2.png)

* Contract - **Interface** responsável por garantir o **contrato entre o Presenter e a View**.

![Scheme](images/print3.png)

* Presenter - responsável por fazer a comunicação entre a **View** e os **UseCase**, **(NO PRESENTER NÃO VAI REGRA DE NEGÓCIO, POIS SE NÃO O USECASE FICA SEM EMPREGO)**

![Scheme](images/print4.png)

* UseCase - responsável por fazer a comunicação entre **Presenter** e o Serviço(**core**), sendo aqui onde fica as regras de negócios e conversão dos objetos entre **App e Core** utilizando os **Mapper**, **(NADA DE FAZER CONVERSÃO FORA DOS MAPPERS, POIS ELES PRECISAM DESSE EMPREGO)**

![Scheme](images/print5.png)

* Model - responsável por representar os dados de um Objeto para as **View**

![Scheme](images/print6.png)

* Mapper - responsável por converter o **ModelResponse do Core** em **Model do App**

![Scheme](images/print7.png)

**CORE**

* ModelRequest - Model que representa o conjunto de dados para uma requisição

![Scheme](images/print8.png)

* ModelResponse - Model que representa a resposta de uma requisição

![Scheme](images/print9.png)

* API - Classe que controla as chamadas 

![Scheme](images/print10.png)
