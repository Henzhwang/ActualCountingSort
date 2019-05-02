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
            //Random rn = new Random();
            //int elements = (int)(Math.random()*1000);
            int elements = 100000000;
//            int arr[]={1,4,7,3,4,5,6,3,4,8,6,4,4};
            int[] arr = new int[elements];
     
            
            for (int i = 0; i < arr.length; i++)
            {  
                //arr[i] = rn.nextInt();
                arr[i] = (int)(Math.random()*1000);
                //System.out.println(arr[count] +" ");
            }
            
            System.out.println(Arrays.toString(arr));
            long start = System.nanoTime();
            long starts = System.currentTimeMillis(); 
            arr=countingSort(arr);
           
            System.out.println("=======================");
            System.out.println("After Sorting : ");
            System.out.println(Arrays.toString(arr));
            long end = System.nanoTime();
            long ends = System.currentTimeMillis();
            System.out.println("Time:" + (end - start) +"ns");
            System.out.println("Time:" + (ends - starts) +"ms");
        }

        static int[] countingSort(int arr[])
        {
            int n = arr.length;
            //System.out.println(n);

            // The array will store sorted array
            int result[] = new int[n];
            //System.out.println(result.length);

            // Initialize count array to store count of indiviual
            int count[] = new int[n];
            for (int i=0; i<n; ++i)
            count[i] = 0;   
           // System.out.println(count.length);
           

            //store count of each element in count array
            for (int i=0; i<n; ++i)
            ++count[arr[i]];

            //Change count[i] so that count[i] now contains actual
            //position of this element in output array
            for (int i=1; i<=n-1; ++i)
            count[i] += count[i-1];
            
            //build the character array
            for (int i = 0; i<n; ++i)
            {
            result[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
            }

//            for (int i = n-1; i>=0; --i)
//                {
//                    result[count[arr[i]]-1] = arr[i];
//                    --count[arr[i]];
//                }
           
            //Copy the result array to arr array
            for (int i = 0; i<n; ++i)
            {
                arr[i] = result[i];
            }

            return result;
        }
    
}