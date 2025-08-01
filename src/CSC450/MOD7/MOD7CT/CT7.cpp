#include <iostream> //For Input Output
#include <thread> //For using threads
#include <chrono> //For sleeping a thread for testing
using namespace std;

mutex mlock; //Mutex for our lockguard to block off blocks of code if another thread reaching them before we are ready

int currentNum = 0;

void counterFunc(bool up, int count, string threadName) {
    std::cout << "Thread " << threadName << " is checking the lock_guard." << endl;
    lock_guard<mutex> mu(mlock);
    if (up){
    std::cout << "Thread "<<threadName << " paused!" << std::endl;
    std::this_thread::sleep_for(std::chrono::seconds(3));
    std::cout << "Thread "<<threadName << " unpaused!" << std::endl;
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
    std::cout << "Thread " << threadName << " is done counting at " << currentNum << endl;

}

int main() {

        std::thread first (counterFunc, true, 20, "one");

        std::thread second (counterFunc, false, 20, "two");

        std::cout<< "Inside Main with MUTUX/LOCK GUARD!" << endl;
        std::cout<< "Count BEFORE execution: "<< currentNum<<endl;


        first.join();
        second.join();

        std::cout<< "Count AFTER execution: "<< currentNum<<endl;
        std::cout<< "Completed Execution";


    return 0;
}