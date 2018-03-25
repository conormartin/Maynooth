/* Name: Conor MARTIN
Student Number: 17185581*/

#include <iostream>
using namespace std;

int main()
{
	int x,y;
  	cout << "Please enter two numbers: " << endl;
	cin >> x >> y;
	if (x%y==0)
	{
		cout << x << " is a multiple of " << y << endl;
	}
	else
	{
		cout << x << " is not a multiple of " << y << endl;
	}
}
