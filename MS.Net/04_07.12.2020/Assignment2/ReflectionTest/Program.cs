using System;
using System.Reflection; 

namespace ReflectionTest
{
    class ReflectionClass
    {
        public string msg;

        private ReflectionClass()
        {
            this.msg = "Private Constructor Accessed Using Reflection";
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var constructor = typeof(ReflectionClass).GetConstructor(BindingFlags.NonPublic|BindingFlags.Instance, null, new Type[0], null);
            var instance = (ReflectionClass)constructor.Invoke(null);
            Console.WriteLine(instance.msg);
        }
    }
}
