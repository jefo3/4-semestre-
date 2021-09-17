import java.util.ArrayList;

public class Turma {
  ArrayList<Aluno> alunos = new ArrayList<Aluno>();

  public Turma(){}

  public void addAluno(Aluno aluno){
    this.alunos.add(aluno);
  }
}
