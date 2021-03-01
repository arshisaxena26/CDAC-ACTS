using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ViewDataViewBagTempData.Controllers
{
    public class ViewBagOneActionController : Controller
    {
        public ActionResult ViewBagOneAction()
        {
            ViewBag.CurrentDateTime = DateTime.Now;
            return View();
        }
    }
}