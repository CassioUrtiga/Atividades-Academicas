import java.util.Random;

public class BrincandoComOrdenacao {
    public static void main(String[] args) throws Exception {
        Ordenacao_IF ordenacao = new Ordenacao();

        int iteractions = 50;
        int tamanho = 10;

        int[] array1 = array_ordenado_crescente(tamanho);
        int[] array2 = array_ordenado_decrescente(tamanho);
        int[] array3 = array_aleatorio(tamanho);

        // 0-crescente , 1-decrescente, 2-aleatorio
        long[][] temposInsertion = new long[3][iteractions];
        long[][] temposSelection = new long[3][iteractions];
        long[][] temposMerge = new long[3][iteractions];
        long[][] temposBubble = new long[3][iteractions];
        long[][] temposQuick = new long[3][iteractions];
        long[][] temposRandomQuick = new long[3][iteractions];
        long[][] temposQuickJava = new long[3][iteractions];
        long[][] temposCounting = new long[3][iteractions];

        long[][] soma_bubble = new long[3][1];
        long[][] soma_selection = new long[3][1];
        long[][] soma_insertion = new long[3][1];
        long[][] soma_merge = new long[3][1];
        long[][] soma_quick = new long[3][1];
        long[][] soma_random_quick = new long[3][1];
        long[][] soma_quick_java = new long[3][1];
        long[][] soma_counting = new long[3][1];

        for (int i=0; i<iteractions; i++) {
            temposBubble[0][i] = ordenacao.bubbleSort(array1.clone());
            temposBubble[1][i] = ordenacao.bubbleSort(array2.clone());
            temposBubble[2][i] = ordenacao.bubbleSort(array3.clone());

            temposSelection[0][i] = ordenacao.selectionSort(array1.clone());
            temposSelection[1][i] = ordenacao.selectionSort(array2.clone());
            temposSelection[2][i] = ordenacao.selectionSort(array3.clone());

            temposInsertion[0][i] = ordenacao.insertionSort(array1.clone());
            temposInsertion[1][i] = ordenacao.insertionSort(array2.clone());
            temposInsertion[2][i] = ordenacao.insertionSort(array3.clone());

            temposMerge[0][i] = ordenacao.mergeSort(array1.clone());
            temposMerge[1][i] = ordenacao.mergeSort(array2.clone());
            temposMerge[2][i] = ordenacao.mergeSort(array3.clone());

            temposQuick[0][i] = ordenacao.quickSort(array1.clone());
            temposQuick[1][i] = ordenacao.quickSort(array2.clone());
            temposQuick[2][i] = ordenacao.quickSort(array3.clone());

            temposRandomQuick[0][i] = ordenacao.random_quickSort(array1.clone());
            temposRandomQuick[1][i] = ordenacao.random_quickSort(array2.clone());
            temposRandomQuick[2][i] = ordenacao.random_quickSort(array3.clone());

            temposQuickJava[0][i] = ordenacao.quickSort_Java(array1.clone());
            temposQuickJava[1][i] = ordenacao.quickSort_Java(array2.clone());
            temposQuickJava[2][i] = ordenacao.quickSort_Java(array3.clone());

            temposCounting[0][i] = ordenacao.countingSort(array1.clone());
            temposCounting[1][i] = ordenacao.countingSort(array2.clone());
            temposCounting[2][i] = ordenacao.countingSort(array3.clone());
        }

        for (int i=0; i<iteractions; i++){
            soma_bubble[0][0] += temposBubble[0][i];
            soma_bubble[1][0] += temposBubble[1][i];
            soma_bubble[2][0] += temposBubble[2][i];

            soma_selection[0][0] += temposSelection[0][i];
            soma_selection[1][0] += temposSelection[1][i];
            soma_selection[2][0] += temposSelection[2][i];

            soma_insertion[0][0] += temposInsertion[0][i];
            soma_insertion[1][0] += temposInsertion[1][i];
            soma_insertion[2][0] += temposInsertion[2][i];

            soma_merge[0][0] += temposMerge[0][i];
            soma_merge[1][0] += temposMerge[1][i];
            soma_merge[2][0] += temposMerge[2][i];

            soma_quick[0][0] += temposQuick[0][i];
            soma_quick[1][0] += temposQuick[1][i];
            soma_quick[2][0] += temposQuick[2][i];

            soma_random_quick[0][0] += temposRandomQuick[0][i];
            soma_random_quick[1][0] += temposRandomQuick[1][i];
            soma_random_quick[2][0] += temposRandomQuick[2][i];

            soma_quick_java[0][0] += temposQuickJava[0][i];
            soma_quick_java[1][0] += temposQuickJava[1][i];
            soma_quick_java[2][0] += temposQuickJava[2][i];

            soma_counting[0][0] += temposCounting[0][i];
            soma_counting[1][0] += temposCounting[1][i];
            soma_counting[2][0] += temposCounting[2][i];
        }

        System.out.println("Media crescente bubble: " + soma_bubble[0][0]/iteractions);
        System.out.println("Media decrescente bubble: " + soma_bubble[1][0]/iteractions);
        System.out.println("Media aleatoria bubble: " + soma_bubble[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente selection: " + soma_selection[0][0]/iteractions);
        System.out.println("Media decrescente selection: " + soma_selection[1][0]/iteractions);
        System.out.println("Media aleatoria selection: " + soma_selection[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente insertion: " + soma_insertion[0][0]/iteractions);
        System.out.println("Media decrescente insertion: " + soma_insertion[1][0]/iteractions);
        System.out.println("Media aleatoria insertion: " + soma_insertion[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente merge: " + soma_merge[0][0]/iteractions);
        System.out.println("Media decrescente merge: " + soma_merge[1][0]/iteractions);
        System.out.println("Media aleatoria merge: " + soma_merge[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente quick: " + soma_quick[0][0]/iteractions);
        System.out.println("Media decrescente quick: " + soma_quick[1][0]/iteractions);
        System.out.println("Media aleatoria quick: " + soma_quick[2][0]/iteractions);
        
        System.out.println();

        System.out.println("Media crescente random quick: " + soma_random_quick[0][0]/iteractions);
        System.out.println("Media decrescente random quick: " + soma_random_quick[1][0]/iteractions);
        System.out.println("Media aleatoria random quick: " + soma_random_quick[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente quick java: " + soma_quick_java[0][0]/iteractions);
        System.out.println("Media decrescente quick java: " + soma_quick_java[1][0]/iteractions);
        System.out.println("Media aleatoria quick java: " + soma_quick_java[2][0]/iteractions);

        System.out.println();

        System.out.println("Media crescente counting: " + soma_counting[0][0]/iteractions);
        System.out.println("Media decrescente counting: " + soma_counting[1][0]/iteractions);
        System.out.println("Media aleatoria counting: " + soma_counting[2][0]/iteractions);
    }

    public static int[] array_ordenado_crescente(int tamanho){
        int[] array = new int[tamanho];

        for (int i=0; i<tamanho; i++){
            array[i] = i;
        }

        return array;
    }

    public static int[] array_ordenado_decrescente(int tamanho){
        int[] array = new int[tamanho];

        for (int i=0; i<tamanho; i++) {
            array[i] = tamanho-i-1;
        }

        return array;
    }

    public static int[] array_aleatorio(int tamanho){
        int[] array = new int[tamanho];
        Random random = new Random();

        for (int i=0; i<tamanho; i++){
            array[i] = random.nextInt(tamanho);
        }
        
        return array;
    }
}
