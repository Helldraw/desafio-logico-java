
public class NumerosLoteria {
	public static void main(String[] args) {
		int qtdeNum = 6;

		
		System.out.println("Bem-vindo ao gerador de números para a loteria");
		System.out.println("Segue abaixo números criados de forma aleatoria: ");
		metodo(qtdeNum);
	}
		
	
	static void metodo(int loteria) {
		int[] numeros = new int[loteria];
		for (int i = 0; i < loteria; i++) {
			double randomNumber = Math.random()*60.9;
			numeros[i] = (int)randomNumber;
			if(numeros[i]==0){
				numeros[i]=(int)randomNumber;
				i--;
			}
				for(int j = i-1; j >=0;j--) {
					while(numeros[i] == numeros[j]) {
						randomNumber = Math.random()*60.9;
						System.out.println("Num i: " + numeros[i] + " Num j: " + numeros[j]);
						numeros[i]=(int)randomNumber;
						System.out.println("Novo Num i: " + numeros[i]);
						j = i-1;
					}
				}
		}
		for (int random:numeros) {
			System.out.printf("%02d\n",random);
		}
		
	}
		
}
	