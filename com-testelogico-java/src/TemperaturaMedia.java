import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TemperaturaMedia {
	public static void main(String[] args) {		
	Scanner entrada = new Scanner(System.in);
	List<Temperatura> temperatura = new ArrayList<>();
	System.out.println("Informe a temperatura media do mes de janeiro");
	temperatura.add(new Temperatura ("Janeiro", entrada.nextDouble()));
	System.out.println("Informe a temperatura media do mes de fevereiro");
	temperatura.add(new Temperatura ("Fevereiro",entrada.nextDouble()));
	System.out.println("Informe a temperatura media do mes de março");
	temperatura.add(new Temperatura ("Março",entrada.nextDouble()));
	System.out.println("Informe a temperatura media do mes de abril");
	temperatura.add(new Temperatura ("Abril",entrada.nextDouble()));
	System.out.println("Informe a temperatura media do mes de maio");
	temperatura.add(new Temperatura ("Maio",entrada.nextDouble()));
	System.out.println("Informe a temperatura media do mes de junho");
	temperatura.add(new Temperatura ("Junho",entrada.nextDouble()));
	System.out.println(temperatura);
	for(Temperatura t : temperatura) {
		media(t.getTemperatura(),1);
	}
	System.out.println("A media semestral de temperatura é de: " + media(0d,6));
	System.out.println("==================================================");
	System.out.println("Os meses que tiveram temperatura maior do que a media foram: ");
	Integer x = 1;
	Temperatura maior= new Temperatura(" ", 0d);
	for(Temperatura t : temperatura) {
		if(t.getTemperatura() > media(0d,6)) {
			System.out.println(x+ "-"+ t.getMes() +" - "+ t.getTemperatura());
			if(maior.getTemperatura() < t.getTemperatura()) {
				maior.setMes(t.getMes());
				maior.setTemperatura(t.getTemperatura());
				
			}
		}
		
		x++;
	}
	System.out.println("A maior temperatura foi de: " + maior);
	entrada.close();
	}
	
	static Double soma = 0d;
	static public Double media(Double t, Integer i) {
		soma += t;
		return soma/i;
		
	}
}



class Temperatura implements Comparable<Temperatura>{
	private String mes;
	private Double temperatura;
	
	public Temperatura(String mes, Double temperatura) {
		this.mes = mes;
		this.temperatura = temperatura;
	}
	
	
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	@Override
	public String toString() {
		return "[mes=" + mes + ", temperatura=" + temperatura +  "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(mes, temperatura);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temperatura other = (Temperatura) obj;
		return Objects.equals(mes, other.mes) && Objects.equals(temperatura, other.temperatura);
	}
	public int compareTo(Temperatura o) {
		return this.getMes().compareTo(o.getMes());
	}
	
	
	
}
