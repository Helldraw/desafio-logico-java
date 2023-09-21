import java.util.Scanner;

public class Mdc {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int n,numeros[];
		System.out.println("Digite quantos numeros deseja digitar para tirar o MDC");
		n = entrada.nextInt();
		numeros = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("digite o " + (i+1) + "º numero");
			numeros[i] = entrada.nextInt();
			if(numeros[i] == 0) {
				System.out.println("O número digitado não pode ser 0");
				i--;
			}
			for(int j = 0; j <= i ; j++) {
				if(numeros[j] > numeros[i]) {
					int a = numeros[j];
					numeros[j] = numeros[i];
					numeros[i] = a;
					
					
				}
				
			}
		}
		System.out.println("----------Números Digitados----------");
		for(int valores:numeros) {
			System.out.println(valores);
		}
		System.out.println("-------------------------------------");
		int w = numeros[0];
		for(int i = numeros[n-1]; i > 0; i--)
		{
			for(int j = 0; j < numeros.length; j++)
			if(numeros[j] % w == 0) {
			}else {
				w--;
			}
		}

			System.out.println("O MDC dos números digitados é: " + w);
		
		entrada.close();
	}
		
}

