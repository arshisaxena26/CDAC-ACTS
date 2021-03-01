using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ActionFiltersMVC.Models
{
    public class User
    {
        [Display(Name = "UserName")]
        [Required]
        public string UserName { get; set; }

        [Display(Name = "Password")]
        [Required]
        public string Password { get; set; }
    }
}