using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using UserWebAPI.Models;

namespace UserWebAPI.Controllers
{
    public class UserController : ApiController
    {
        DatabaseContext dc = new DatabaseContext();

        public IEnumerable<User> GetUsers()
        {
            return dc.Users.ToList();
        }

        public User GetUser(int id)
        {
            return dc.Users.Find(id);
        }

        [HttpPost]
        public HttpResponseMessage AddUser(User model)
        {
            try
            {
                dc.Users.Add(model);
                dc.SaveChanges();
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.Created);
                return response;
            }
            catch (Exception ex)
            {
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.InternalServerError);
                return response;
                throw;
            }
        }

        [HttpPut]
        public HttpResponseMessage UpdateUser(int id, User model)
        {
            try
            {
                if (id == model.Id)
                {
                    dc.Entry(model).State = EntityState.Modified;

                    dc.SaveChanges();
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.OK);
                    return response;
                }
                else
                {
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.NotModified);
                    return response;
                }

            }
            catch (Exception ex)
            {
                HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.InternalServerError);
                return response;
                throw;
            }
        }

        [HttpDelete]
        public HttpResponseMessage DeleteUser(int id)
        {
            User user = dc.Users.Find(id);
            {
                if (user != null)
                {
                    dc.Users.Remove(user);
                    dc.SaveChanges();
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.OK);
                    return response;
                }
                else
                {
                    HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.NotFound);
                    return response;
                }
            }
        }
    }
}
