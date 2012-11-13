using System;

namespace ServiceHost
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a ServiceHost for the CaseStudyService type.
            System.ServiceModel.ServiceHost serviceHost = new
                System.ServiceModel.ServiceHost(typeof(SampleServices.Service));


            // Open the ServiceHost to create listeners and start listening for messages.
            serviceHost.Open();
            Console.WriteLine("Services are ready & running.");
            Console.WriteLine();
            Console.ReadLine();
        }
    }
}
