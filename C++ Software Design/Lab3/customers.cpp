/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include<iostream>
#include "customers.h"
using namespace std;

void print_customers(customer &head)
{
  customer *cur = &head;
  while(cur != NULL)
  {
    cout << cur->name << endl;
    cur = cur->next;
  }
}