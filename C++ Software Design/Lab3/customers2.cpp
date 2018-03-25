/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include "customers2.h"

using namespace std;

Customer* createList(string name) 
{
  //Create new dynamic memory allocation called customer
  Customer* customer = new Customer();
  //Link the string input 'name' to the memory allocated at customer
  customer->name = name;
  
  customer->next = NULL;
  return customer;
}

void insertName(Customer* head, string name) 
{
  Customer* current = head;
  
  while (current->next != NULL) 
  {
    current = current->next;
  }
  
  current -> next = new Customer();
  current = current -> next;
  current -> name = name;
  current -> next = NULL;
}

int listLength(Customer* head) 
{
  Customer* current = head;
  int count = 0;
  
  while (current != NULL) 
  {
    current = current -> next;
    count++;
  }
  return count;
}

void printCustomers(Customer *head) 
{
  Customer* current = head;
  
  while (current != NULL) 
  {
    cout << current -> name << endl;
    current = current -> next;
  }
}
