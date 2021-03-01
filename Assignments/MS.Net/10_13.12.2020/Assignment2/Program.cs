using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FuncAndActionDelegateDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("------------ Func Delegate with Anonymous ---------------------");

            Func<int, int, int, int> myFunc = delegate (int a, int b, int c)
            {
                return a + b + c;
            };

            int sum = myFunc.Invoke(20, 20, 20);
            Console.WriteLine(sum);

            Console.WriteLine("------------ Func Delegate ---------------------");

            Func<int, int, int> myMul = Mul;
            int mul = myMul.Invoke(2, 4);
            Console.WriteLine(mul);

            Console.WriteLine("------------ Action Delegate-----------");

            Action<int, int> myAction = delegate (int a, int b)
            {
                int c = a - b;
                Console.WriteLine(c);
            };

            myAction.Invoke(30, 20);

            Console.ReadLine();
        }

        public static int Mul(int x, int y)
        {
            return x * y;
        }
    }
}
