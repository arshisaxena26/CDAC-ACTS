using FriendMVC.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace FriendMVC.FriendDatabaseContext
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext() : base("DefaultConnection")
        {

        }

        public DbSet<Friend> Friends { get; set; }
    }
}