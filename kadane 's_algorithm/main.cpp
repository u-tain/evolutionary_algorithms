#include <iostream>
#include <vector>
#include <chrono>
#include <numeric>
using namespace std;

// генерация массива заданной длины
void generate_int_array(vector<int>& arr1, int arr2[], int length)
{
	for (int i = 0; i < length; ++i)
	{
		int sign = rand() % 2 + 1;
		if (sign > 1)
			arr1.push_back(-1 * rand() % 15);
		else
			arr1.push_back(rand() % 15);
		arr2[i] = arr1[i];
	}
}

// вывод массива в консоль
void print(vector<int>& arr) 
{	
	cout << '[';
	for (int i = 0; i < arr.size(); ++i)
		cout << arr[i] << " ";
	cout << ']' << endl;
}

// первая рацизация алгоритма
int kadane(vector<int>& arr, int n)
{
	int sum1 = 0;
	int sum2 = 0;
	for (int i = 0; i < n; ++i)
	{
		sum1 = max(0, sum1 + arr[i]);
		sum2 = max(sum1, sum2);
	}
	return sum2;
}

int kadane2(int arr[], int n)
{
	int max_so_far = 0;
	int max_ending_here = 0;
	for (int i = 0; i < n; i++)
	{
		max_ending_here = max(max_ending_here + arr[i], 0);
		max_so_far = max(max_so_far, max_ending_here);
	}
	return max_so_far;
}

void get_time() 
{
	vector<int> array_lengths = { 10, 100, 1000 , 10000, 50000, 100000, 500000, 1000000 };
	auto begin = chrono::steady_clock::now();
	auto end = chrono::steady_clock::now();

	int test_count = 100;
	cout << "Counting time. Please, wait.\n";
	for (int i_size = 0; i_size < array_lengths.size(); ++i_size)
	{	
		cout << "Array length: " << array_lengths[i_size] << endl;
		vector<int> time;
		vector<int> times;
		for (int i_test = 0; i_test < test_count; ++i_test)
		{
			vector<int> arr1;
			int* arr2 = new int[array_lengths[i_size]];

			generate_int_array(arr1, arr2, array_lengths[i_size]);
			begin = chrono::steady_clock::now();
			kadane(arr1, array_lengths[i_size]);
			end = chrono::steady_clock::now();
			time.push_back(chrono::duration_cast<chrono::milliseconds>(end - begin).count());

			begin = chrono::steady_clock::now();
			kadane2(arr2, array_lengths[i_size]);
			end = chrono::steady_clock::now();
			times.push_back(chrono::duration_cast<chrono::milliseconds>(end - begin).count());
		}
		cout << array_lengths[i_size] << endl;
		cout << "Average time in milliseconds\n";
		cout << "Algorithm with vector: " << accumulate(time.begin(), time.end(), 0.0) / time.size() << " ms\n";
		cout << "Algorithm with array:  " << accumulate(times.begin(), times.end(), 0.0) / times.size() << " ms\n";
		cout << "______________________________________\n";

	}
}


int main() {
	get_time();
	return 0;
}
