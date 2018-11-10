#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *left,*right;
};
int max(int a,int b)
{
    if(a > b)
        return a;
    else
        return b;
}
int height(struct node* root)
{
    if(root == NULL)
        return 0;

        else
            return(1+max(height(root -> left),height(root -> right)));
}
int diameter(struct node* root)
{
    int lheight,rheight,max = 0;
    while(root -> left || root -> right){
        lheight = height(root -> left);
        rheight = height(root -> right);
        int ht = lheight + rheight + 1;
        if(ht > max)
            max = ht;
        if(lheight > rheight)
            root = root -> left;
        else
            root = root -> right;
    }
    return max;
}
struct node* newNode(int item)
{
    struct node* nn = (struct node*)malloc (sizeof(struct node));
    nn -> data = item;
    nn -> left = NULL;
    nn -> right = NULL;
    return nn;
}
int main()
{
    struct node *root = newNode(1);
  root -> left = newNode(2);
  root -> right = newNode(3);
  root -> left->left = newNode(4);
  root -> left->right = newNode(5);
  int diam = diameter(root);
  printf("%d ",diam);

}
