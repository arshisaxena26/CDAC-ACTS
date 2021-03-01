using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EmployeeWebAPI.Models
{
    public class Employee
    {
        [Key]
        public int EmpId { get; set; }
        public string EmpName { get; set; }
        public int EmpSal { get; set; }
        public string EmpPosition { get; set; }
        public string EmpGender { get; set; }
    }
}