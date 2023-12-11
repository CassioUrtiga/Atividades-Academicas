public class BrincandoComJava {
    public static void main(String[] args) {
        Busca b = new Busca();
		final int numeroParaBuscar = 0; 
		
		final int[] vetor1000 = b.geraVetorNumericoOrdenado(1000);
		
		long antes, depois;
		
		antes = System.nanoTime();
		System.out.println(b.buscaLinear_iterativa(vetor1000, numeroParaBuscar));
		depois = System.nanoTime();
		System.out.println("Tempo: " + (depois-antes));
		
		
		antes = System.nanoTime();
		System.out.println(b.buscaLinear_iterativa_duasPontas(vetor1000, numeroParaBuscar));
		depois = System.nanoTime();
		System.out.println("Tempo: " + (depois-antes));

		antes = System.nanoTime();
		System.out.println(b.buscaLinear_recursiva(vetor1000, numeroParaBuscar));
		depois = System.nanoTime();
		System.out.println("Tempo: " + (depois-antes));
		
		antes = System.nanoTime();
		System.out.println(b.buscaBinaria_iterativa(vetor1000, numeroParaBuscar));
		depois = System.nanoTime();
		System.out.println("Tempo: " + (depois-antes));
		
		antes = System.nanoTime();
		System.out.println(b.buscaBinaria_recursiva(vetor1000, numeroParaBuscar));
		depois = System.nanoTime();
		System.out.println("Tempo: " + (depois-antes));
	}
}
