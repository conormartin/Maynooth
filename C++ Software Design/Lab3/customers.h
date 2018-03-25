/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include<iostream>
using namespace std;

struct customer
{
  string name;
  customer *next;
};

void print_customers(customer &head);