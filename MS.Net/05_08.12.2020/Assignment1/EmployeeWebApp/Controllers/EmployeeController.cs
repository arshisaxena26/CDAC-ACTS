using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using EmployeeWebApp.Models;

namespace EmployeeWebApp.Controllers
{
    public class EmployeeController : Controller
    {
        [HttpGet]
        public ActionResult CreateEmployee()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CreateEmployee(Employee emp)
        {
            Response.Write("Employee ID: "+emp.EmpId+"Employee Name: "+emp.EmpName+
                "Employee Gender: "+emp.EmpGender+"Employee Phone: "+emp.EmpPhone);
            return View();
        }
    }
}