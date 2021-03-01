using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClientMultipleEndpoints.ServiceReference1;

namespace ClientMultipleEndpoints
{
    class Program
    {
        static void Main(string[] args)
        {
            Service1Client proxy = null;

            proxy = new Service1Client("FirstBinding");
            Console.WriteLine(proxy.GetMessage(" First End Point"));

            proxy = new Service1Client("SecondBinding");
            Console.WriteLine(proxy.GetMessage(" Second End Point"));

            Console.ReadLine();
        }
    }
}
