#include <vector>
#include "vehicle.h"

class ParkingLot {

public:
	ParkingLot();
	//virtual ~ParkingLot();

	void addVehicle( Vehicle* v);
	virtual	void printVehicles() const;
	virtual	int getVehicleCount() const;

protected:
	int count;
private:
	std::vector< Vehicle* > vehicles;
};
