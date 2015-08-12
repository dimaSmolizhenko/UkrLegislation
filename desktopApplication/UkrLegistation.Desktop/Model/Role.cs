using System.Runtime.Serialization;

namespace UkrLegistation.Desktop.Model
{
    [DataContract]
    public class Role
    {
        [DataMember]
        public int id { get; set; }
        [DataMember]
        public string name { get; set; }
    }
}
