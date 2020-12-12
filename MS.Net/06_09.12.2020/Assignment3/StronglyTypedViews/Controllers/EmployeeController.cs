using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StronglyTypedViews.Models;

namespace StronglyTypedViews.Controllers
{
    public class EmployeeController : Controller
    {
        [HttpGet]
        public ActionResult EmpInfo()
        {
            return View();
        }

        [HttpPost]
        public ActionResult EmpInfo(Employee emp)
        {
            Response.Write(" Employee ID : " + emp.Id + " Employee Name : " + emp.Name + " Employee Gender: " + emp.Gender + 
                " Employee Phone : " + emp.Phone + " Employee Address : " + emp.Address);
            return View();
        }
    }
}