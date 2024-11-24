#include <gtest/gtest.h>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include "../src/App.h"

using namespace std;

std::vector<std::string> split(const std::string& str, char delimiter) {
    std::vector<std::string> tokens;
    std::stringstream ss(str);
    std::string token;
    
    while (std::getline(ss, token, delimiter)) {
        tokens.push_back(token);
    }
    
    return tokens;
}

class AppTest : public ::testing::Test {
protected:
    vector<int> parseArrayFromString(const string& line) {
        vector<int> array;
        stringstream ss(line);
        string item;
        while (getline(ss, item, ',')) {
            array.push_back(stoi(item));
        }
        return array;
    }

    string readFileLine(const string& filename) {
        ifstream file(filename);
        if (!file.is_open()) {
            throw runtime_error("Unable to open file");
        }
        string line;
        getline(file, line);
        file.close();
        return line;
    }
};

TEST_F(AppTest, testInsertionSort) {
    App app;
    try {
        string line = readFileLine("/Users/yujin/Desktop/algorithm/Lab1/src/sortTestCase.txt");
        std::vector<std::string> tokens = split(line, ':');
        vector<int> unsortedArray = parseArrayFromString(tokens[0]);
        vector<int> expectedSortedArray = parseArrayFromString(tokens[1]);

        vector<int> sortedArray = app.insertionSort(unsortedArray);

        EXPECT_EQ(expectedSortedArray, sortedArray);
    } catch (const exception& e) {
        FAIL() << "Error: " << e.what();
    }
}

TEST_F(AppTest, testMergeSort) {
    App app;
    try {
        string line = readFileLine("/Users/yujin/Desktop/algorithm/Lab1/src/sortTestCase.txt");
        std::vector<std::string> tokens = split(line, ':');
        vector<int> unsortedArray = parseArrayFromString(tokens[0]);
        vector<int> expectedSortedArray = parseArrayFromString(tokens[1]);

        app.mergeSort(unsortedArray, 0, unsortedArray.size() - 1);

        EXPECT_EQ(expectedSortedArray, unsortedArray);
    } catch (const exception& e) {
        FAIL() << "Error: " << e.what();
    }
}

TEST_F(AppTest, testBinarySearch) {
    App app;
    try {
        string line = readFileLine("/Users/yujin/Desktop/algorithm/Lab1/src/binarySearchTestCase.txt");
        std::vector<std::string> tokens = split(line, ':');
        vector<int> arr = parseArrayFromString(tokens[0]);
        int key = stoi(tokens[1]);
        int expectedIndex = stoi(tokens[2]);

        int index = app.binarySearch(arr, 0, arr.size() - 1, key);

        EXPECT_EQ(expectedIndex, index);
    } catch (const exception& e) {
        FAIL() << "Error: " << e.what();
    }
}

TEST_F(AppTest, testFindMax) {
    App app;
    try {
        string line = readFileLine("/Users/yujin/Desktop/algorithm/Lab1/src/findMaxTestCase.txt");
        std::vector<std::string> tokens = split(line, ':');
        vector<int> arr = parseArrayFromString(tokens[0]);
        int expectedMax = stoi(tokens[1]);

        int max = app.findMax(arr, 0, arr.size() - 1);

        EXPECT_EQ(expectedMax, max);
    } catch (const exception& e) {
        FAIL() << "Error: " << e.what();
    }
}