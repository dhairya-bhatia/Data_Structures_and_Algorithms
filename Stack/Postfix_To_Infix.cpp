#include <iostream>
#include<string.h>
#include<stdlib.h>
#include<stack>
using namespace std;

int main()
{
    stack<int> st;
    char str[50];
    cin.getline(str,sizeof(str));
    int len = strlen(str);
    int i , temp , x , y;
    for(i = 0; i < len; i++)
    {
        if(str[i] >= '0' && str[i] <= '9')
        {
            st.push(str[i] - '0');
            while(str[i + 1] != ' ')
            {
                i++;
                temp = st.top();
                st.pop();
                temp = temp * 10 + (int)str[i] - '0';
                st.push(temp);
            }
        }
        else
        {
            if(str[i] == '+')
            {
                x = st.top();
                st.pop();
                y = st.top();
                st.pop();
                st.push(y + x);
            }
            if(str[i] == '-')
            {
                x = st.top();
                st.pop();
                y = st.top();
                st.pop();
                st.push(y - x);
            }
            if(str[i] == '*')
            {
                x = st.top();
                st.pop();
                y = st.top();
                st.pop();
                st.push(y * x);
            }
            if(str[i] == '/')
            {
                x = st.top();
                st.pop();
                y = st.top();
                st.pop();
                st.push(y / x);
            }
        }

    }
    int ans = st.top();
    cout << ans;
}
