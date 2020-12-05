using System;
using ArrayLib;

namespace ArrayTester
{
    class ArrayTest
    {
        static void printArray(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++) Console.Write(nums[i] + " ");
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Enter the size of Array");
            int size = Int32.Parse(Console.ReadLine());

            int[] numbers = new int[size];

            Console.WriteLine("Enter " + size + " numbers");
            for (int i = 0; i < size; i++)
            {
                numbers[i] = Int32.Parse(Console.ReadLine());
            }

            ArrayFunctions arrayfunc = new ArrayFunctions();

            Console.WriteLine("\nSorted Using BubbleSort");
            int[] result = arrayfunc.bubbleSort(numbers);
            printArray (result);

            Console.WriteLine("\nSorted Using QuickSort");
            result = arrayfunc.quickSort(numbers, 0, numbers.Length - 1);
            printArray (result);

            Console.WriteLine("\n\nEnter number to search");
            int searchNum = Int32.Parse(Console.ReadLine());

            Console.WriteLine("\nSearching Using Linear Search");
            arrayfunc.linearSearch (numbers, searchNum);

            Console.WriteLine("\nSorted Using Binary Search");
            arrayfunc.binarySearch (result, searchNum);

            Console.WriteLine("\nSorted Using Binary Search with Recursion");
            arrayfunc
                .binarySearchRecursive(result, searchNum, 0, result.Length - 1);
        }
    }
}
