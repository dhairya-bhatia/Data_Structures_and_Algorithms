#include <iostream>

using namespace std;

string getString(int d)
{
    if(d == 2)
        return "abc";
    if(d == 3)
        return "def";
    if(d == 4)
        return "ghi";
    if(d == 5)
        return "jkl";

    return "";
}

string* keypad(int input , int &outputSize)
{
        if(input == 0)
        {
            string *output = new string[1];
            output[0] = "";
            outputSize = 1;
            return output;
        }
        int lastDigit = input % 10;
        int smallerNumber = input / 10;
        int smallOutputSize;
        string *smallOutput = keypad(smallerNumber , smallOutputSize);

        string lastDigitChars = getString(lastDigit);

        string *output = new string[smallOutputSize * lastDigitChars.size()];

        int k = 0;
        for(int j = 0; j < smallOutputSize; j++)
        {
            for(int i = 0; i < lastDigitChars.size(); i++)
            {
                output[k] = smallOutput[j] + lastDigitChars[i];
                k++;
            }
        }
        outputSize = smallOutputSize * lastDigitChars.size();
        return output;
}

int main()
{
    int size;
    string *output = keypad(23 , size);
    for(int i = 0; i < size; i++)
        cout << output[i] << endl;
}
