#include<iostream>
#include<curses.h>
using namespace std;
/*
Program: Create a C++ program that asks the user to enter three integer values as input. 
Store the values into three different variables. 
For each variable, create an integer pointer to dynamic memory. 
Display the contents of the variables and pointers. 
In your program, be sure to use the new operator and delete operators to management memory.
*/

int getIntFromUser(string var_name) {
    int output;
    //Read online to allow for easier error handling to use getline with a string and then convert that string to an int.
    std::string int_str;
    std::cout<<"For Variable " << var_name << "\nPlease enter an integer: "<< endl;
	std::getline(std::cin, int_str); 
    //Used Recursion to continue asking for an int if one is not provided.
    try {
        output = std::stoi(int_str);
    } catch (exception) {
        std::cout<< "There was an issue with your input please try again" << endl;
        output = getIntFromUser(var_name);
    }
    return output;
}

int main() {
    int a = getIntFromUser("a");
    int b = getIntFromUser("b");
    int c = getIntFromUser("c");

    //Pointers
    int* a_pointer = new int;
    *a_pointer = a;

    int* b_pointer = new int;
    *b_pointer = b;

    int* c_pointer = new int;
    *c_pointer = c;

    //Displaying info
    cout << "a: " << a << endl; // print the value of a
    cout << "&a: " << &a << endl; // print the memory address of a
    cout << "a_pointer: " << a_pointer<< endl; // print the memory address of a_pointer
    cout << "*a_pointer: " << *a_pointer << endl; // print value stored at the memory address a_pointer

    cout << "b: " << b << endl; 
    cout << "&b: " << &b << endl; 
    cout << "b_pointer: " << b_pointer<< endl; 
    cout << "*b_pointer: " << *b_pointer << endl; 

    cout << "c: " << c << endl;
    cout << "&c: " << &c << endl;
    cout << "c_pointer: " << c_pointer<< endl;
    cout << "*c_pointer: " << *c_pointer << endl;

    //Deallocating the memory from the pointers
    delete a_pointer;
    // cout << "*a_pointer: " << *a_pointer<< endl; //Value shows as 0 since it was deleted
    a_pointer = nullptr;
    // cout << "a_pointer: " << a_pointer<< endl; //Memory location after being set to nullptr

    delete b_pointer;
    b_pointer = nullptr;

    delete b_pointer;
    c_pointer = nullptr;

	return 0;
}
