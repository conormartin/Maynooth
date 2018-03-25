/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

int main()
{
  cout << "Please enter the number of people whose details you wish to input" << endl;
  int total;
  cin >> total;
  
  struct people
  {
    string forename;
    string surname;
    int age;
  };
  
  people* ptr = new people [total];
  for(int i=0; i<total; i++)
  {
    cout << "Please enter a first name: " << endl;
    cin >> ptr[i].forename;
    cout << "Please enter a surname name: " << endl;
    cin >> ptr[i].surname;
    cout << "Please enter an age: " << endl;
    cin >> ptr[i].age;
  }
  
  for(int j=total-1; j>=0; j--)
  {
    cout << "Name: " << ptr[j].forename << " " << ptr[j].surname << "\t" << "Age: " << ptr[j].age << endl;
  }
}