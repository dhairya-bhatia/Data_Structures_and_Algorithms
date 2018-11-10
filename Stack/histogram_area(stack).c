#include<stdio.h>
#include<stdlib.h>
struct stack
{
    int *arr;
    int top;
};
int size = 10;

void initialize(struct stack *member)
{
    member -> arr = (int*) malloc(sizeof(int) * size);
    int i;
    for(i = 0; i < size; i++)
    {
        member -> arr[i] = 0;
    }
    member -> top = -1;
}
int isEmpty(struct stack *m)
{
    if(m -> top == -1)
        return 1;
    else
        return 0;
}
int isFull(struct stack *m)
{
    if(m -> top == (size - 1))
    {

        return 1;
    }

    else
        return 0;
}

void push(struct stack *m , int element)
{
    if(isFull(m))
    {
        printf("Stack is full");
    }
    m -> top = m -> top + 1;
    m -> arr[m -> top] =  element;
}

void pop(struct stack *m)
{
    if(isEmpty(m))
        printf("Stack is Empty !!");
    else
    {
        m -> top--;
    }
}
int peek(struct stack *m)
{
    return m -> arr[m -> top];
}

int main()
{
    struct stack *st = (struct stack*)malloc(sizeof(struct stack));
    initialize(st);

     /*  *****************Histogram question***********  */

    int height[10] , i , n;
    printf("Enter size of array of heights = ");
    scanf("%d",&n);
    printf("Enter values of histogram heights = \n");
    for(i = 0; i < n; i++)
    {
        scanf("%d",&height[i]);
    }

    int maxarea = -1 , ht , area;
    if(n == 0)
        return 0;
    if(n == 1)
        return height[0];
    else
    {
        for(i = 0; i < n; i++)
        {
            while(!isEmpty(st) && height[peek(st)] >= height[i])
            {
                int temp = height[peek(st)];

                pop(st);
                ht = isEmpty(st)? i : i - peek(st) - 1;
                area = temp * ht;
                if(area > maxarea)
                    maxarea = area;

            }
           // printf("%d\n", i);
            push(st , i);
        }
        while(!isEmpty(st))
        {
            int temp = height[peek(st)];

            pop(st);

            ht = isEmpty(st)? i : i - peek(st) - 1;
            area = temp * ht;
            if(area > maxarea)
                maxarea = area;
        }
        printf("\nMax area of histogram is %d",maxarea);
    }

}
