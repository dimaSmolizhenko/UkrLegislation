
using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Runtime.CompilerServices;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using UkrLegistation.Desktop.Model;
using Newtonsoft.Json;
using System.Net.Http.Formatting;
using System.Windows.Media.Media3D;

namespace UkrLegistation.Desktop.Json
{
    public static class UserJson
    {
        private static List<User> UserData = new List<User>();
        private static bool _flag;
        public static void GetData(out List<User> users, out bool flagNew)
        {
            var url = "http://ukrlegislation-itevent.rhcloud.com/restserver/user/";

            var asyncClient = new WebClient();
            asyncClient.DownloadStringCompleted += asyncClient_DownloadStringComleted;
            asyncClient.DownloadStringAsync(new Uri(url));
            flagNew = _flag;
            users = UserData;
        }
        private static void asyncClient_DownloadStringComleted(object sender, DownloadStringCompletedEventArgs e)
        {
            try
            {
                DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof (List<User>));
                using (var ms = new MemoryStream(Encoding.Unicode.GetBytes(e.Result)))
                {
                    UserData = (List<User>) serializer.ReadObject(ms);
                }
            }
            catch 
            {
                Window1 wind = new Window1();
                wind.Show();
                _flag = true;
            }
        }

        public static void PostData(User user, int id)
        {
            var url = "http://ukrlegislation-itevent.rhcloud.com/restserver/user/"+ id +"/";
            var httpWebRequest = (HttpWebRequest) WebRequest.Create(url);
            httpWebRequest.ContentType = "application/json";
            httpWebRequest.Method = "POST";
            

            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                string json = JsonConvert.SerializeObject(user);
                streamWriter.Write(json);
            }
            var response = (HttpWebResponse) httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
            }
        }

        public static async Task PostAsync(User user)
        {
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://ukrlegislation-itevent.rhcloud.com/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                
                User user1 = new User()
                {
                    id = 1,
                    login = "aaa",
                    password = "aaa",
                    fullName = "aaa",
                    registrationDate = 121212120000,
                    role = new Role()
                    {
                        name = "admin",
                        id = 100
                    }
                };                
                HttpResponseMessage response = await client.PostAsJsonAsync("http://ukrlegislation-itevent.rhcloud.com/restserver/user/",user1);
                var a = 3;
                if (response.IsSuccessStatusCode)
                {
                    Uri userUrl = response.Headers.Location;
                    //User user1 = await response.Content.ReadAsAsync<User>();

                    //user.fullName = "Dima";
                    //response = await client.PutAsJsonAsync(userUrl, user);
                }
            }
        }
    }
}
