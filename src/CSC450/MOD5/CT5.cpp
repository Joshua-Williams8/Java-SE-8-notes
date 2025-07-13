#include<iostream>
#include<curses.h>
#include <fstream>
#include <sstream>
using namespace std;



void send_to_file(string file_location) {
        string send_str;
    try {
            std::cout<< "Please enter the send you would like to append inside of: " << file_location << endl;
            std::getline(std::cin, send_str); 

    } catch (exception) {
        
            std::cout<< "There was an issue with your input, please try again." << endl;
            send_to_file(file_location);
    }

    try {

        std::ofstream send_stream; //Create the stream

        send_stream.open(file_location, std::ios_base::app); //Open or create the file, and set to append
        send_stream << send_str << endl;
        send_stream.close();
    } catch (exception) {
            std::cout<< "There was an issue appending the text to the file, confirm the file path is correct." << endl;
            std::cout<< "If the file is in the same folder as expected there may be another issue." << endl;

    }
}

void write_to_file_reversed(string file_1, string file_2) {
        std::ifstream receive_stream;//Create stream for input and open the file we need to use
        receive_stream.open(file_1);

        std::stringstream receive_buffer;
        receive_buffer << receive_stream.rdbuf(); //Please file contents into the buffer
        string buffer_str = receive_buffer.str(); //Take the buffer contents as a string to place them into a string
        receive_stream.close(); // close our stream=

        //Sending reversed input to file_2

        std::ofstream send_stream; //Create the stream
        reverse(buffer_str.begin(), buffer_str.end());

        send_stream.open(file_2); //Open or create the file, and default settings should overwrite everything.
        send_stream << buffer_str << endl;
        send_stream.close();

}


int main() {
        //Send the file location to our function
        // CSC450_CT5_mod5.txt
        std::cout<< "Part 1 appending text to a file: " << endl;
        send_to_file("CSC450_CT5_mod5.txt");
        

        // CSC450_CT5_mod5-reverse.txt
        std::cout<< "Part 2 Revensing the text from the first file, and saving it to another file: " << endl;
        write_to_file_reversed("CSC450_CT5_mod5.txt", "CSC450_CT5_mod5-reverse.txt");


        return 0;
}
