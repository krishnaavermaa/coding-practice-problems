// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        long sum=waterLevel(0,n,arr);
        
        // Your code here
        return sum;
    } 
    static long waterLevel(int i,int n,int[] arr)
    {
        if(i==n-1) return 0;
        long lrgst=0,sum1=0,smlst=0;
        int index=n-1,j=i+1;
        
        for( ;j<n;j++)
        {
            if(arr[j]>=arr[i])
            {
                lrgst=arr[j];
                index=j;
                break;
            }
            if(arr[j]>lrgst)
            {
                lrgst=arr[j];
                index=j;
            }
        }
        
        if(arr[i]<=arr[index]) smlst=arr[i];
        else smlst=arr[index];
        
        for(int k=i+1;k<index;k++)
        {
            if(arr[k]<smlst) sum1+=arr[k];
            else sum1+=smlst;
        }
        
        
        long sum=smlst*(index-i-1)-sum1;
        //System.out.println(arr[i]+"_largest of small: "+lrgst+"_smallest of the two: "+smlst+"_"+sum);
        return sum+waterLevel(index,n,arr);
    }
}


