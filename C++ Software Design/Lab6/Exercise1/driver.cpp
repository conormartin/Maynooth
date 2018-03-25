// Chapter 10 of C++ How to Program
// driver for vehicle
#include <iostream>
#include <new>
using namespace std;
#include <vector>
#include "vehicle.h"
#include "taxi.h"
#include "truck.h"
#include "parkinglot.h"

int main()
{
   Taxi *cab1 = new Taxi (3.3);
   Truck *mack1 = new Truck (7.54);
   Taxi *cab2 = new Taxi (3.3);
   Truck *mack2 = new Truck (7.54);
   Taxi *cab3 = new Taxi (3.3);
   Truck *mack3 = new Truck (7.54);
   Taxi *cab4 = new Taxi (3.3);
   Truck *mack4 = new Truck (7.54);
   Taxi *cab5 = new Taxi (3.3);
   Truck *mack5 = new Truck (7.54);

   /* Write code to indicate that truck is carrying cargo */
   mack1->hasCargo();
   /* Declare a vector, parkingLot, of base-class pointers */
   //vector<Vehicle*>cars();

   ParkingLot parkingLot;
   parkingLot.addVehicle(cab1);
   parkingLot.addVehicle(mack1);
   parkingLot.addVehicle(cab2);
   parkingLot.addVehicle(mack2);
   parkingLot.addVehicle(cab3);
   parkingLot.addVehicle(mack3);
   parkingLot.addVehicle(cab4);
   parkingLot.addVehicle(mack4);
   parkingLot.addVehicle(cab5);
   parkingLot.addVehicle(mack5);

   //ParkingLot[0] = cab1;
   //ParkingLot[1] = mack1;

   cout << "\nThe vehicles cannot get out of their parking spaces because of "
        << "traffic,\nso they respond: \n";

   parkingLot.printVehicles();

//    for (unsigned  int i = 0; i < ParkingLot.size(); i++) {

//       /* Write code to call member function horn */
// 	  ParkingLot[i]->horn();
//       cout << endl;
//       /* Write code to display information about the vehicle honking its horn */
//       ParkingLot[i]->print();
//       cout << endl;
//    }

   delete cab1;
   delete mack1;
   delete cab2;
   delete mack2;
   delete cab3;
   delete mack3;
   delete cab4;
   delete mack4;
   delete cab5;
   delete mack5;

   return 0;
} // end main



/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and Prentice      *
 * Hall. All Rights Reserved.                                             *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
