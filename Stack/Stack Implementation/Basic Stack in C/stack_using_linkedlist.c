#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
};
struct node *head;
void push(int data)
{
    struct node *temp=(struct node*) malloc(sizeof(int)*1);
    temp->data=data;
    temp->next=head;
    head=temp;
}
int pop()
{
    struct node *temp = head;
    head=head->next;
    int data =temp->data;
    free(temp);
    return data;
}
int peek()
{
    return head->data;  //JUST RETURNS FIRST ELEMENT
}
int isEmpty()
{
    return !head;  //IF IT WILL BE EMPTY IT WILL RETURN !(NULL)=!0=1 i.e. EMPTY
}
int main()
{
    push(5);
    push(6);
    push(7);
    push(8);
    push(9);
    printf("%d\n",isEmpty());
    for(int i=0;i<5;i++)
    {
        printf("%d\n",head->data);
        head=head->next;
    }

}
