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
void inorder(struct tree *root)
{
    if (root != NULL)
    {
        inorder(root -> left);
        printf("%d ", root -> data);
        inorder(root -> right);
    }
}
struct tree* findMaxNode(struct tree* root)
{
    struct tree* temp = root;
        while(temp -> right != NULL)
        {
            temp = temp -> right;
        }
        return temp;
}
struct tree* deleteNode(struct tree* root,int item)
{
    // if (root == NULL) return root;

        if(item > root -> data)
        {
            root -> right = deleteNode(root -> right,item);
            //printf("a");
        }
        else if(item < root -> data)
        {
            root -> left = deleteNode(root -> left,item);
        }
        if(item == root -> data)
        {
            if(root -> right == NULL)
            {
                struct tree* temp = root -> left;
                free(root);
                return temp;
            }
            else if(root -> left == NULL)
            {
                 struct tree* temp = root -> right;
                free(root);
                return temp;
            }
            else if(root -> right && root -> left)
            {
                struct tree *max = findMaxNode(root -> left);
                root -> data = max -> data;
                root -> left = deleteNode(root -> left , max -> data);
            }
        }
        return root;
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

int calculateFloor(struct tree* root, int item) {
	if(root == NULL)
		return NULL;
	if(root -> data == item)
		return root -> data;
	if(root -> data > item)
		return calculateFloor(root -> left, item);

	if(root -> data < item)
        {
            int ans = root -> data;
            int temp = calculateFloor(root -> right , item);
            if(temp == NULL)
                return ans;
            else
                return temp;
        }
}

int main()
{
    struct tree *root = NULL;
    root = Insert(root,3);
    root = Insert(root,8);
    root = Insert(root,5);
    root = Insert(root,7);
    root = Insert(root,9);
    root = Insert(root,1);
    root = Insert(root,6);
   // printf("%d",root->data);
   printf("Inorder of BST is -> ");
   inorder(root);
   root = deleteNode(root,8);
   printf("\nAfter deleting node 8 from BST \n Inorder is -> ");
   inorder(root);

   int floor = calculateFloor(root , 2);
   printf("\nFloor is %d",floor);
}
