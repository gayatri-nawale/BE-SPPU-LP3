import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of items: ");
        int n=sc.nextInt();

        int [] profit=new int[n];
        int [] weight=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter profit and weight: ");
            profit[i]=sc.nextInt();
            weight[i]=sc.nextInt();
        }

        System.out.println("Enter knapsack capacity: ");
        int k=sc.nextInt();

        int dp[][]=new int [n+1][k+1];


        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(weight[i-1]<=j){
                    int include=profit[i-1]+dp[i-1][j-weight[i-1]];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);

                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println("Max profit : "+dp[n][k]);

        System.out.println("Selected items");
        int w=k;
        for(int i=n;i>0;i--){
            if(dp[i][w]!=dp[i-1][w]){
                System.out.println("item : "+i);
                w=w-weight[i-1];
            }
        }
    }
    
}
