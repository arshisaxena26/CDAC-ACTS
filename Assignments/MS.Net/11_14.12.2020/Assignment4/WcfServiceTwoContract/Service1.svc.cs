using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WcfServiceTwoContract
{
    public class Service1 : IService1, IService2
    {
        public int Add(int a, int b)
        {
            return a + b;
        }

        public int Div(int a, int b)
        {
            return a / b;
        }

        public string Email(string email)
        {
            return email;
        }

        public int Mul(int a, int b)
        {
            return a * b;
        }

        public string Name(string name)
        {
            return name;
        }

        public int Sub(int a, int b)
        {
            return a - b;
        }
    }
}
