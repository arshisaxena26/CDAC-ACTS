using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PartialViewsDemo.Models;

namespace PartialViewsDemo.Controllers
{
    public class ProductController : Controller
    {
        public ActionResult ProductInfo()
        {
            List<Product> productList = new List<Product>()
            {
                new Product{ Id = 1, Name = "iPhone 12 Pro Max", Category = "Phones", Description = "Latest iPhone", Price = 129900},
                new Product{ Id = 2, Name = "OnePlus 8T", Category = "Phones", Description = "Latest OnePlus Phone", Price = 45999},
                new Product{ Id = 3, Name = "Samsung Galaxy Z Fold2", Category = "Phones", Description = "Samsung Phones", Price = 149998},
                new Product{ Id = 4, Name = "iPad Pro", Category = "Tablets", Description = "Latest iPad", Price = 71900},
                new Product{ Id = 5, Name = "Kindle Oasis", Category = "Kindle", Description = "Latest Kindle", Price = 28999}
            };
            return View(productList);
        }
    }
}