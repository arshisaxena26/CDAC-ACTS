using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WcfServiceMultipleEndpoints
{
    public class Service1 : IService1
    {
        public string GetMessage(string name)
        {
            return "Calling From" + name;
        }
    }
}
