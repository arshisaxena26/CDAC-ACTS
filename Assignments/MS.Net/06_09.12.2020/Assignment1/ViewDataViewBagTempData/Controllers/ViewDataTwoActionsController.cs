using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class ViewDataTwoActionsController : Controller
    {
        public ActionResult FirstAction()
        {
            ViewData["CurrentDateTime"] = DateTime.Now;
            return RedirectToAction("ViewDataTwoActions");
        }

        public ActionResult ViewDataTwoActions()
        {
            string str = ViewData["CurrentDateTime"].ToString(); //Null Exception
            return View();
        }
    }
}