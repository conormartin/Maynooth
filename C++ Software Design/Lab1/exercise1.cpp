/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

int main()
{
	int x,y,z;
	//Ask user to input three numbers
  	cout << "Please enter three numbers: " << endl;
	cin >> x >> y >> z;
	//Equations to find sum, average and product
	cout << "The sum of these numbers is: " << x+y+z << endl;
	cout << "The average of these numbers is: " << (x+y+z)/3 << endl;
	cout << "The product of these numbers is: " << x*y*z << endl;

	//Find the largest and smallest numbers using if and else statements
//Largest
	if (x>y && x>z)
	{	
		cout << "The largest of these numbers is: " << x << endl;
	}
	else if (y>x && y>z)
	{
		cout << "The largest of these numbers is: " << y << endl;
	}
	else
	{
		cout << "The largest of these numbers is: " << z << endl;
	}

//Smallest

	if (x<y && x<z)
	{	
		cout << "The smallest of these numbers is: " << x << endl;
	}
	else if (y<x && y<z)
	{
		cout << "The smallest of these numbers is: " << y << endl;
	}
	else
	{
		cout << "The smallest of these numbers is: " << z << endl;
	}
}
