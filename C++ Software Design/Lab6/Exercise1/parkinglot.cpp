#include <vector>
#include "vehicle.h"
#include "parkinglot.h"
#include "truck.h"
#include "taxi.h"
using namespace std;

ParkingLot::ParkingLot(){
	count = 0;
}

//ParkingLot::~ParkingLot(){

//}

	void ParkingLot::addVehicle(Vehicle *v){
		vehicles.push_back(v);
		count++;
	}

	void ParkingLot::printVehicles()const{
		for(vector<Vehicle*>::const_iterator i=vehicles.begin(); i!=vehicles.end();i++){
			(*i)->horn();
		}
	}

	int ParkingLot::getVehicleCount()const{
		return count;
	}
