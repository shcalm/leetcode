package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] ret=new int[2];
        for(int i = 0;i<numbers.length;i++){
                for(int j=i+1;j<numbers.length;j++){
                    if(numbers[i] + numbers[j] == target){
                       // int out1 = i+1;
                        //int out2 = j+1;
                        //System.out.println("index1="+ ++i + "index2="+ ++j);
                        ret[0] =++i;
                        ret[1] =++j;
                    }
                }
            
        }
        return ret;
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = A.length;
        int n = B.length;
        int[] all = new int[m+n];
        int i,j,k;
        i =j=k=0;
        while(i < m && j < n){
            if(A[i] < B[j] ){
                all[k]=A[i];
                i++;
                k++;
            }else{
                all[k] = B[j];
                j++;
                k++;
            }
        }
        if(i==m){
            while(j<n){
                all[k++]=B[j++];
            }
        }else{
            while(i<m){
                all[k++] =A[i++];
            }
        }
        //return all[(m+n)/2];
        if((m+n) %2 ==0 ){
            return (double)(all[(m+n)/2] +all[(m+n)/2 -1])/2;
            
        }else{
            return (double)all[(m+n)/2];
        }
        
   /*     double total =0;
        int m = A.length;
        int n = B.length; 
        if(m==0 && n==0)return 0;
        for(int i = 0;i < m;i++){
            total += A[i];
        }
        for(int j = 0;j<n;j++){
            total += B[j];
        }
        return total/(m+n);*/
        
        
    }
    
    private int findNext(int[] num,int i){
    	int k = i+1;
    	int base = num[i];
    	while(k < num.length){
    		if(num[k] != base){
    			return k;
    		}else
    			k++;
    	}
    	return num.length -1;
    }
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(num.length < 4) return list;
        Arrays.sort(num);
        for(int i =0 ; i < num.length -3;i=findNext(num,i))
        	for(int j = i+1;j<num.length -2;j=findNext(num,j))
        		for(int k = j+1;k<num.length-1;k=findNext(num,k)){
        			int tmp = target - (num[i] + num[j] + num[k]) ;
        			if(Arrays.binarySearch(num, k+1,num.length,tmp) >=0){
        				List<Integer> l = new ArrayList<Integer>();
        				l.add(num[i]);
        				l.add(num[j]);
        				l.add(num[k]);
        				l.add(tmp);
        				list.add(l);
        			}
        		}
        return list;
        
    }
    public static void main(String[] args){
    	System.out.println(new Solution().fourSum(new int[]{1 ,0 ,-1, 0, -2 ,2}, 0));
    }
    
}
