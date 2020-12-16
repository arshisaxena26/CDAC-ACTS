using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using FriendMVC.FriendDatabaseContext;
using FriendMVC.Models;
using System.Data.Entity;

namespace FriendMVC.Controllers
{
    public class FriendController : Controller
    {
        DatabaseContext db = new DatabaseContext();

        public ActionResult Index()
        {
            var friendList = db.Friends.ToList();
            return View(friendList);
        }

        public ActionResult Details(int id)
        {
            var friend = db.Friends.Find(id);
            return View(friend);
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(Friend friend)
        {
            if (ModelState.IsValid)
            {
                db.Friends.Add(friend);
                db.SaveChanges();
                return RedirectToAction("Index", "Friend");
            }
            return View();
        }

        public ActionResult Edit(int id)
        {
            var friend = db.Friends.Find(id);
            return View(friend);
        }

        [HttpPost]
        public ActionResult Edit(Friend friend)
        {
            if (ModelState.IsValid)
            {
                db.Entry(friend).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index", "Friend");
            }
            return View();
        }

        public ActionResult Delete(int id)
        {
            Friend friend = db.Friends.Find(id);
            db.Friends.Remove(friend);
            db.SaveChanges();
            return View(friend);
        }

        [HttpPost]
        public ActionResult Delete()
        {
            
            return RedirectToAction("Index", "Friend");
        }
    }
}