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
            Console.WriteLine("-------------- Names Containing 'a' -------------------");

            string[] names = {"Rob","Julie","Sarah","Hannah" };

            var namesList = from name in names
                            where name.Contains('a')
                            select name;

            foreach(var item in namesList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("------------- Employees older than 30 --------------------");

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

            Console.WriteLine("-----------Check and Display occurence of a particular string in List of strings----------------------");

            IList<string> strList = new List<string>()
            {
                "DotNet",
                "MVC",
                "JAVA",
                "C++"
            };

            var resultList = strList.Where(s => s.Contains("DotNet")).ToList();

            foreach (var item in resultList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("------------- Customers Ordered By Name --------------------");

            List<Customer> custList = new List<Customer>();

            Customer cust1 = new Customer();
            cust1.CustId = 1;
            cust1.Name = "John";
            cust1.Age = 28;
            cust1.Gender = "Male";
            cust1.Salary = 200000;
            custList.Add(cust1);

            Customer cust2 = new Customer();
            cust2.CustId = 2;
            cust2.Name = "Luke";
            cust2.Age = 25;
            cust2.Gender = "Male";
            cust2.Salary = 200000;
            custList.Add(cust2);

            Customer cust3 = new Customer();
            cust3.CustId = 3;
            cust3.Name = "Han";
            cust3.Age = 79;
            cust3.Gender = "Male";
            cust3.Salary = 200000;
            custList.Add(cust3);

             var customerList = from c in custList
                               orderby c.Name
                               select c;

            foreach (var item in customerList)
            {
                Console.WriteLine(item.Name);
            }

            Console.WriteLine("--------------Customers Ordered By Name In Descending Order-------------------");

           // var customerListDesc = from c in custList
           //                    orderby c.Name descending
           //                    select c;

            var customerListDesc = custList.OrderByDescending(x => x.Name).ToList();

            foreach (var item in customerListDesc)
            {
                Console.WriteLine(item.Name);
            }

            Console.WriteLine("------------ Customers Ordered By Name And Age ---------------------");

            var customerListOrderByTwoFields = custList.OrderByDescending(x => x.Name).ThenBy(x=>x.Age).ToList();

            foreach (var item in customerListOrderByTwoFields)
            {
                Console.WriteLine(item.Name+" "+item.Age);
            }

            Console.WriteLine("------------ Sum of List of Integers ---------------------");

            IList<int> intList = new List<int>() { 12,67,34,67,99,77,33};
            int total = intList.Sum();
            Console.WriteLine("Sum : {0}",total);

            Console.WriteLine("------------ Even Integers in the List of Integers ---------------------");

            var evenList = intList.Where(x => x % 2 == 0).ToList();

            foreach (var item in evenList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("------------ Odd Integers in the List of Integers ---------------------");

            var oddList = intList.Where(x => x % 2 != 0).ToList();

            foreach (var item in oddList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("----------- Distinct List of Integers ----------------------");

            var distinctList = intList.Distinct().ToList();

            foreach (var item in distinctList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("------------ Distinct List of Strings ---------------------");

            IList<string> stringList = new List<string>()
            {
                "Hello",
                "Hi",
                "Hello",
            };

            var strResultList = stringList.Distinct().ToList();

            foreach (var item in strResultList)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("------------ Common strings from two string lists using Join ---------------------");

            IList<string> strList1 = new List<string>()
            {
                "Some",
                "Strings",
                "Will",
                "Be",
                "Repeated"
            };

            IList<string> strList2 = new List<string>()
            {
                "And",
                "Some",
                "Will",
                "Be",
                "Unique"
            };

            var joinList = strList1.Join(strList2,str1=>str1,str2=>str2,(str1,str2)=>str1);

            foreach(var item in joinList)
            {
                Console.WriteLine(item);
            }

            Console.ReadLine();
        }

    }
}
