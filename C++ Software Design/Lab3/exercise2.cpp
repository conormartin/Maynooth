/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
using namespace std;

int main()
{
  bool quit = false;
  int size = 10;
  //Create new pointed array
  double* numArray = new double[size];
  cout << "Please enter a list of doubles, to finish, enter -1" << endl;
  int counter;
  for (counter=0; quit==false; counter++)
  {
    cin >> numArray[counter];
    if(numArray[counter]==-1)
    {
      quit = true;
      break;
    }
    if(counter>=size)
    {
      //If input greater than 10, create new array pointed to by a pointer
      double* newArray = new double[counter+size];
      //Copy contents of old array into new array
      for(int k=0; k<size; k++)
      {
      newArray[k] = numArray[k];
      }
      //Delete old memory block of numArray
      delete[]numArray;
      //New memory block equalled to pointer address of numArray
      numArray = newArray;
      size = counter+size;
    }
  }
    //print numbers in reverse
    for(int i=counter; i>=0; i--)
    {
      cout << numArray[i] << endl;
    }
}