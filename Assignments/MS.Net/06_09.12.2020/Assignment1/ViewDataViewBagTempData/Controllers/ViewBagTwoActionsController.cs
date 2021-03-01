using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class ViewBagTwoActionsController : Controller
    {
        public ActionResult FirstAction()
        {
            ViewBag.CurrentDateTime = DateTime.Now;
            return RedirectToAction("ViewBagTwoActions");
        }

        public ActionResult ViewBagTwoActions()
        {
            string str = ViewBag.CurrentDateTime;
            return View();
        }
    }
}