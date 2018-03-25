/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

void my_swap(int x, int y)
{
	int z;
	z = x;
	x = y;
	y = z;
	cout << "The value of the first number is now " << x << endl;
	cout << "The value of the second number is now " << y << endl;
}

int main()
{
	int x, y;
	cout << "Please enter two numbers you want to swap: " << endl;
	cin >> x >> y;
	my_swap(x,y);
}

