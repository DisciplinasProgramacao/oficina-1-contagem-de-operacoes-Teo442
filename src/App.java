import java.util.Random;

/** 
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 *                       Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class App {
    static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);

    /**
     * Código de teste 1. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo1(int[] vetor) {
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i]%2;
        }
        return resposta;
    }

    /**
     * Código de teste 2. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }

        }
        return contador;
    }

    /**
     * Código de teste 3. Este método...
     * @param vetor Vetor com dados para teste.
     */
    static void codigo3(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    /**
     * Código de teste 4 (recursivo). Este método...
     * @param n Ponto inicial do algoritmo
     * @return Um inteiro que significa...
     */
    static int codigo4(int n) {
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
        
    }
    public static void main(String[] args) {
        // para cada código, 
        // itere sobre o array de tamanhos de teste correspondente
        // rode o código, 
        // salve o tempo de execução do mesmo.
        // marcar o tempo de inicio 
        // marcar o tempo e fim 

        // código 1
        System.out.println("Resultados para codigo1:");
        for (int i = 0; i < tamanhosTesteGrande.length; i++) {
            int tamanho = tamanhosTesteGrande[i];
            int[] vetor = gerarVetor(tamanho);
            // para marcar o inicio usando nanossegundos 
            long inicio = System.nanoTime(); 
            int resultado = codigo1(vetor);
            // para marcar o fim usando nanossegundos 
            long fim = System.nanoTime();
            System.out.println("N = " + tamanho + ", Tempo = " + (fim - inicio) + " ns, Resultado = " + resultado);
        }

        // código 2
        System.out.println("\nResultados para codigo2:");
        for (int i = 0; i < tamanhosTesteGrande.length; i++) {
            int tamanho = tamanhosTesteGrande[i];
            int[] vetor = gerarVetor(tamanho);
            // para marcar o inicio usando nanossegundos 
            long inicio = System.nanoTime();
            int resultado = codigo2(vetor);
            // para marcar o fim usando nanossegundos 
            long fim = System.nanoTime();
            System.out.println("N = " + tamanho + ", Tempo = " + (fim - inicio) + " ns, Resultado = " + resultado);
        }

         // codigo3
         System.out.println("\nResultados para codigo3:");
         for (int i = 0; i < tamanhosTesteMedio.length; i++) {
             int tamanho = tamanhosTesteMedio[i];
             int[] vetor = App.gerarVetor(tamanho);
             // para marcar o inicio usando nanossegundos 
             long inicio = System.nanoTime();
             App.codigo3(vetor);
             // para marcar o fim usando nanossegundos 
             long fim = System.nanoTime();
             System.out.println("N = " + tamanho + ", Tempo = " + (fim - inicio) + " ns");
         }
         
         // codigo4
         System.out.println("\nResultados para codigo4:");
         for (int i = 0; i < tamanhosTestePequeno.length; i++) {
             int tamanho = tamanhosTestePequeno[i];
             // para marcar o inicio usando nanossegundos 
             long inicio = System.nanoTime();
             int resultado = App.codigo4(tamanho);
             // para marcar o fim usando nanossegundos 
             long fim = System.nanoTime();
             System.out.println("N = " + tamanho + ", Tempo = " + (fim - inicio) + " ns, Resultado: " + resultado);
         }
    }
}
