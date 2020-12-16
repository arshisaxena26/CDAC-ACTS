using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClientTwoContract.ServiceReference1;

namespace ClientTwoContract
{
    class Program
    {
        static void Main(string[] args)
        {
            Service1Client client1 = new Service1Client();
            int sum = client1.Add(10, 20);
            int sub = client1.Sub(20, 10);
            int mul = client1.Mul(2, 3);
            int div = client1.Div(10, 5);

            Console.WriteLine("Addition : " + sum);
            Console.WriteLine("Subtraction : " + sub);
            Console.WriteLine("Multiplication : " + mul);
            Console.WriteLine("Division : " + div);

            Service2Client client2 = new Service2Client();
            Console.WriteLine(client2.Name("John"));
            Console.WriteLine(client2.Email("john@gmail.com"));

            Console.ReadLine();
        }
    }
}
