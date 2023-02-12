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

// реацизации алгоритма
int kadane1(vector<int>& arr, int n)
{
	int loc_sum = 0;
	int glob_sum = 0;
	for (int i = 0; i < arr.size(); i++)
	{
		loc_sum = loc_sum + arr[i];
		loc_sum = max(loc_sum, 0);
		glob_sum = max(loc_sum, glob_sum);
	}
	return glob_sum;
}


int kadane2(vector<int>& arr, int n)
{
	int loc_sum = 0;
	int glob_sum = 0;
	for (int i = 0; i < n; ++i)
	{
		loc_sum = max(0, loc_sum + arr[i]);
		glob_sum = max(loc_sum, glob_sum);
	}
	return glob_sum;
}


int kadane3(int arr[], int n)
{
	int loc_sum = 0;
	int glob_sum = 0;
	for (int i = 0; i < n; ++i)
	{
		loc_sum = max(0, loc_sum + arr[i]);
		glob_sum = max(loc_sum, glob_sum);
	}
	return glob_sum;
}

int kadane4(vector<int>& arr, int n)
{
	int loc_sum = 0;
	int glob_sum = 0;
	for (int i = 0; i < arr.size(); i++)
	{
		loc_sum = loc_sum + arr[i];
		loc_sum = max(loc_sum, 0);
		glob_sum = max(loc_sum, glob_sum);
	}
	return glob_sum;
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
		vector<int> time_vector1;
		vector<int> time_vector2;
		vector<int> time_array;
		for (int i_test = 0; i_test < test_count; ++i_test)
		{
			vector<int> arr1;
			int* arr2 = new int[array_lengths[i_size]];

			generate_int_array(arr1, arr2, array_lengths[i_size]);
			begin = chrono::steady_clock::now();
			kadane1(arr1, array_lengths[i_size]);
			end = chrono::steady_clock::now();
			time_vector1.push_back(chrono::duration_cast<chrono::milliseconds>(end - begin).count());

			begin = chrono::steady_clock::now();
			kadane2(arr1, array_lengths[i_size]);
			end = chrono::steady_clock::now();
			time_vector2.push_back(chrono::duration_cast<chrono::milliseconds>(end - begin).count());

			begin = chrono::steady_clock::now();
			kadane3(arr2, array_lengths[i_size]);
			end = chrono::steady_clock::now();
			delete[] arr2;
			time_array.push_back(chrono::duration_cast<chrono::milliseconds>(end - begin).count());
		}
		cout << array_lengths[i_size] << endl;
		cout << "Average time in milliseconds\n";
		cout << "Algorithm with vector:     " << accumulate(time_vector1.begin(), time_vector1.end(), 0.0) / time_vector1.size() << " ms\n";
		cout << "Opt algorithm with array:  " << accumulate(time_vector2.begin(), time_vector2.end(), 0.0) / time_vector2.size() << " ms\n";
		cout << "Algorithm with array:      " << accumulate(time_array.begin(), time_array.end(), 0.0) / time_array.size() << " ms\n";

		cout << "______________________________________\n";

	}
}


int main() {
	get_time();
	return 0;
}
