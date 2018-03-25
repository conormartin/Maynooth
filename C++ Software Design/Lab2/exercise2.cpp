/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

int gdc(int x, int y)
{
	int gdc;	
	for(int i=1; i<=x || i<=y; i++)
	{
		if(x%i==0 && y%i==0)
		{
			gdc = i;
		}
	}
	return gdc;
}

int main()
{
	int x,y;
	cout << "Please enter two numbers to find the highest common denominator of those numbers: " << endl;
	cin >> x >> y;
	cout << gdc(x,y) << " is the highest common denominator of " << x << " and " << y << endl;
}
