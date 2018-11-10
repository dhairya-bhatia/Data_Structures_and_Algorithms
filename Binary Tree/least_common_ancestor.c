#include<stdio.h>
#include<stdlib.h>
struct tree
{
    int data;
    struct tree *left,*right;
};
struct tree* CreateNode(int item)
{
    struct tree* nn =(struct tree*)malloc(sizeof(struct tree));
    nn -> data = item;
    nn -> left = nn -> right = NULL;
    return nn;
}

struct tree* Insert(struct tree* root,int item)
{
    if(root == NULL)
    {
        return CreateNode(item);
    }
    if(item > root -> data)
    {
        root -> right = Insert(root -> right,item);
    }
    if(item < root -> data)
    {
        root->left = Insert(root -> left,item);
    }
    return root;
}

struct tree* leastCommonAncestor(struct tree* root , int first , int second)
{
     if(root == NULL)
        return NULL;

    if(root -> data == first || root -> data == second)
        return root;
    struct tree *left = leastCommonAncestor(root -> left , first , second);
    struct tree *right = leastCommonAncestor(root -> right , first , second);
    if(left && right)
        return root;
    if(left != NULL)
        return left;
    else
        return right;
}

int main()
{
    struct tree *root        = CreateNode(20);
    root->left               = CreateNode(8);
    root->right              = CreateNode(22);
    root->left->left         = CreateNode(4);
    root->left->right        = CreateNode(12);
    root->left->right->left  = CreateNode(10);
    root->left->right->right = CreateNode(14);

    struct tree *temp = leastCommonAncestor(root , 14 , 8);
    printf("LCA of 14 and 8 is --> %d ",temp -> data);

    temp = leastCommonAncestor(root , 10 , 14);
    printf("\nLCA of 10 and 14 is --> %d ",temp -> data);
}
