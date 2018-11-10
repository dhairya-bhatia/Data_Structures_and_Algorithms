#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
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
int isBST(struct tree* root)
{
    return checkBST(root , INT_MIN , INT_MAX);
}

int checkBST(struct tree* root , int min , int max)
{
    if(root == NULL)
        return 1;
    if(root -> data <= min || root -> data >= max)
        return 0;

    int x = checkBST(root -> left , min , root -> data);

    if(x)
        return checkBST(root -> right , root -> data , max);

    return 0;
}

int main()
{
    struct tree *root = CreateNode(7);
    root->left = CreateNode(3);
    root->right = CreateNode(9);
    root->right->left = CreateNode(4);         //This operation makes the tree INVLAID BST
    root->left->right = CreateNode(5);
    int check = isBST(root);
    if(check == 1)
        printf("The tree is Valid BST");
    else
        printf("The tree is not a Valid BST");
}
