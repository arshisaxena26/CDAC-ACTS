using EmployeeWebAPI.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EmployeeWebAPI.Controllers
{
    public class EmployeeController : ApiController
    {
        DatabaseContext dc = new DatabaseContext();

        public IEnumerable<Employee> GetEmployees()
        {
            return dc.Employees.ToList();
        }

        public Employee GetEmployee(int id)
        {
            return dc.Employees.Find(id);
        }

        [HttpPost]
        public HttpResponseMessage AddEmployee(Employee model)
        {
            try
            {
                dc.Employees.Add(model);
                dc.SaveChanges();
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.Created);
                return response;
            }
            catch (Exception ex)
            {
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.InternalServerError);
                return response;
                throw;
            }
        }

        [HttpPut]
        public HttpResponseMessage UpdateEmployee(int id, Employee model)
        {
            try
            {
                if (id == model.EmpId)
                {
                    dc.Entry(model).State = EntityState.Modified;

                    dc.SaveChanges();
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.OK);
                    return response;
                }
                else
                {
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.NotModified);
                    return response;
                }

            }
            catch (Exception ex)
            {
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.InternalServerError);
                return response;
                throw;
            }
        }

        [HttpDelete]
        public HttpResponseMessage DeleteEmployee(int id)
        {
            Employee employee = dc.Employees.Find(id);
            {
                if (employee != null)
                {
                    dc.Employees.Remove(employee);
                    dc.SaveChanges();
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.OK);
                    return response;
                }
                else
                {
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.NotFound);
                    return response;
                }
            }
        }
    }
}
