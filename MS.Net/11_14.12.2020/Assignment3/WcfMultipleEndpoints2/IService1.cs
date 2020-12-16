using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WcfMultipleEndpoints2
{
    [ServiceContract]
    public interface IService1
    {
        [OperationContract]
        int Add(int a, int b);

        [OperationContract]
        int Sub(int a, int b);

        [OperationContract]
        int Mul(int a, int b);

        [OperationContract]
        int Div(int a, int b);
    }
}
