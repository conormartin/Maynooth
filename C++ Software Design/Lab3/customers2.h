/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#define customers_h
#include <iostream>
#include <string>

using namespace std;

//Create struct with string input and customer pointer type
struct Customer
{
    string name;
    Customer* next;
};

//Create functions with type, name and parameters
Customer* createList(string name);

void insertName(Customer* head, string name);
    
int listLength(Customer* head);
   
void printCustomers(Customer *head);