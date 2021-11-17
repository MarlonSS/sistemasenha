Documento Arquitetural - Projeto Arquitetura Software


Camada de Apresentação (Presentation)

Esta camada é responsável pela comunicação do usuário com o sistema, ou seja fornece ao usuário a apresentação necessária para utilização dos recursos do sistema, com componentes que realizam essas solicitações.
Essas solicitações serão feitas via angular, que a partir o código javascript irá atuar enviando e recebendo mensagens Json via Rest.

      1.1. Tecnologias Utilizadas            
AngularJS
Spring MVC
Spring Security
Lombok
Google Captcha
 
Camada de Aplicação 
 
Esta camada será responsável pela coordenação das requisições com acesso a interface de repositório JPA.
2.1. Tecnologias utilizadas
Lombok
Spring Boot
 
Camada de Domínio .
Manterá os objetos modelo da aplicação, objetos que serviram de modelo para persistência via JPA. Com o framework BeanValidation será possível fazer validações de email e senhas, por exemplo.
3.1. Tecnologias Utilizadas
Lombok
JPA
 
Camada de Infraestrutura
Esta camada fornecerá suporte para as demais camadas, ou seja, atuará na implementação da persistência dos objetos da aplicação, com bibliotecas específicas para persistência.
4.1. Tecnologias Utilizadas
Hibernate
Spring Data

Requisitos Arquiteturais

Segurança

A aplicação terá como requisito não-funcional principal, ao qual deverá ser atendido, a segurança. Por ser uma aplicação para senhas de outras aplicações deverá atender este requisito, para isso serão utilizadas tecnologias que visam atingir esse requisito, como spring security, jwt, google captcha, validação de login, como frases ou palavras-chave. Além disso, otimização de comandos sql, visando ataques de sql injection.

6. Visão de Caso de Uso
 
A partir da aplicação será possível realizar inserções, alterações, exclusões, visualizações das contas criadas, que estarão vinculadas a uma instituição, ou seja cada instituição poderá ter n contas criadas.
O sistema terá funcionalidade de verificação da senha e login do usuário para validação.

7. Visão de implementação


7.1. Componentes
Aplicação será composta de três objetos: usuário, instituição e interface. O usuário com acesso a ambos objetos, e podendo cadastrar n instituições, e n contas vinculadas as instituições.
