
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
using System.Windows.Controls;
using System.Windows.Media.Media3D;

namespace UkrLegistation.Desktop.Json
{
    public static class UserJson
    {
        private static List<User> UserData = new List<User>();
        private static bool _flag;
        #region GetAsyncData
        public static void GetData(out List<User> users, out bool flagNew)
        {
            var url = "http://ukrlegislation-itevent.rhcloud.com/restserver/user/";
            var userName = "user";
            var password = "pass";

            var credentials = Convert.ToBase64String(
                Encoding.ASCII.GetBytes(userName + ":" + password));


            var asyncClient = new WebClient();

            asyncClient.Headers[HttpRequestHeader.Authorization] = string.Format("Basic {0}", credentials);

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
        #endregion
        public static void PostData(User user, int id)
        {
            var url = "http://ukrlegislation-itevent.rhcloud.com/restserver/user/" + id + "/";
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

        public static async Task PostAsync(User user, int id)
        {

            var stringUser = await Task.Run(() => JsonConvert.SerializeObject(user));
            var httpContent = new StringContent(stringUser, Encoding.UTF8, "application/json");

            using (var httpClient = new HttpClient())
            {
                var userName = "user";
                var password = "pass";

                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue(
                    "Basic",
                    Convert.ToBase64String(
                        Encoding.ASCII.GetBytes(
                            string.Format("{0}:{1}", userName, password))));

                var httpResponse =
                    await
                        httpClient.PostAsync("http://ukrlegislation-itevent.rhcloud.com/restserver/user/"+id+"/", httpContent);
                if (httpResponse.Content != null)
                {
                    var responseContent = await httpResponse.Content.ReadAsStringAsync();
                }
                //Complete
            }
        }
    }

}

