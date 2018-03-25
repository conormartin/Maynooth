/* Name: Conor MARTIN
Student Number: 17185581*/

#include <iostream>
using namespace std;

int main()
{
  int input,num1,num2,num3,num4,num5;
	//User inputs 5 digit number
	cout << "Please enter a five digit number" << endl;
	cin >> input;
	/*modulo 10 of input gives last digit, divide number by an extra 
	10 each time to get the next digit*/
	num5 = input%10;
	num4 = input/10%10;
	num3 = input/100%10;
	num2 = input/1000%10;
	num1 = input/10000%10;
	//Print final number first to print out numbers in correct number
	cout << num1 << "   " << num2 << "   " << num3 << "   " << num4 << "   " << num5 << "   " 	  << endl;
}
