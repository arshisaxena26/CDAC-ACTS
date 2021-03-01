using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ActionFiltersMVC.Models;

namespace ActionFiltersMVC.Login
{
    public class LoginController : Controller
    {
        [HttpGet]
        public ActionResult LoginUser()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LoginUser(User user)
        {
            if (!ModelState.IsValid)
            {
                return View(user);
            }

            if (user.UserName != "Test" && user.Password != "Test")
            {
                ModelState.AddModelError("", "Invalid Credentials");
                return View(user);
            }

            Session["User"] = Guid.NewGuid();
            return RedirectToAction("Index", "Account");
        }
    }
}