import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF{

    public Ordenacao(){}

    @Override
    public boolean checaVetorOrdenado(int[] numeros) {
        for (int i=1; i<numeros.length; i++) {
            if (numeros[i-1] > numeros[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long bubbleSort(int[] numeros) {
        long antes = System.nanoTime();

        int n = numeros.length;

        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (numeros[j] > numeros[j+1]) {
                    swap(numeros, j, j+1);
                }
            }
        }
        
        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long selectionSort(int[] numeros) {
        long antes = System.nanoTime();

        int n = numeros.length;

        for (int i=0; i<n-1; i++) {
            int menorIndex = i;
            for (int j=i+1; j<n; j++) {
                if (numeros[j] < numeros[menorIndex]) {
                    menorIndex = j;
                }
            }
            swap(numeros, i, menorIndex);
        }

        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long insertionSort(int[] numeros) {
        long antes = System.nanoTime();

        for (int i=1; i<numeros.length; i++) {
            int chave = numeros[i];
            int j = i-1;

            while (j >= 0 && numeros[j] > chave) {
                numeros[j+1] = numeros[j];
                j--;
            }

            numeros[j+1] = chave;
        } 

        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long mergeSort(int[] numeros) {
        long antes = System.nanoTime();

        mergeSortRecursivo(numeros, 0, numeros.length - 1);
        
        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long quickSort(int[] numeros) {
        long antes = System.nanoTime();

        quickSort(numeros, 0, numeros.length - 1);

        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long random_quickSort(int[] numeros) {
        long antes = System.nanoTime();

        quickSortPivotRandom(numeros, 0, numeros.length - 1);

        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long quickSort_Java(int[] numeros) {
        long antes = System.nanoTime();

        Arrays.sort(numeros);

        long depois = System.nanoTime();
        return depois-antes;
    }

    @Override
    public long countingSort(int[] numeros) {
        long antes = System.nanoTime();

        int n = numeros.length;

        int k = 0;
        for (int i=0; i<n; i++){
            if (numeros[i] > k) {
                k = numeros[i];
            }
        }

        int[] C = new int[k+1];
        int[] B = new int[n];

        for (int i=0; i<n; i++){
            C[numeros[i]] += 1;
        }

        for (int i=1; i<C.length; i++){
            C[i] += C[i-1];
        }

        for (int i=n-1; i>=0; i--) {
            B[C[numeros[i]]-1] = numeros[i];
            C[numeros[i]] -= 1;
        }
        
        long depois = System.nanoTime();
        return depois-antes;
    }

    private void quickSort(int[] numeros, int inicio, int fim) {
        if (inicio < fim) {
            int pivot = particionar(numeros, inicio, fim);
            quickSort(numeros, inicio, pivot - 1);
            quickSort(numeros, pivot + 1, fim);
        }
    }

    private void quickSortPivotRandom(int[] numeros, int inicio, int fim){
        if (inicio < fim) {
            int pivot = particionar_pivot_random(numeros, inicio, fim);
            quickSort(numeros, inicio, pivot - 1);
            quickSort(numeros, pivot + 1, fim);
        }
    }
    
    private int particionar(int[] numeros, int inicio, int fim) {
        int p = numeros[inicio];
        int i = inicio + 1;
        int j = fim;
    
        while (i <= j) {
            if (numeros[i] <= p) {
                i++;
            } else if (numeros[j] > p) {
                j--;
            } else {
                swap(numeros, i, j);
            }
        }
    
        swap(numeros, inicio, j);
    
        return j;
    }

    private int particionar_pivot_random(int[] numeros, int inicio, int fim){
        Random rand = new Random();
        int randomIndex = rand.nextInt(fim - inicio + 1) + inicio;
        swap(numeros, inicio, randomIndex);

        int p = numeros[inicio];
        int i = inicio + 1;
        int j = fim;

        while (i <= j) {
            if (numeros[i] <= p) {
                i++;
            } else if (numeros[j] > p) {
                j--;
            } else {
                swap(numeros, i, j);
            }
        }

        swap(numeros, inicio, j);

        return j;
    }

    private void mergeSortRecursivo(int[] numeros, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSortRecursivo(numeros, esquerda, meio);
            mergeSortRecursivo(numeros, meio + 1, direita);
            merge(numeros, esquerda, meio, direita);
        }
    }

    private void merge(int[] numeros, int esquerda, int meio, int direita) {
        int i, j, k;
        int[] c = new int[direita - esquerda + 1];
        k = 0;
        i = esquerda;
        j = meio + 1;

        while (i <= meio && j <= direita) {
            if (numeros[i] <= numeros[j]) {
                c[k++] = numeros[i++];
            } else {
                c[k++] = numeros[j++];
            }
        }

        while (i <= meio) {
            c[k++] = numeros[i++];
        }

        while (j <= direita) {
            c[k++] = numeros[j++];
        }

        k = 0;
        for (i = esquerda; i <= direita; i++) {
            numeros[i] = c[k++];
        }
    }

    private void swap(int[] numeros, int i, int j) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }
}
