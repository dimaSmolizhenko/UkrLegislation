using System.Collections.Generic;


namespace UkrLegistation.Desktop.Model
{
    public class Legislator
    {
        public int id { get; set; }
        public string fullName { get; set; }
        public string groupName { get; set; }
        public long chooseBy { get; set; }
        public long dateOfEntry { get; set; }
        public long encludedIn { get; set; }
        public List<object> entryLegislators { get; set; }
    }
}
