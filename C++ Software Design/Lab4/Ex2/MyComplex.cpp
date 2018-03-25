/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include"MyComplex.h"
using namespace std;

MyComplex::MyComplex(double a, double b)
{
  real=a;
  image=b;
}

MyComplex::MyComplex()
{
  real=0;
  image=0;
}

double MyComplex::getReal()
{
  return real;
}

void MyComplex::setReal(double x)
{
  real = x;
}

double MyComplex::getImage()
{
  return image;
}

void MyComplex::setImage(double y)
  {
    image = y;
  }
  
MyComplex MyComplex::Add(const MyComplex &z)
{
  MyComplex result;
  result.real = real + z.real;
  result.image = image + z.image;
  return result;
}

MyComplex MyComplex::Subtract(const MyComplex &z)
{
  MyComplex result;
  result.real = real - z.real;
  result.image = image - z.image;
  return result;
}

MyComplex MyComplex::Multiply(const MyComplex &z)
{
  MyComplex result;
  result.real = (real*z.real)-(image*z.image);
  result.image = (image*z.real)+(real*z.image);
  return result;
}

void MyComplex::print()
{
  cout << real << " + " << image << "i" << endl;
}