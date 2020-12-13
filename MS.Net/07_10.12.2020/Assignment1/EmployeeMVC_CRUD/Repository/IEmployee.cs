using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeMVC_CRUD.Models;

namespace EmployeeMVC_CRUD.Repository
{
    public interface IEmployee
    {
        IList<Employee> GetEmployees();
        Employee GetEmployeeById(int id);
        void InsertEmployee(Employee Employee);
        void UpdateEmployee(Employee Employee);
        void DeleteEmployee(Employee Employee);
    }
}
