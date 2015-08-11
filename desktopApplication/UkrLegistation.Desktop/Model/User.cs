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
    [DataContract]
    public class User
    {
        [DataMember]
        public int id { get; set; }
        [DataMember]
        public string login { get; set; }
        [DataMember]
        public string password { get; set; }
        [DataMember]
        public string fullName { get; set; }
        [DataMember]
        public long registrationDate { get; set; }
        [DataMember]
        public Role role { get; set; }
    }
}
