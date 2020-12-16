using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using ClientMulEndpoints2.ServiceReference1;

namespace ClientMulEndpoints2
{
    class Program
    {
        static void Main(string[] args)
        {
            BasicHttpBinding binding = new BasicHttpBinding();
            EndpointAddress endpoint = new EndpointAddress("http://localhost:50649/Service1.svc?wsdl/basic");
            ChannelFactory<IService1> channelFactory1 = new ChannelFactory<IService1>(binding,endpoint);
            IService1 instance1 = channelFactory1.CreateChannel();
            Console.WriteLine(instance1.Add(10, 10));
            channelFactory1.Close();

            WSHttpBinding wsBinding = new WSHttpBinding();
            EndpointAddress wsEndpoint = new EndpointAddress("http://localhost:50649/Service1.svc?wsdl/secure");
            ChannelFactory<IService1> wsChannelFactory = new ChannelFactory<IService1>(wsBinding, wsEndpoint);
            IService1 instance2 = wsChannelFactory.CreateChannel();
            Console.WriteLine(instance2.Add(20, 10));
            wsChannelFactory.Close();

            Console.ReadLine();

        }
    }
}
