using System;

namespace Assignment2
{
    class DayOfYear
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter Date (YYYY-MM-DD)");
            DateTime dt = DateTime.Parse(Console.ReadLine());
            Console.WriteLine(dt.DayOfYear);
        }
    }
}
