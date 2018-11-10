#include<stdio.h>
#include<stdlib.h>
struct stack
{
    int *arr;
    int top;
};
void initialize(struct stack* member,int x)
{
    member->arr = (int*)malloc(sizeof(int)*x);
    member->top = -1;
}
int isEmpty(struct stack* member)
{
    if(member->top == -1)
        return 1;
    else
        return 0;
}
int isFull(struct stack* member,int x)
{
    if(member->top == x-1)
        return 1;
    else
        return 0;
}
void insert(struct stack* member,int x,int element)
{
if(isFull(member,x))
    printf("\nStack is Full");
else
{
    member->top+=1;
    member->arr[member->top] = element;
}
}
void delete(struct stack* member)
{
    if(isEmpty(member))
        printf("\n Stack is already empty");
    else
    {
        member->top-=1;
    }
}
int main()
{
    struct stack *stack = (struct stack*)malloc(sizeof(struct stack*)*1);
    initialize(stack,5);
   int ans = isEmpty(stack);
   printf("%d",ans);
   insert(stack,5,22);
   insert(stack,5,33);
   insert(stack,5,44);
   insert(stack,5,55);
   insert(stack,5,66);
   int a = isFull(stack,5);
   printf("\n%d",a);
       printf("\n

              +g ukd\t",stack->arr[stack->top]);

   return 0;
}
