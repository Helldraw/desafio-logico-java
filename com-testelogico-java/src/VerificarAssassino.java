import java.util.*;
public class VerificarAssassino {
	public static void main(String[] args) {
		Integer cont = 0;
		Scanner entrada = new Scanner(System.in);
		List<Perguntas> perguntas = new ArrayList<>();
		System.out.println("Telefonou para a vitima ?");
		perguntas.add(new Perguntas("Telefonou para a vitima ?", entrada.next()));
		System.out.println("Esteve no local do crime ?");
		perguntas.add(new Perguntas("Esteve no local do crime ?", entrada.next()));
		System.out.println("Mora perto da vitima ?");
		perguntas.add(new Perguntas("Mora perto da vitima ?", entrada.next()));
		System.out.println("Devia para a vitima ?");
		perguntas.add(new Perguntas("Devia para a vitima ?", entrada.next()));
		System.out.println("Ja trabalhou com a vitima ?");
		perguntas.add(new Perguntas("Ja trabalhou com a vitima ?", entrada.next()));

		for(Perguntas x : perguntas) {
			if(x.getResposta().equalsIgnoreCase("sim")) {
				cont++;
			}
			
		}
		if(cont==2) {
			System.out.println("Suspeito");
		}else if(cont > 2 && cont < 5){
			System.out.println("Cumplice");
		}else if(cont ==5) {
			System.out.println("Assassino");
		}else 
			System.out.println("Inocente");
		entrada.close();
	}
	
}

class Perguntas{
	private String pergunta;
	private String resposta;
	
	public Perguntas(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(pergunta, resposta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perguntas other = (Perguntas) obj;
		return Objects.equals(pergunta, other.pergunta) && Objects.equals(resposta, other.resposta);
	}
	@Override
	public String toString() {
		return "Perguntas [pergunta=" + pergunta + ", resposta=" + resposta + "]";
	}
	
	
	
}
