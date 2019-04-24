package saif;

import java.util.ArrayList;

public class turma {
	private String disciplina;
	private String periodo;
	private ArrayList<Usuario> turma;

	public turma(ArrayList<Usuario>turma, String periodo, String disciplina) {
		super();
		this.turma= turma;
		this.setPeriodo(periodo);
		this.disciplina = disciplina;
	}
	
	
	
	public String getDisciplina() {
		return disciplina;
	}



	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<Usuario> getTurma() {
		return turma;
	}



	public void setTurma1(ArrayList<Usuario> turma) {
		this.turma = turma;
	}



	@Override
	public String toString() {
		return "turma [disciplina=" + disciplina + ", periodo=" + periodo + ", usuarios=" + turma + "]\n";
	}

	public String getPeriodo() {
		return periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		turma other = (turma) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}



	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
