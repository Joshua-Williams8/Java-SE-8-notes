#include <iostream>
using namespace std;

/*
Create a simple C++ console application using Eclipse IDE 
that will display the following information for a fictional person:
First Name,
Last Name,
Street Address
City
Zip code
 */

class Person {
   public:
	string first_name;
	string last_name;
	string street_address;
	string city;
	string zip_code;


       Person() {
       }
       Person(string first_name, string last_name,
    		   string street_address, string city, string zip_code) {
    	   this->first_name = first_name;
    	   this->last_name = last_name;
    	   this->street_address = street_address;
    	   this->city = city;
    	   this->zip_code = zip_code;
       }

   };

int main() {
	Person per_one("Johnny", "Bravo", "123 Dude Avenue", "Cart Town", "54321");

	cout << "First Name: " + per_one.first_name << endl;
	cout << "Last Name: " + per_one.last_name << endl;
	cout << "Street Address: " + per_one.street_address << endl;
	cout << "City: " + per_one.city << endl;
	cout << "Zip Code: " + per_one.zip_code << endl;

	return 0;

}
