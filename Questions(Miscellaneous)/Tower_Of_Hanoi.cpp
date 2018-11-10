#include <iostream>

using namespace std;

void toh(int n , char source , char helper , char destination)
{

    if(n == 1){
        cout << "Move 1st disk from "<< source << " to " << destination << endl;
        return;
    }
    toh(n - 1 , source ,destination , helper);    //Put n-1 disks from source to helper by using destination
    cout << "Move "<< n << "th disk from " << source << " to " << destination << endl;
    toh(n - 1 , helper , source , destination);    //Put n-1 disks from helper to destination by using source
}
int main()
{
   char a , b , c;
   toh(3 , 'a' , 'b' , 'c');
}
