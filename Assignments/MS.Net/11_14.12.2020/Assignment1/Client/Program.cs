using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Client.ServiceReference1;

namespace Client
{
    class Program
    {
        static void Main(string[] args)
        {
            Service1Client client = new Service1Client();
            int sum = client.Add(10, 20);
            int mul = client.Mul(10, 20);
            string name = client.FullName("John", "Goldman");
            Console.WriteLine(sum);
            Console.WriteLine(mul);
            Console.WriteLine(name);
            Console.ReadLine();
        }
    }
}
