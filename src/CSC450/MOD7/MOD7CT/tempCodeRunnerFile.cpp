#include <iostream>
#include <curses.h>
#include <thread>
#include <vector>
using namespace std;

mutex mlock;

int currentNum = 0;

void worker(std::string threadName) {
    lock_guard<mutex> mu(mlock);
    std::cout << "Thread " << threadName << " is running." << std::endl;
}

void counterFunc(bool up, int count, string threadName) {
    std::cout << "Thread " << threadName << " is running." << std::endl;
    lock_guard<mutex> mu(mlock);
    if (up){
    for (size_t i = 0; i < count; i++)
    {
        currentNum++;
        /* code */
    }
    } else {
    for (size_t i = 0; i < count; i++)
    {
        currentNum--;
        /* code */
    }
    }

    
        std::cout <<"Words!"<< endl;
}

int main() {

        // std::thread first (worker, "one");
        std::thread first (counterFunc, true, 5, "one");

        // std::thread second (worker, "two");
        std::thread second (counterFunc, false, 5, "two");

        std::cout<< "Inside Main!" << endl;
        std::cout<< "Count BEFORE execution: "<< currentNum<<endl;


        first.join();
        second.join();

        std::cout<< "Count AFTER execution: "<< currentNum<<endl;
        std::cout<< "Completed Execution";


    return 0;
}