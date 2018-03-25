/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include"MyComplex.h"
using namespace std;

int main()
{
    MyComplex num1;
    num1.setReal(5.5);
    num1.setImage(2.1);
    double num1Real = num1.getReal();
    double num1Image = num1.getImage();
    MyComplex num2(3.5, 5.5);
    double num2Real = num2.getReal();
    double num2Image = num2.getImage();

    //Addition function call
    MyComplex numAdd(num1.Add(num2));
    cout << "The sum of " << num1Real << " + " << num1Image << " and " << num2Real << " + " << num2Image << "i is ";
    numAdd.print(); 

    //Subtraction function call
    MyComplex numSub(num1.Subtract(num2));
    cout << num1Real << " + " << num1Image << " minus " << num2Real << " + " << num2Image << "i is : ";
    numSub.print();

    MyComplex numMult(num1.Multiply(num2));
    numMult.print();


}