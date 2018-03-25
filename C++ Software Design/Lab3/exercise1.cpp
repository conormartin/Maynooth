/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

int main()
{
	cout << "Please specify the number of doubles you wish to enter: " << endl;
	int total;
	cin >> total;
	double numArray[total];
	cout << "Please enter " << total << " doubles" << endl;
	
	//Populates each array block with user input
	for (int i=0; i<total; i++)
	{
	  cin >> numArray[i];
	}
	
	//print numbers in reverse
	for(int j=total; j>=0; j++)
	{
	  cout << numArray[j] << endl;
	}
}