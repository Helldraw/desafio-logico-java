import java.util.*;

public class LinguagemFavorita {
	public static void main(String[] args) {
		Set<Linguagem> linguagem = new LinkedHashSet<>();
		linguagem.add(new Linguagem("Python","PyCharm", 1989));
		linguagem.add(new Linguagem("Ruby", "RubyMine", 1995));
		linguagem.add(new Linguagem("Java","Eclipse", 1991));
		//Imprime os elementos de acordo com a inserção *LinkedHashSet*
		for(Linguagem x:linguagem) {
			System.out.println(x);
		}
		Set<Linguagem> linguagem2 = new TreeSet<>(linguagem);
		//Imprime os elementos por ondem alfabetica *TreeSet+compareTo()*
		for(Linguagem x:linguagem2) {
			System.out.println(x);
		}
		//Imprime os elementos por ordem de IDE *class ComparatorIde* 
		Set<Linguagem> linguagem3 = new TreeSet<>(new ComparatorIde());
		linguagem3.addAll(linguagem);
		for(Linguagem x:linguagem3) {
			System.out.println(x);
		}
		//Imprime os elementos por ordem do ano *class ComparatorAno*
		Set<Linguagem> linguagem4 = new TreeSet<>(new ComparatorAno());
		linguagem4.addAll(linguagem);
		for(Linguagem x : linguagem4) {
			System.out.println(x);
		}
		//Imprime os elementos por ordem do nome/ano/IDE *class ComparatorNomeAnoIde*
		Set<Linguagem> linguagem5 = new TreeSet<>(new ComparatorNomeAnoIde());
		linguagem5.add(new Linguagem("Python","PyCharm", 1989));
		linguagem5.add(new Linguagem("Ruby", "RubyMine", 1995));
		linguagem5.add(new Linguagem("Java","aEclipse", 1991));
		linguagem5.add(new Linguagem("aPython","aPyCharm", 1988));
		linguagem5.add(new Linguagem("aRuby", "xRubyMine", 1996));
		linguagem5.add(new Linguagem("Java","Eclipse", 1991));
		linguagem5.add(new Linguagem("Python","aPyCharm", 1988));
		linguagem5.add(new Linguagem("Ruby", "xRubyMine", 1996));
		linguagem5.add(new Linguagem("Java","Eclipse", 1990));

		for(Linguagem x : linguagem5) {
			System.out.println(x);
		}
	}

}

class Linguagem implements Comparable<Linguagem>{
	private String nome;
	private String ide;
	private Integer anoCriacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIde() {
		return ide;
	}
	public void setIde(String ide) {
		this.ide = ide;
	}
	public Integer getAnoCriacao() {
		return anoCriacao;
	}
	public void setAnoCriacao(Integer anoCriacao) {
		this.anoCriacao = anoCriacao;
	}
	@Override
	public String toString() {
		return "Linguagem [nome=" + nome + ", ide=" + ide + ", anoCriacao=" + anoCriacao + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(anoCriacao, ide, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linguagem other = (Linguagem) obj;
		return Objects.equals(anoCriacao, other.anoCriacao) && Objects.equals(ide, other.ide)
				&& Objects.equals(nome, other.nome);
	}
	public Linguagem(String nome, String ide, Integer anoCriacao) {
		this.nome = nome;
		this.ide = ide;
		this.anoCriacao = anoCriacao;
	}
	@Override
	public int compareTo(Linguagem o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	
}

class ComparatorIde implements Comparator<Linguagem>{

	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		return o1.getIde().compareToIgnoreCase(o2.getIde());
	}
	
}
class ComparatorAno implements Comparator<Linguagem>{

	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		return o1.getAnoCriacao().compareTo(o2.getAnoCriacao());
	}
	
}

class ComparatorNomeIde implements Comparator<Linguagem>{
	
	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		Integer comparaNome = o1.getNome().compareToIgnoreCase(o2.getNome());
		if( comparaNome != 0){
		return 	comparaNome;
		}else {
			return o1.getIde().compareToIgnoreCase(o2.getIde());
		}
		
	}
}

class ComparatorNomeAnoIde implements Comparator<Linguagem>{
	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		Integer comparaNome = o1.getNome().compareTo(o2.getNome());
		Integer comparaAno = o1.getAnoCriacao().compareTo(o2.getAnoCriacao());
		if(comparaNome != 0) {
			return comparaNome;
		}else if(comparaAno != 0) {
			return comparaAno;
		}else {
			return o1.getIde().compareToIgnoreCase(o2.getIde());
		}
	}
}
