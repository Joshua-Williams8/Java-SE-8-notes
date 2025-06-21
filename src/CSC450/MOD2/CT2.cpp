#include <iostream>
#include<curses.h>
using namespace std;

void getConcatStrings() {
    std::string string_one;
    std::cout<< "Please enter the first or front string: "<< endl;
	  std::getline(std::cin, string_one);

    std::string string_two;
    std::cout<< "Please enter the second or end string: "<< endl;
    std::getline(std::cin, string_two);

    std::string string_cat = string_one + string_two;
    std::cout<< string_cat << endl;
}

int main() {

    for (int i = 0; i < 3; i++) {
        getConcatStrings();
    }

	return 0;
}
