using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using EmployeeAddressWebApp.Models;
using EmployeeAddressWebApp.ViewModel;

namespace EmployeeAddressWebApp.Controllers
{
    public class EmployeeController : Controller
    {
        public ActionResult Details()
        {
            Employee emp = new Employee()
            {
                Id = 111, Name = "Sarah", Gender = "Female", Department = "IT", Salary = 2400000, AddressId = 1
            };

            Address addr = new Address();
            addr.AddressId = 1;
            addr.Country = "USA";
            addr.State = "Florida";
            addr.City = "Miami";
            addr.Pin = 203040;

            EmpDetails empInfo = new EmpDetails() {
                Employee = emp, Address = addr, PageTitle = "Employee Information", PageHeader = "Employee Details"
            };

            return View(empInfo);
        }
    }
}