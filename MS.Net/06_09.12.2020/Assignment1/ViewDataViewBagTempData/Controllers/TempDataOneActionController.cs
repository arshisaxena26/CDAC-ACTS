using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class TempDataOneActionController : Controller
    {
        public ActionResult TempDataOneAction()
        {
            TempData["CurrentDateTime"] = DateTime.Now;
            return View();
        }
    }
}