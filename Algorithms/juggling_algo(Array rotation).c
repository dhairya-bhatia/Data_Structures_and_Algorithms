#include <stdio.h>

/* function to print an array */
void printArray(int arr[], int size);

/*Fuction to get gcd of a and b*/
int gcd(int a,int b);

/*Function to left rotate arr[] of siz n by d*/
void leftRotate(int arr[], int d, int n)
{
int i, j, k, temp;
for (i = 0; i < gcd(d, n); i++)
{
	/* move i-th values of blocks */
	temp = arr[i];
	j = i;
	while(1)
	{
	k = j + d;
	if (k >= n)
		k = (k - n)%n;
	if (k == i)
		break;
	arr[j] = arr[k];
	j = k;
	}
	arr[j] = temp;
}
}

/*UTILITY FUNCTIONS*/
/* function to print an array */
void printArray(int arr[], int n)
{
int i;
for (i = 0; i < n; i++)
	printf("%d ", arr[i]);
}

/*Fuction to get gcd of a and b*/
int gcd(int a,int b)
{
if (b==0)
	return a;
else
	return gcd(b, a%b);
}

/* Driver program to test above functions */
int main()
{
int arr[] = {3,5,2,1,7,5,9,15,11};
leftRotate(arr, 10, 9);
printArray(arr, 9);
getchar();
return 0;
}
