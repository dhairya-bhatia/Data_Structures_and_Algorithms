#include<stdio.h>
#include<string.h>
int stringSearch(char* A,char* str)
{
    int len=strlen(str);
    int len2=strlen(A);
    int lps[len];
    lps[0]=0;
    int i=0,j=1,k,x,count=0;

    while(k<len-1)
    {


        if(str[i] == str[j])
        {
            lps[j]=i+1;
        }
        else if(i == 0)
        {
            lps[j] = 0;
            j++;
        }
        else if(i > 0)
        {
            i = lps[i-1];
        }
        k++;
    }
    i=j=0;
    while(i<len2)
    {

        if(A[i] == str[j])
        {
            count++;
            i++;
            j++;
        }

        else
        {
            if(j == 0)
        {
            count=0;
            i=i+1;
        }
        else
            j=lps[j-1];
            count=lps[j-1];
        }
        printf("%d\t",count);
        if(count==len)
            {
                printf("Found");
                break;
            }
    }
}
void main()
{
   // char* ch1 = (char*)malloc(sizeof(char)*20);
   // char* ch2 = (char*)malloc(sizeof(char)*20);
    char ch1[20],ch2[20];
    gets(ch1);
    gets(ch2);

   int res = stringSearch(ch1,ch2);

}
