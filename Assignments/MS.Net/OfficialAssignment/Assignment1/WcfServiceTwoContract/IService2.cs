using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace WcfServiceTwoContract
{
    [ServiceContract]
    public interface IService2
    {
        [OperationContract]
        string Name(string name);

        [OperationContract]
        string Email(string email);
    }
}
