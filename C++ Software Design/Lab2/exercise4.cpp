/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>

using namespace std;

//Finds length of char array using a for loop to cycle through each char and increment a counter
int my_string_len(char str[])
{
  int strLength;
  for(int i=1; str[i-1]!='\0'; i++)
  {
    strLength = i;
  }
  return strLength;
}

//Concatenates two strings and print to the screen
void my_string_cat(char dest[], char src[], int dest_size)
{ 
  //Find length of both strings, compare to dest size, if dest size is smaller then return an error
  int len1 = my_string_len(dest);
  int len2 = my_string_len(src);
  int len3 = len1 + len2;
  
  if(dest_size<len3)
  {
    cout << "Error, not enough memory" << endl;
  }
  //combine both char arrays into one and print to the screen
  else
  {
    char concat[dest_size];
    for (int i=0; i<len1; i++) 
    {
      concat[i] = src[i];
    }
    for (int j=0; j<=len2; j++) 
    {
      concat[len1+j] = dest[j];
    }
    for(int k=0; k<=len3; k++)
    {
      cout << concat[k];
    }
    cout << "" << endl;
  }
}

int main()
{
  char strSource [] = "My name is ";
  char strDest [] = "Conor Martin";
  
  int str1Len = my_string_len(strSource);
  int str2Len = my_string_len(strDest);
  int destSize = str1Len + str2Len;
  cout << "The source string has " << str1Len << " characters" << endl;
  cout << "The destination string has " << str2Len << " characters" << endl;
  cout << "The combined length of these strings is " << destSize << endl;
  
  my_string_cat(strDest, strSource, destSize);
  
}