using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UserWebAPI.Models
{
    public class User
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public string Contact { get; set; }
    }
}