using System;

namespace CalculatorLib
{
    public class Calculator
    {
        public void add(int fnum, int snum)
        {
            Console.WriteLine("Result : " + (fnum + snum));
        }

        public void sub(int fnum, int snum)
        {
            Console.WriteLine("Result : " + (fnum - snum));
        }

        public void mul(int fnum, int snum)
        {
            Console.WriteLine("Result : " + (fnum * snum));
        }

        public void div(int fnum, int snum)
        {
            if(snum == 0)
                Console.WriteLine("Cannot divide by Zero.");
            else
                Console.WriteLine("Result : " + (fnum / snum));
        }

        public void sqrt(double num)
        {
            double result = Math.Sqrt(num);

            if(Double.IsNaN(result))
                Console.WriteLine("Cannot Calculate SQRT of Negative Numbers.");
            else
                Console.WriteLine("Result : " + result);
        }
    }
}
