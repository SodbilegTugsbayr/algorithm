#include "App.h"
#include <algorithm>
#include <vector>

std::vector<int> App::insertionSort(std::vector<int>& list) {
    int key, i;
    for (int j = 1; j < list.size(); j++) {
        key = list[j];
        i = j - 1;
        while (i >= 0 && list[i] > key) {
            list[i + 1] = list[i];
            i--;
        }
        list[i + 1] = key;
    }
    return list;
}

int App::findMax(std::vector<int>& arr, int l, int r) {
    if (l == r) {
        return arr[l];
    }
    int mid = (l + r) / 2;
    int maxLeft = findMax(arr, l, mid);
    int maxRight = findMax(arr, mid + 1, r);
    return std::max(maxLeft, maxRight);
}

void App::mergeSort(std::vector<int>& list, int p, int r) {
    if (p < r) {
        int q = (p + r) / 2;
        mergeSort(list, p, q);
        mergeSort(list, q + 1, r);
        merge(list, p, q, r);
    }
}

void App::merge(std::vector<int>& list, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    std::vector<int> left(n1);
    std::vector<int> right(n2);

    for (int i = 0; i < n1; i++) {
        left[i] = list[p + i];
    }

    for (int j = 0; j < n2; j++) {
        right[j] = list[q + j + 1];
    }

    int i = 0, j = 0;
    int k = p;

    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
            list[k] = left[i];
            i++;
        } else {
            list[k] = right[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        list[k] = left[i];
        i++;
        k++;
    }

    while (j < n2) {
        list[k] = right[j];
        j++;
        k++;
    }
}

int App::binarySearch(std::vector<int>& list, int min, int max, int key) {
    if (min > max) {
        return -1; // Key not found
    }

    int mid = (min + max) / 2;

    if (list[mid] == key) {
        return mid;
    } else if (list[mid] < key) {
        return binarySearch(list, mid + 1, max, key); // Move to the right subarray
    } else {
        return binarySearch(list, min, mid - 1, key); // Move to the left subarray
    }
}