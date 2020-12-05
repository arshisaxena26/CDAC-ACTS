using System;

namespace ArrayLib
{
    public class ArrayFunctions
    {
        public int[] bubbleSort(int[] numbers)
        {
            for (int i = 0; i < numbers.Length - 1; i++)
            {
                for (int j = 0; j < numbers.Length - i - 1; j++)
                {
                    if (numbers[j] > numbers[j + 1])
                    {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
            return numbers;
        }

        int partition(int[] numbers, int low, int high)
        {
            int pivot = numbers[high];

            int i = (low - 1);
            for (int j = low; j < high; j++)
            {
                if (numbers[j] < pivot)
                {
                    i++;

                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }

            int temp1 = numbers[i + 1];
            numbers[i + 1] = numbers[high];
            numbers[high] = temp1;

            return i + 1;
        }

        public int[] quickSort(int[] nums, int low, int high)
        {
            if (low < high)
            {
                int pi = partition(nums, low, high);

                quickSort(nums, low, pi - 1);
                quickSort(nums, pi + 1, high);
            }
            return nums;
        }

        public void linearSearch(int[] numbers, int num)
        {
            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] == num)
                {
                    Console.WriteLine("Found");
                    return;
                }
            }
            Console.WriteLine("Not Found");
        }

        public void binarySearch(int[] nums, int key)
        {
            int min = 0;
            int max = nums.Length - 1;
            while (min <= max)
            {
                int mid = (min + max) / 2;
                if (key == nums[mid])
                {
                    Console.WriteLine("Found");
                    return;
                }
                else if (key < nums[mid])
                {
                    max = mid - 1;
                }
                else
                {
                    min = mid + 1;
                }
            }
            Console.WriteLine("Not Found");
        }

        public void binarySearchRecursive(
            int[] numbers,
            int key,
            int min,
            int max
        )
        {
            if (min > max)
            {
                Console.WriteLine("Not Found");
                return;
            }
            else
            {
                int mid = (min + max) / 2;
                if (key == numbers[mid])
                {
                    Console.WriteLine("Found");
                    return;
                }
                else if (key < numbers[mid])
                {
                    binarySearchRecursive(numbers, key, min, mid - 1);
                }
                else
                {
                    binarySearchRecursive(numbers, key, mid + 1, max);
                }
            }
        }
    }
}
