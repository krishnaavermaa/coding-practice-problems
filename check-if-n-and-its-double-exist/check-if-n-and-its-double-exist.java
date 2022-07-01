import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {
        qsort(arr,0,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            int j=arr[i]*2;
            for(int k=0;k<arr.length;k++)
            {
                
                if(arr[k]==j && i!=k) return true;
                if(arr[k]>j) break;
            }
        }
        return false;
    }
    private void qsort(int arr[],int p,int si,int ei)
    {
        if(ei<si) return;
        int s=si,e=ei;
        while(e>s)
        {
            while(arr[s]<=arr[p])
            {
                s++;
                if(s>ei) {
                    s--;
                    break;
                }
            }
            while(arr[p]<arr[e])
            {
                e--;
                if(e<si) {
                    e++;
                    break;
                }
            }
            if(e<s) 
            {
                s--;
                e++;
                break;
            }
            int tmp=arr[s];
            arr[s]=arr[e];
            arr[e]=tmp;
            
        }
        int tmp=arr[s];
        arr[s]=arr[p];
        arr[p]=tmp;
        qsort(arr,p,p,s-1);
        qsort(arr,s+1,s+1,ei);
    }
        
}