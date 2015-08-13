using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using UkrLegistation.Desktop.Model;

namespace UkrLegistation.Desktop.Json
{
    public static class RoleJson
    {
        private static List<Role> _role = new List<Role>();
        private const string UserName = "user";
        private const string Password = "pass";
        //private static bool _flag;
        #region GetAsyncData
        public static void GetData(out List<Role> users, string url)
        {
            var credentials = Convert.ToBase64String(
                Encoding.ASCII.GetBytes(UserName + ":" + Password));

            var asyncClient = new WebClient();
            asyncClient.Headers[HttpRequestHeader.Authorization] = string.Format("Basic {0}", credentials);

            asyncClient.DownloadStringCompleted += asyncClient_DownloadStringComleted;
            asyncClient.DownloadStringAsync(new Uri(url));
            //flagNew = _flag;
            users = _role;
        }

        private static void asyncClient_DownloadStringComleted(object sender, DownloadStringCompletedEventArgs e)
        {
            try
            {
                DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(List<Role>));
                using (var ms = new MemoryStream(Encoding.Unicode.GetBytes(e.Result)))
                {
                    _role = (List<Role>)serializer.ReadObject(ms);
                }
            }
            catch
            {
                Window1 wind = new Window1();
                wind.Show();
                //_flag = true;
            }
        }
        #endregion
    }
}
