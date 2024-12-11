import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[] arr = {2, 1, 2, 3, 4, 8, 0, 0, 10};
        System.out.println("Количество четных чисел в массиве " + Arrays.toString(arr) + " равное "+ countEvens(arr));
        System.out.println("Разница между самым большим и самым маленьким элементами "+ defferentNumbers(arr));
        System.out.println(hasZero(arr));
//        BigDecimal a = BigDecimal.valueOf(9999999);
//        Scanner scanner = new Scanner(System.in);
//        BigDecimal b = scanner.nextBigDecimal();
//          int [] arr ={11,2,2,2,2,2,33,3,3,4,5,6,11,6,6,10};
//          System.out.println(Arrays.toString(countSort(arr)));
//        int num = 7;
//        int [] result = addNumber(arr,num);

//        System.out.println(Arrays.toString(addIndex(arr, num, 10)));
    }
// Метод позволяет добавлять элемент в конец существующего массива [1,2,3,4]->[1,2,3,4,5] 
    public  static int [] addNumber(int[] arr, int num) {
        int [] tmArr = new int[arr.length + 1];
        for (int i = 0; i <arr.length ; i++) {
            tmArr [i] = arr[i];
        }
        tmArr [arr.length] = num;
        return tmArr;
    }

// Метод поволяет добваить элемент в массив, выбранное место  [1,2,3]->[1,9,2,3] добавили 9 на место 2
    public static int [] addIndex(int[] arr, int num, int index ){
        if (!(index>=0 && index<= arr.length)){
            return null;
        } else if (index == arr.length) {
            return addNumber(arr, num);
        }else {
            int tmp = 0;
            int[] tmArr = new int[arr.length +1];
            for (int i = 0; i < arr.length +1 ; i++) {
                if (index == i){
                    tmArr [i] =num;
                    tmp++;
                }else{
                    tmArr[i] = arr[i-tmp];
                }
            }
            return tmArr;
          }
        }


// метод позволяет отсортировать массив по возрасстанию [1,2,33,9,17] -> [1,2,9,17,33]

    public static int[] countSort(int[] arr){
        int[] secondArr = new int[arr.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1 );
        }
        System.out.println("Map: " + map);

        int i =0;
        for (Integer key: map.keySet()){
            for (int j = 0; j <map.get(key) ; j++) {
                secondArr[i] = key;
                i++;
            }
        }

        return secondArr;
    }


    public static int countEvens(int[] arr){
        int cnt =0;
        for (int num : arr) {
            if(num%2 ==0){cnt++;}
        }
        return cnt;
    }

    public static int defferentNumbers(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){max = arr[i];}
            if(min > arr[i]){min = arr[i];}
        }return max -min;


    }

    public static boolean hasZero(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            if(arr[i] ==0 && arr[i+1] ==0 ){return true;}
        }
        return false;
    }
}




























