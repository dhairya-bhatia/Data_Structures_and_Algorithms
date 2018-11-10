postorder Using 2 stacks

{
    while(!s1.empty())
    {
        curr = s1.top();

        s1.pop();
        s2.push(curr);
        if(curr->left != NULL)
        {

                s1.push(curr->left);

        }
        if(curr->right != NULL)
        {
                //curr = curr->right;
                s1.push(curr->right);
        }

    }
}
