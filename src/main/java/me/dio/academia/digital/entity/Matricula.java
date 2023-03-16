package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //cria getters e setters
@NoArgsConstructor //cria construtor sem argumentos
@AllArgsConstructor //cria contrutor com todos os argumentos
@Entity //diz que essa entidade é uma tabela do banco de dados
@Table(name = "tb_matriculas") //define o nome da tabela no bd
public class Matricula {

  @Id //marca o parâmetro como id da tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) //define como será gerado o valor do id
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) //define a relação de 1 (matricula) para 1 (aluno) e o comportamento das alterações dos elementos relacionados
  @JoinColumn(name = "aluno_id") //define a foreign key que representa o relacionamento
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
