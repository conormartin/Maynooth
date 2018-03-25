/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include "customers2.h"

using namespace std;

int main() 
{
  //Declare new int and string
  int num;
  string name;
  
  //Ask for input from user, set value to int
  cout << "How many customers do you wish to enter ";
  cin >> num;

  //Ask for input, set input to name
  cout << "Please enter the first customer: ";
  cin >> name;

  //New value head of type customer pointer set to create list function
  Customer* head = createList(name);

  //For loop to keep getting input until value of num is reached
  for (int i=1; i<=num; i++) 
  {
    cout << "Please enter the name of customer " << i << ": ";
    cin >> name;
    
    //If user inputs the word end, the program will end
	  if(name == "end")
	  {
	    break;
    }
	  //Call insertName function which takes in head(create list function) and user input 'name'
    insertName(head, name);
  }
  
  //Sets new value of num to the result of the listLength function
  num = listLength(head);
     
  //Prints the length of the list and the customer names through calling the printCustomers function   
  cout << endl << "List length: " << num << endl << "Customer names:" << endl;

	printCustomers(head);
  return 0;
}
