#include <iostream>
#include <fstream>
#include <string>

int main() {
    std::ifstream file("src/sortTestCase.txt");
    
    if (file.is_open()) {
        std::string line;
        if (std::getline(file, line)) {
            std::cout << "Unshsan mur: " << line << std::endl;
        }
        file.close();
    } else {
        std::cerr << "Unable to open file" << std::endl;
    }
    
    return 0;
}
