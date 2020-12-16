using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WcfService
{
    [ServiceContract]
    public interface IService1
    {
        [OperationContract]
        int Add(int a,int b);

        [OperationContract]
        int Mul(int a, int b);

        [OperationContract]
        string FullName(string firstname,string lastname);

    }  
}
