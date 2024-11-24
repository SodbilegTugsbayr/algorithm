#ifndef APP_H
#define APP_H

#include <vector>

class App {
public:
    std::vector<int> insertionSort(std::vector<int>& list);
    int findMax(std::vector<int>& arr, int l, int r);
    void mergeSort(std::vector<int>& list, int p, int r);
    int binarySearch(std::vector<int>& list, int min, int max, int key);
    
private:
    void merge(std::vector<int>& list, int p, int q, int r);
};

#endif