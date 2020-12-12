using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class ViewDataOneActionController : Controller
    {
        public ActionResult ViewDataOneAction()
        {
            ViewData["CurrentDateTime"] = DateTime.Now;
            return View();
        }
    }
}