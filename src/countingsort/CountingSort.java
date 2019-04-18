/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countingsort;

/**
 *
 * @author hehua8751
 */

import java.util.*;
import java.util.stream.IntStream;
import java.lang.*;
public class CountingSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
        {
            System.out.println("Before Sorting : ");
            Random rn = new Random();
            int elements = (int)(Math.random()*1000);
//            int arr[]={1,4,7,3,4,5,6,3,4,8,6,4,4};
            int[] arr = new int[elements];
     
            System.out.println(Arrays.toString(arr));
//            for (int i = 0; i < arr.length; i++)
//            {  
//                arr[i] = rn.nextInt();
//                //arr[i] = (int)(Math.random()*i);
//                //System.out.println(arr[count] +" ");
//            }
//            
            arr=countingSort(arr);
            long start = System.nanoTime();
            System.out.println("=======================");
            System.out.println("After Sorting : ");
            System.out.println(Arrays.toString(arr));
            long end = System.nanoTime();
            System.out.println("Time:" + (end - start));
        }

        static int[] countingSort(int arr[])
        {
            int n = arr.length;

            //The result will store sorted array
            int result[] = new int[n];

            //Initialize count array with 9 as array contains elements from range 1 to 8.
            int count[] = new int[9];
            for (int i=0; i<9; ++i)
            count[i] = 0;

            //store count of each element in count array
            for (int i=0; i<n; ++i)
            ++count[arr[i]];

            //Change count[i] so that count[i] now contains actual
            //position of this element in output array
            for (int i=1; i<=8; ++i)
            count[i] += count[i-1];

            for (int i = 0; i<n; ++i)
            {
            result[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
            }

            return result;
        }
    
}