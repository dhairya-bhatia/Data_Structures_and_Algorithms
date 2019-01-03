#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *left,*right;
    int height;
};
struct node* createNode(int item)
{
    struct node* nn = (struct node*)malloc (sizeof(struct node));
    nn -> data = item;
    nn -> left = nn -> right = NULL;
    return nn;
}
struct node* findMaxNode(struct node* root)
{
    struct node* temp = root;
        while(temp -> right != NULL)
        {
            temp = temp -> right;
        }
        return temp;
}
int height_fun(struct node *root)
{
    if(root == NULL)
        return 0;
    else
        1 + max(height_fun(root -> left), height_fun(root -> right));
}

int max(int a , int b)
{
    if(a > b)
        return a;
    else
        return b;
}
struct node* left_rotate(struct node* root)
{
    struct node* temp = root -> right;
    struct node* y = temp -> left;
    temp -> left = root;
    root -> right = y;

    root -> height = 1 + max(height_fun(root -> left), height_fun(root -> right));
    temp -> height = 1 + max(height_fun(temp -> left), height_fun(temp -> right));

    return temp;
}

struct node* right_rotate(struct node* root)
{
    struct node* temp = root -> left;
    struct node* y = temp -> right;
    temp -> right = root;
    root -> left = y;

    root -> height = 1 + max(height_fun(root -> left), height_fun(root -> right));
    temp -> height = 1 + max(height_fun(temp -> left), height_fun(temp -> right));

    return temp;
}

struct node* Insert(struct node* root, int item)
{
    if(root == NULL)
        return createNode(item);
    if(item > root -> data)
        root -> right = Insert(root -> right, item);
    if(item < root ->data)
        root -> left = Insert(root -> left, item);

    int balance = height_fun(root -> left) - height_fun(root -> right);

    if(balance > 1)
    {
        if(height_fun(root -> left ->left) - height_fun(root -> left -> right) >=0)
            root = right_rotate(root);
        else
        {
             root -> left = left_rotate(root);
             root = right_rotate(root);
        }
    }
    else if(balance < -1)
    {
        if(height_fun(root -> right -> right) - height_fun(root -> right ->left) >= 0)
        {
            root = left_rotate(root);
        }
        else
        {
            root -> right = right_rotate(root -> right);
            root = left_rotate(root);
        }

    }
    else
        root -> height = 1 + max(height_fun(root -> left), height_fun(root -> right));

    return root;

}

struct node* Delete(struct node* root, int item)
{
    if(root -> data > item)
        root -> left = Delete(root -> left , item);

    else if(root -> data < item)
        root -> right = Delete(root -> right , item);

    else
    {
        if(root -> left == NULL)
        {
            struct node* temp = root -> right;
            free(root);
            return temp;
        }
        if(root -> right == NULL)
        {
            struct node* temp = root -> left;
            free(root);
            return temp;
        }
        else
            {
                struct node *maxn = findMaxNode(root -> left);
                root -> data = maxn -> data;
                root -> left = Delete(root -> left , maxn -> data);
            }
    }

    int balance = height_fun(root -> left) - height_fun(root -> right);

    if(balance > 1)
    {
        if(height_fun(root -> left ->left) - height_fun(root -> left -> right) >=0)
            root = right_rotate(root);
        else
        {
             root -> left = left_rotate(root);
             root = right_rotate(root);
        }
    }
    else if(balance < -1)
    {
        if(height_fun(root -> right -> right) - height_fun(root -> right ->left) >= 0)
        {
            root = left_rotate(root);
        }
        else
        {
            root -> right = right_rotate(root -> right);
            root = left_rotate(root);
        }

    }
    else
        root -> height = 1 + max(height_fun(root -> left), height_fun(root -> right));

    return root;

}


void inorder(struct node *root)
{
    if (root != NULL)
    {
        inorder(root -> left);
        printf("%d ", root -> data);
        inorder(root -> right);
    }
}

int main()
{
    struct node *root = NULL;
    root = Insert(root,15);
    root = Insert(root,20);
    root = Insert(root,24);
    root = Insert(root,10);
    root = Insert(root,13);
    root = Insert(root,7);
    root = Insert(root,30);
    root = Insert(root,36);
    root = Insert(root,25);
    printf("Inorder of AVL is -> ");
    inorder(root);
    root = Delete(root,13);
    printf("\nAfter deleting node 13 from BST \n Inorder is -> ");
    inorder(root);

}
