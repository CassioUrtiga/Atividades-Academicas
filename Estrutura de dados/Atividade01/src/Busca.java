public class Busca implements Busca_IF{

    public Busca(){}

    @Override
    public int[] geraVetorNumericoOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];

        for (int i=0; i<tamanho; i++){
            vetor[i] = i;
        }

        return vetor;
    }

    @Override
    public boolean buscaLinear_iterativa(int[] numeros, int k) {
        for (int i=0; i<numeros.length; i++){
            if (numeros[i] == k){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscaLinear_recursiva(int[] numeros, int k) {
        return buscaLinearRecursivaAuxiliar(numeros, k, 0);
    }

    @Override
    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k){
        int esquerda = 0;
        int direita = numeros.length - 1;

        while (esquerda <= direita) {
            if (numeros[esquerda] == k || numeros[direita] == k) {
                return true;
            }
            
            esquerda++;
            direita--;
        }

        return false;
    }

    @Override
    public boolean buscaBinaria_iterativa(int[] numeros, int k) {
        int inicio = 0;
        int fim = numeros.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (numeros[meio] == k) {
                return true;
            } else if (numeros[meio] < k) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        
        return false;
    }

    @Override
    public boolean buscaBinaria_recursiva(int[] numeros, int k) {
        return buscaBinariaRecursivaAuxiliar(numeros, k, 0, numeros.length - 1);
    }
    
    private boolean buscaLinearRecursivaAuxiliar(int[] numeros, int k, int indice) {
        
        if (indice >= numeros.length) {
            return false;
        }
    
        if (numeros[indice] == k) {
            return true;
        }
    
        return buscaLinearRecursivaAuxiliar(numeros, k, indice + 1);
    }

    private boolean buscaBinariaRecursivaAuxiliar(int[] numeros, int k, int esquerda, int direita) {
        if (esquerda > direita) {
            return false;
        }
    
        int meio = esquerda + (direita - esquerda) / 2;
    
        if (numeros[meio] == k) {
            return true;
        } else if (numeros[meio] < k) {
            return buscaBinariaRecursivaAuxiliar(numeros, k, meio + 1, direita);
        } else {
            return buscaBinariaRecursivaAuxiliar(numeros, k, esquerda, meio - 1);
        }
    }
}
