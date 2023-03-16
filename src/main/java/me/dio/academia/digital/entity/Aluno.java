package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//anotações lombok
@Data //cria getters e setters
@NoArgsConstructor //cria construtor sem argumentos
@AllArgsConstructor //cria contrutor com todos os argumentos
// ----- fim lombok ------
@Entity //diz que essa entidade é uma tabela do banco de dados
@Table(name = "tb_alunos") //define o nome da tabela no bd
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //define a inicialização do hibernate para trabalhar com LAZY
public class Aluno {

  @Id //marca o parâmetro como id da tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) //define como será gerado o valor do id
  private Long id;

  private String nome;

  @Column(unique = true) //define que esse campo deverá ser único
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  //esse atributo define a relação entre aluno e avaliações físicas, nesse 1 ( aluno) para muitos (avaliações)
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //anotação que define a relação de 1 para muitos atraves do atributo "alunos" o tipo de fetch (LAZY) define que os dados referentes as avaliações físicas não serão trazidos quando um aluno for requisitado.
  @JsonIgnore //ignora exeptions relacionadas a json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
