package com.coderising.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){ 
		for (int i = 0; i < origin.length/2; i++) {
			int temp = origin[i];
			origin[i] = origin[origin.length-i-1];
			origin[origin.length-i-1] = temp;
		}
	}
	
	public static void main(String[] args) {
		ArrayUtil util = new ArrayUtil();
		int[] origin = new int[]{1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
//		System.out.println(Arrays.toString(util.removeZero(origin)));
		
		int[] a1 = {3, 5, 7,8};
		int[] a2 = {4, 5, 6,7};
//		System.out.println(Arrays.toString(util.merge(a1, a2)));
		System.out.println(Arrays.toString(util.fibonacci(15)));
		
		System.out.println(Arrays.toString(util.getPrimes(23)));
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public int[] removeZero(int[] oldArray){
		int[] newArray = new int[oldArray.length];
		int j = 0;
		for (int i = 0; i < oldArray.length; i++) {
			if(oldArray[i] != 0){
				newArray[j] = oldArray[i];
				j++;
			}
		}
		return Arrays.copyOf(newArray, j);
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		
		  //Set是不允许重复的，所以将数组的值全部放在Set对象中  
        Set set = new HashSet<Integer>();  
          
        for(int i = 0; i < array1.length ; i++){  
            set.add(array1[i]);  
        }  
          
        for(int i = 0; i < array2.length ; i++){  
            set.add(array2[i]);  
        }  
        
        Iterator i = set.iterator();  
        int[] arrays = new int[set.size()];  
        int num=0;  
        while(i.hasNext()){  
            int a = (Integer)i.next();  
            arrays[num] = a;  
            num = num + 1;  
        }  
          
        //对结果进行排序  
        Arrays.sort(arrays);
        return arrays;
	}
	/** 
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int[] newArray = new int[oldArray.length + size];
		System.arraycopy(oldArray, 0, newArray, 0, newArray.length);
		return newArray;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		List<Integer> list = new ArrayList<Integer>();
		int f1 = 1, f2 = 1, f = 0;
		list.add(f1);
		list.add(f2);
		while(f < max){
			f = f1+f2;
			f1 = f2;
			f2 = f;
			list.add(f);
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < max; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if ( i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag){
				list.add(i);
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		 List<Integer> list = new ArrayList<Integer>();
		 for (int i = 1; i <= max; i++){
	            int sum=0;
	            for (int j = 1; j < i; j++){
		            if(i%j==0){
		                sum+=j;
		            }   
	            }
	            if(i==sum){
	            	list.add(sum);
	            }
	        }
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str += seperator+array[i];
		}
		return str.substring(1);
	}
}
