using System;
using CalculatorLib;

namespace ExecuteCalculator
{
    class RunCalculator
    {
        static void Main(string[] args)
        {
            Calculator calc = new Calculator();
            bool exit = false;

            while (!exit)
            {
                Console.WriteLine("\nCalculator Application");
                Console.WriteLine("1. Add");
                Console.WriteLine("2. Sub");
                Console.WriteLine("3. Mul");
                Console.WriteLine("4. Div");
                Console.WriteLine("5. SQRT");
                Console.WriteLine("6. Exit");

                Console.WriteLine("Enter your Choice");
                int choice = Int32.Parse(Console.ReadLine());

                int fnum = 0;
                int snum = 0;

                if (choice != 5 && choice != 6)
                {
                    Console.WriteLine("Enter First Number");
                    fnum = Int32.Parse(Console.ReadLine());

                    Console.WriteLine("Enter Second Number");
                    snum = Int32.Parse(Console.ReadLine());
                }

                switch (choice)
                {
                    case 1:
                        calc.add (fnum, snum);
                        break;
                    case 2:
                        calc.sub (fnum, snum);
                        break;
                    case 3:
                        calc.mul (fnum, snum);
                        break;
                    case 4:
                        calc.div (fnum, snum);
                        break;
                    case 5:
                        Console.WriteLine("Enter a Number");
                        double num = double.Parse(Console.ReadLine());

                        calc.sqrt (num);
                        break;
                    case 6:
                        Console.WriteLine("GoodBye.");
                        exit = true;
                        break;
                    default:
                        Console.WriteLine("Invalid Input.");
                        break;
                }
            }
        }
    }
}
