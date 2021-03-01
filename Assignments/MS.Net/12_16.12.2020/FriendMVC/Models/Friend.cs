using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace FriendMVC.Models
{
    public class Friend
    {
        [Key]
        [Required]
        public int FriendId { get; set; }

        [Required(ErrorMessage ="Name is Required.")]
        public string FriendName { get; set; }

        [MaxLength(25)]
        public string Place { get; set; }
    }
}