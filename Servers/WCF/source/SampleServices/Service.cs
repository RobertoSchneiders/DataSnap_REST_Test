namespace SampleServices
{
    public class Service : IService
    {
        public string XMLData(string nome)
        {
            return nome;
        }
        public string JSONData(string nome)
        {
            return nome;
        }

        public string HelloWorld()
        {
            return "[Hello World]";
        }
    }
}
