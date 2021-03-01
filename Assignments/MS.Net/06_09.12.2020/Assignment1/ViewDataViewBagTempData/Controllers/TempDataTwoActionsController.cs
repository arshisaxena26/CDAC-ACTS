using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class TempDataTwoActionsController : Controller
    {
        public ActionResult TempDataTwoActions()
        {
            TempData["CurrentDateTime"] = DateTime.Now;
            return RedirectToAction("SecondAction");
        }

        public ActionResult SecondAction()
        {
            string str = TempData["CurrentDateTime"].ToString();
            return View("TempDataTwoActions");
        }
    }
}