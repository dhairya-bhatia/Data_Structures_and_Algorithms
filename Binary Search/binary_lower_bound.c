#include<stdio.h>
int main()
{
int arr[20],i,j,n,left,right,mid,num;
printf("Enter num of elemments");
scanf("%d",&n);
printf("Enter number you want to search");
scanf("%d",&num);
for(i=0;i<n;i++)
{
    scanf("%d",&arr[i]);
}
left=0;
right=n-1;
while(left<right)
{
    mid=(left+right)/2;

    if(arr[mid]>=num)
    {
        right=mid;
    }
    else if(arr[mid]<num)
    {
        left=mid+1;
    }
}
    printf("%d",mid);
}
