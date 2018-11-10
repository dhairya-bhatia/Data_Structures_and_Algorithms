#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
};
struct node *head;

void print()
    {
        struct node *temp = head;
        while (temp != NULL)
        {
            printf("%d\t",temp->data);
            temp = temp->next;
        }
    }
    void push(int data)
{
    struct node *temp=(struct node*) malloc(sizeof(int)*1);
    temp->data=data;
    temp->next=head;
    head=temp;
}
    void main()
    {
       struct node n1,n2,n3,n4,n5;
       n1.data = 1;
       n2.data = 2;
       n3.data = 3;
       n4.data = 4;
       n5.data = 5;
       head=&n1;
       n1.next=&n2;
       n2.next=&n3;
       n3.next=&n4;
       n4.next=&n5;
       n5.next=NULL;

       struct node *slowptr=head;
       struct node *fastptr=head;
       int count=0;

       while(fastptr!=NULL&&fastptr->next)  //fastptr -> next should exist to enter the loop
       {
       // printf("haha\n");
        fastptr=fastptr->next->next;
       slowptr=slowptr->next;
           if(slowptr==fastptr)
           {
               printf("Loop found");
               count++;
               break;
           }
       }
       //printf("abc");
       //printf("%d",count);
       if(count==0)
       {
           printf("No loop found");
       }
    }
