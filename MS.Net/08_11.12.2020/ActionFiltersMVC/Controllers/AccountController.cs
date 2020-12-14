using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ActionFiltersMVC.RouteProtection;

namespace ActionFiltersMVC.Controllers
{
    public class AccountController : Controller
    {
        [AuthenticationFilter]
        public ActionResult Index()
        {
            return RedirectToAction("Index", "Home");
        }
    }
}