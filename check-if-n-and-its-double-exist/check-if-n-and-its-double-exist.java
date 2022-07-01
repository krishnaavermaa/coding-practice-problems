import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {
        qsort(arr,0,0,arr.length-1);
        // for(int i=0;i<arr.length;i++)
        //     System.out.print(arr[i]+" ");
        // System.out.println();
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
        // System.out.println("**FOR:");
        // for(int i=0;i<arr.length;i++)
        //     System.out.print(arr[i]+" ");
        // System.out.println("\n**");
        if(ei<si) return;
        int s=si,e=ei;
        // System.out.println("INSIDE START");
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
            // for(int i=0;i<arr.length;i++)
            //     System.out.print(arr[i]+" ");
            // System.out.println();
            
        }
        // System.out.println("INSIDE END");
        // System.out.println("for "+arr[p]+" at index "+p+" s="+s+" e="+e);
        int tmp=arr[s];
        arr[s]=arr[p];
        arr[p]=tmp;
        // for(int i=0;i<arr.length;i++)
        //     System.out.print(arr[i]+" ");
        // System.out.println();
        qsort(arr,p,p,s-1);
        qsort(arr,s+1,s+1,ei);
    }
        
}