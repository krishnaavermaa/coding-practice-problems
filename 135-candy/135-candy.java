class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==1) return 1;
        
        int len=ratings.length;
        boolean check[]=new boolean[len];
        int candy[]=new int[len];
        int min=0;
        
        Arrays.fill(candy,0);
        Arrays.fill(check,false);
        
        for(int i=0;i<len;i++)
        {
            // System.out.println();
            // System.out.println("for "+i+": "+check[i]);
            //System.out.println();
            if(check[i]==true) continue;
            updateCandy(check,ratings,candy,i);
        }
        for(int i=0;i<len;i++){
            // System.out.print(candy[i]+" ");
            min+=candy[i];
        }
        return min;
    }
    public void updateCandy(boolean check[],int ratings[], int []candy,int i)
    {
        // System.out.println("START i="+i+" "+check[i]);
        if(check[i]==true) return;
        int pr=i>0?ratings[i-1]:-1;
        int nr=i<ratings.length-1?ratings[i+1]:-1;
        int cr=ratings[i];
        if(pr==-1)
        {
            // System.out.println(i+" pr=-1");
            if(nr>=cr){
                candy[i]=1;
                // System.out.println("*\t"+i+" candy="+candy[i]);//***********
            }
            else {
                updateCandy(check,ratings,candy,i+1);
                candy[i]=candy[i+1]+1;
                // System.out.println("*\t"+i+" candy="+candy[i]);//***********
            }
        }
        else if(nr==-1)
        {
            // System.out.println(i+" nr=-1");
            if(pr>=cr){
                candy[i]=1;
                // System.out.println("*\t"+i+" candy="+candy[i]);//***********
            }
            else {
                updateCandy(check,ratings,candy,i-1);
                candy[i]=candy[i-1]+1;
                // System.out.println("*\t"+i+" candy="+candy[i]);//***********
            }
        }
        else if(cr<=pr && cr<=nr)
        {
            // System.out.println(i+" cr<=pr && cr<=nr");
            candy[i]=1;
            // System.out.println("*\t"+i+" candy="+candy[i]);//***********
        }
        else if(cr>pr && cr<=nr)
        {
            // System.out.println(i+" cr>pr && cr<=nr");
            updateCandy(check,ratings,candy,i-1);
            candy[i]=candy[i-1]+1;
            // System.out.println("*\t"+i+" candy="+candy[i]);//***********
        }
        else if(cr>nr && cr<=pr)
        {
            // System.out.println(i+" cr>nr && cr<=pr");
            updateCandy(check,ratings,candy,i+1);
            candy[i]=candy[i+1]+1;
            // System.out.println("*\t"+i+" candy="+candy[i]);//***********
        }
        else if(cr>pr && cr>nr)
        {
            // System.out.println(i+" cr>pr && cr>nr");
            updateCandy(check,ratings,candy,i-1);
            updateCandy(check,ratings,candy,i+1);
            candy[i]=Math.max(candy[i-1],candy[i+1])+1;
            // System.out.println("*\t"+i+" candy="+candy[i]);//***********
        }
        check[i]=true;
        // System.out.println("END i="+i+" "+check[i]);
    }
}