#include<stdio.h>
void binarySearch(int arr[],int n,int l,int r,int num)
{
    int mid,x;

    if(l<=r)
    {
        mid=(l+r)/2;
    if(arr[mid]==num)
        {
            printf("%d",mid);
            return;
        }
        if(arr[mid]>num)
        {
            binarySearch(arr,n,l,mid-1,num);
        }
        if(arr[mid]<num)
        {
            binarySearch(arr,n,mid+1,r,num);
        }
       // mid=(l+r)/2;
    }
    return 0;
}
int main()
{
    int arr[10],i,j,num,left,right;
    for(i=0;i<8;i++)
    {
        scanf("%d",&arr[i]);
    }
    scanf("%d",&num);
    left=0;
    right=9;
    binarySearch(arr,10,left,right,num);
    //printf("%d",ans);
}
