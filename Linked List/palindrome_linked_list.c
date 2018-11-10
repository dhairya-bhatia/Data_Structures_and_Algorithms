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

int isPalindrome(struct node *curr)
{
    if(curr == NULL)
        return 1;
    else
    {
        int x = isPalindrome(curr -> next);
        if(x == 1)
        {
            if(head -> data == curr -> data)
            {
                head = head -> next;
                return 1;
            }
        }
        else
            return 0;
    }
}

int main()
{
    push(5);
    push(6);
    push(7);
    push(6);
    push(5);

    int ans = isPalindrome(head);
    if(ans == 1)
        printf("Palindrome");
    else
        printf("Not Palindrome");
}
