#include<stdio.h>
void main()
{
    int i,n,arr[100];
    scanf("%d",&n);
    arr[0]=5;
    arr[1]=25;
    printf("5\t25\t");
    for(i=2;i<n;i++)
    {
        if(i%2!=0)
        {
            arr[i]=arr[i-2]*arr[0];
        }
       else if(i%2==0)
        {

        arr[i]=arr[i-1]+arr[0];
        }

        printf("%d\t",arr[i]);
    }
}
