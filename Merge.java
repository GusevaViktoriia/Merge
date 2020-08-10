import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge {
    public static void main(String[] args) {
        int N;
        int[] array1;
        try {
            BufferedReader index = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(index.readLine());
            array1 = new int[N];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for(int i=0; i<=N-1; i++) {
                int a = Integer.parseInt(reader.readLine());
                array1[i]=a;
            }

            int[] buffer = new int[array1.length];
            int[] result = sort(array1, buffer, 0, buffer.length);;

            for (int x : result)
                System.out.print(x+" ");

            index.close();
            reader.close();
        }

        catch (NumberFormatException| IOException e){
            System.out.print(e);
        }

    }

    public static int[] sort(int[] array, int[] buffer, int a, int r) {
        if (array == null) {      //проверка массива на наличие элементов
            return null;
        }

        if (a >= r - 1) { //проверка массива на количество элементов
            return array;
        }

        int middle =  (r + a) / 2;
        int[] array_first = sort(array, buffer, a, middle);
        int[] array_second = sort(array, buffer, middle, r);

        int index = middle;
        int q = a;

        int[] result;
        if (array_first == array) {
            result = buffer;
        }
        else {
            result = array;
        }

        while (a < middle && index < r) {
            result[q++] = array_first[a] < array_second[index] ? array_first[a++] : array_second[index++];
        }
        while (a < middle) {
            result[q++] = array_first[a++];
        }
        while (index < r) {
            result[q++] = array_second[index++];
        }
        return result;
    }
}