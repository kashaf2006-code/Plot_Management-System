#include <iostream>
#include <cmath> //Header file use for basic mathematical formula
using namespace std;
int main ()
{
   int r;
   float area;
   const float  PI =3.142;
   cout<<"Enter the radius: ";
   cin>>r;
   area=2*PI*r*r;
   cout<<"\n The area is :"<<area;
return 0;
}
