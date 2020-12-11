using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using EmployeeAddressWebApp.Models;

namespace EmployeeAddressWebApp.ViewModel
{
    public class EmpDetails
    {
        public Employee Employee { get; set; }
        public Address Address { get; set; }
        public string PageTitle { get; set; }
        public string PageHeader { get; set; }
    }
}