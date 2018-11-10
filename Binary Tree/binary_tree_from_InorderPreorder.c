#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *left,*right;
};

int index = 0;

void inorder(struct node *root)
{
     if (root != NULL)
    {
        inorder(root -> left);

        inorder(root -> right);
        printf("%d ", root -> data);
    }
}

struct node* createNode(struct node* root , int item)
{
        struct node* nn = (struct node*)malloc (sizeof(struct node));
        nn -> data = item;
        nn -> left = nn -> right = NULL;
        return nn;
}
struct node* Build_Binary_Tree(struct node* root , int *in , int *pre , int start , int end)
{
    int pos,i;
    if(start > end)
        return NULL;
    if(start == end)
    {
        return createNode(root,in[start]);
    }
    else
    {
        for(i = start; i <= end; i++)
         {
             if(in[i] == pre[index])
            {
                pos = i;
                index++;
                break;
            }
         }
         root = createNode(root,in[pos]);
    }
    root -> left = Build_Binary_Tree(root -> left,in,pre,start,pos-1);
    root -> right = Build_Binary_Tree(root -> right,in,pre,pos + 1,end);

    return root;
}
int main()
{
    struct node * root = NULL;
    int in[7] = {4,2,5,1,6,3,7};
    int pre[7] = {1,2,3,4,5,6,7};
    root = Build_Binary_Tree(root , in , pre , 0 , 6);
    inorder(root);
}
