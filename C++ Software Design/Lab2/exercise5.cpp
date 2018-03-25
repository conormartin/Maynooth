/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include <string.h>

using namespace std;

//Prints out each index value of the array
void print_string_array(char str[])
{
	for(int i=0; str[i]!='\0'; i++)
	{
			cout << str[i];
	}
	cout << "" << endl;
}

//Prints out each char using a pointer referencing a char array
void print_string_ptr(char *str)
{
  while(*str != '\0')
  {
    cout << *str;
    *str++;
  }
  cout << "" << endl;
}

int main()
{
	char str1 [] = "Hello World";
	print_string_array(str1);
	char* strPtr = str1;
	print_string_ptr(strPtr);
}