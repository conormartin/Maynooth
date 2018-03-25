/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

class MyComplex
{
  //protected variables for real and imaginary
protected:
    double real; 
    double image;
    
    
  //public functions to access protected variables
  public:
    //constructor
    MyComplex(double a, double b);
    //default constructor
    MyComplex();
    double getReal();
    void setReal(double x);
    double getImage();
    void setImage(double y);
    
    MyComplex Add(const MyComplex &z);
    MyComplex Subtract(const MyComplex &z);
    MyComplex Multiply(const MyComplex &z);
    void print();
};