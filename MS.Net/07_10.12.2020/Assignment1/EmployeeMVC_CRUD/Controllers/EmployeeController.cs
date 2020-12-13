using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Net;
using System.Web.Mvc;
using EmployeeMVC_CRUD.Repository;
using EmployeeMVC_CRUD.Models;

namespace EmployeeMVC_CRUD.Controllers
{
    public class EmployeeController : Controller
    {
        private readonly EmployeeRes res = new EmployeeRes();

        public ActionResult GetAllEmployees()
        {
            IList<Employee> empList = res.GetEmployees();
            return View(empList);
        }

        public ActionResult GetEmployeeById()
        {
            string id = this.Request.QueryString["id"];

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Employee emp = res.GetEmployeeById(Convert.ToInt32(id));

            if (emp.Id == 0)
            {
                return new HttpStatusCodeResult(HttpStatusCode.NotFound);
            }

            return View(emp);
        }

        public ActionResult InsertEmployee()
        {
            return View();
        }

        [HttpPost]
        public ActionResult InsertEmployee(Employee emp)
        {
            ViewBag.Message = "New Employee Created.";
            res.InsertEmployee(emp);
            return View();
        }

        public ActionResult UpdateEmployee()
        {
            string id = this.Request.QueryString["id"];

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Employee emp = res.GetEmployeeById(Convert.ToInt32(id));

            if (emp.Id == 0)
            {
                return new HttpStatusCodeResult(HttpStatusCode.NotFound);
            }

            return View(emp);
        }

        [HttpPost]
        public ActionResult UpdateEmployee(Employee emp)
        {
            ViewBag.Message = "Employee Information Updated.";
            res.UpdateEmployee(emp);
            return View();
        }

        public ActionResult DeleteEmployee()
        {
            string id = this.Request.QueryString["id"];

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Employee emp = res.GetEmployeeById(Convert.ToInt32(id));

            if (emp.Id == 0)
            {
                return new HttpStatusCodeResult(HttpStatusCode.NotFound);
            }
            return View(emp);
        }

        [HttpPost, ActionName("DeleteEmployee")]
        public ActionResult ConfirmDelete(Employee emp)
        {
            ViewBag.Message = "Employee Deleted.";
            res.DeleteEmployee(emp);
            return View("ConfirmDelete");
        }
    }
}