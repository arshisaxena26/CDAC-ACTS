using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EmployeeAddressWebApp.Models
{
    public class Address
    {
        public int AddressId { get; set; }
        public string Country { get; set; }
        public string State { get; set; }
        public string City { get; set; }
        public int Pin { get; set; }
    }
}