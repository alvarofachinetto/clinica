<h1>Clinica</h1>

<p>O projeto Clinica foi desenvolvido com o objetivo de entender como funciona uma arquitetura de microserviços. 
Ele abrange tanto serviços de configuração quanto serviços de negócios. Em seu desenvolvimento foi utilizado tecnologias como Spring-Boot, 
Netflix-Eureka, Cloud-Gateway, Config-Server, Spring-Feign e o banco de dados escolhido foi o H2.</p> 
<h2>Serviços:</h2>
<table>
  <tr>
    <th>Serviço</th>
    <th>Descrição</th>
    <th>Resource</th>
  </tr>
  <tbody>
    <td>Pacientes</td>
    <td>Esse serviço faz o gerenciamento dos pacientes é possível<br> cadastrar, alterar, buscar, listar e excluir qualquer paciente.</td>
    <td><link>http://localhost:8081/pacientes?page=0&limit=10</link></td>
  </tbody>
  <tbody>
    <td>Médicos</td>
    <td>O serviço é semelhante ao de pacientes é possível<br> cadastrar, alterar, buscar, listar e excluir o médico.</td>
    <td><link>http://localhost:8082/medicos?page=0&limit=10</link></td>
  </tbody>
  <tbody>
    <td>Consultas</td>
    <td>O serviço de consultas <br> cadastrar, alterar, listar, buscar e excluir o médico.</td>
    <td><link>http://localhost:8083/medicos?page=0&limit=10</link></td>
  </tbody>
  <tbody>
    <td>Eureka-Server</td>
    <td>Eureka-Server é um serviço que centraliza as informações sobre os serviços como disponibilidade, saúde e balanceamento de carga além de saber o acesso dos serviços ligados a ele. Os serviços por sua vez se registram nele através do eureka-client e isso permite o eureka-server saber o endereço de cada serviço. <br> </td>
    <td><link>http://localhost:8761/eureka/apps</link></td>
  </tbody>
  <tbody>
    <td>Config-Server</td>
    <td>O serviço Config-Server funciona como um repositório central dos arquivos de propriedades dos serviços, ele gerencia essas configurações disponibilizando elas para os seus serviços de origem.</td>
    <td><link>http://localhost:8888/{nome do serviço}/{default | native}</link></td>
  </tbody>
  <tbody>
    <td>Cloud-Gateway</td>
    <td>Cloud-Gateway é usado para receber as requisições do client (web ou mobile) como um ponto de entrada e encaminhar ao serviço da requisição. Com a ajuda do Eureka-Server ele descobre a rota do serviço e o encaminha.<br> </td>
    <td><link>http://localhost:8989/{nome do serviço}</link></td>
  </tbody>
</table>
<h2>Arquitetura:</h2>
<p align="left">
  <img src="/images/clinica-microservices.png" width="1800" height="1000" alt="accessibility text">
</p>
