#include<stdio.h>
int binary_search(int *arr,int n,int num)
{
    int left=0,right=n;
    int mid;
    while(left<right)
    {
        mid=(left+right)/2;
        if(arr[mid]<=num)
        {
            left=mid+1;
        }
        else if(arr[mid]>num)
        {
            right=mid;
        }
    }
    return right;

}
    int main(){
        int arr[20],i,j,num,n;
        scanf("%d",&n);
        for(i=0;i<n;i++)
        {
            scanf("%d",&arr[i]);
        }
        printf("\nEnter number you want to search\n");
        scanf("%d",&num);
        int ans =binary_search(arr,n,num);
        printf("\nAns is %d\t",ans);
}
