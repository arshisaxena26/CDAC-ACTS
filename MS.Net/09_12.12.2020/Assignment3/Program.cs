using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = {"Rob","Julie","Sarah","Hannah" };

            var namesList = from name in names
                            where name.Contains('a')
                            select name;

            foreach(var item in namesList)
            {
                Console.WriteLine(item);
            }

            List<Employee> empList = new List<Employee>()
            {
                new Employee{EmpId=1,Name="Hannah",Age=27},
                new Employee{EmpId=2,Name="Sarah",Age=26},
                new Employee{EmpId=3,Name="Peyton",Age=57},
                new Employee{EmpId=4,Name="Luke",Age=29},
                new Employee{EmpId=5,Name="Leia",Age=77},
            };

            var result = empList.Where(e => e.Age > 30).ToList();

            foreach (var item in result)
            {
                Console.WriteLine(item.EmpId+" "+item.Name+" "+item.Age);
            }

            Console.ReadLine();
        }
    }
}
