#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
};
struct node *head;
void insert_first(int x)
{
            struct node *temp=(struct node*) malloc(sizeof(struct node)*1);
            temp->data=x;
            temp->next=head;
            head=temp;
}
void insert_last(int x)
{
    struct node *temp=(struct node*) malloc(sizeof(struct node)*1);
    if(head==NULL)
    {
        insert_first(x);
    }
    else{

    temp->data=x;
    temp->next=NULL;
        struct node *current_node;
        current_node = head;
    while(current_node->next)
    {
        current_node=current_node->next;
    }
        current_node->next=temp;
    }
}
void search(int data)
{
    int count=0;
     struct node *current_node = head;
     while(current_node->next)
     {
         if(current_node->data==data)
         {
             printf("%d found at %d position \n",data,count);
             break;
         }
         else
            count++;
         current_node=current_node->next;
     }


}
/*void reverse()
{
    struct node *prev,*current,*next;
    current=head;
    prev=NULL;
    while(current!=NULL)
    {
        next = current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    head = prev;
    //return head;

}*/
struct node* reverseNode(struct node *first)
{
    struct node *second;
    if(first)
    {
        second=first->next;
    }
    if(second==NULL)
    {
        return first;
    }
    else{
    struct node *current=reverseNode(second);

};
 void print()
    {
        struct node *temp = head;
        while (temp != NULL)
        {
            printf("%d\t",temp->data);
            temp = temp->next;
        }
    }
int main()
{
    int x,index,data;
    printf("Enter number");
    scanf("%d",&x);
    insert_first(x);
    insert_first(20);
    insert_first(30);
    print();
    printf("-----------");
    insert_last(23);
    printf("Enter index at which u want to insert");
    scanf("%d",&index);
    insert(x,index);
    search(20);
    reverse();
    print();
    //t->reverse=NULL;
    return 0;
}
