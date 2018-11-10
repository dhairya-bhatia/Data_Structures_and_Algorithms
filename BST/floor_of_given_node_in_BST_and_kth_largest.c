#include<stdio.h>
#include<stdlib.h>

int count = 0;

struct tree
{
    struct tree *left,*right;
    int data;
};
struct tree* CreateNode(int item)
{
    struct tree* nn =(struct tree*)malloc(sizeof(struct tree));
    nn -> data = item;
    nn -> left = nn -> right = NULL;
    return nn;
}
void inorder(struct tree *root)
{
    if (root != NULL)
    {
        inorder(root -> left);
        printf("%d ", root -> data);
        inorder(root -> right);
    }
}

void Kth_Largest_element(struct tree* root, int k)
{
    if(root != NULL)
    {
        Kth_Largest_element(root -> right, k);
        count++;
        if(count == k)
            printf("%dth largest element is %d ",k,root -> data);
        Kth_Largest_element(root -> left, k);
    }
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

struct tree* floor_BST(struct tree* root, int item)
{
    if(root == NULL)
        return NULL;

    if(root -> data == item)
        return root;

    if(root -> data > item)
        return floor_BST(root -> left, item);

    else
    {
        struct tree* num1 = root;
        struct tree* num2 = floor_BST(root -> right, item);
        if(num2 == NULL)
            return num1;
        else
            return num2;
    }
}

int main()
{
          /*         7
                  /    \
                 4      10
                /  \    /  \       **Binary Search Tree**
               1    6  8    12
                \
                  2
    */
    struct tree *root = NULL;
    root = Insert(root,7);
    root = Insert(root,4);
    root = Insert(root,10);
    root = Insert(root,1);
    root = Insert(root,6);
    root = Insert(root,8);
    root = Insert(root,12);
    root = Insert(root,2);
    //inorder(root);
   // printf("\n%d ",root -> data);
   struct tree *temp = floor_BST(root,3);
    printf("Floor of element 3 is -> %d \n",temp -> data);
    Kth_Largest_element(root, 4);
    //printf("Kth largest element is %d ",max);
}
