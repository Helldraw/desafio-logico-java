import java.util.*;

public class ArcoIris{

	public static void main(String[] args) {
		
		Set<Cores>cores = new TreeSet<>();
		cores.add(new Cores("Vermelho"));
		cores.add(new Cores("Laranja"));
		cores.add(new Cores("Amarelo"));
		cores.add(new Cores("Verde"));
		cores.add(new Cores("Azul"));
		cores.add(new Cores("Indigo"));
		cores.add(new Cores("Violeta"));
		
		Set<Cores>cores2 = new LinkedHashSet<>(cores);

		
		List<Cores>cores3 = new ArrayList<>(cores);


		//Imprime cores uma abaixo da outra e soma quantidade de cores.
		for(Cores cor:cores) {
			System.out.println(cor);
		}
		//Informa quantidade de cores no arco-iris
		System.out.println("O arco-iris possui: " + cores.size() + " cores.");
		for(Cores cor:cores) {
		char s[] = cor.getCor().toCharArray();
		//Imprime cores que iniciam com a letra V
		if(s[0] == 'V') {
			System.out.println(cor.getCor());
			//Exclui cores que não iniciam com a letra V
		}else if(s[0] != 'V') {
			System.out.println("cor: " + cor + " removida");
			cores2.remove(cor);
		}
		}
		//Remove todos os elementos do set
		System.out.println("Removendo todas as cores");
		cores2.removeAll(cores2);
		System.out.println("Conjunto esta vazio ? " + cores2.isEmpty());
		
		//Imprime cores na ordem inversa da informada
		Collections.reverse(cores3);
		System.out.println(cores3);
		
		
	}

}

class Cores implements Comparable<Cores>{
	private String cor;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cores other = (Cores) obj;
		return Objects.equals(cor, other.cor);
	}

	@Override
	public String toString() {
		return cor;
	}

	public Cores(String cor) {
		this.cor = cor;
	}

	@Override
	public int compareTo(Cores o) {
		return this.getCor().compareToIgnoreCase(o.getCor());
	}
	
}

