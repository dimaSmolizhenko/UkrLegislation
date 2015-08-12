
using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using UkrLegistation.Desktop.Model;
using Newtonsoft.Json;

namespace UkrLegistation.Desktop.Json
{
    public static class UserJson
    {
        private static List<User> _userData = new List<User>();
        private const string UserName = "user";
        private const string Password = "pass";
        private static bool _flag;
        #region GetAsyncData
        public static void GetData(out List<User> users, out bool flagNew, string url)
        {
            var credentials = Convert.ToBase64String(
                Encoding.ASCII.GetBytes(UserName + ":" + Password));

            var asyncClient = new WebClient();
            asyncClient.Headers[HttpRequestHeader.Authorization] = string.Format("Basic {0}", credentials);

            asyncClient.DownloadStringCompleted += asyncClient_DownloadStringComleted;
            asyncClient.DownloadStringAsync(new Uri(url));
            flagNew = _flag;
            users = _userData;
        }

        private static void asyncClient_DownloadStringComleted(object sender, DownloadStringCompletedEventArgs e)
        {
            try
            {
                DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof (List<User>));
                using (var ms = new MemoryStream(Encoding.Unicode.GetBytes(e.Result)))
                {
                    _userData = (List<User>) serializer.ReadObject(ms);
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
        #region PostAsyncData
        public static async Task PostAsync(User user, int id)
        {

            var stringUser = await Task.Run(() => JsonConvert.SerializeObject(user));
            var httpContent = new StringContent(stringUser, Encoding.UTF8, "application/json");

            using (var httpClient = new HttpClient())
            {

                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue(
                    "Basic",
                    Convert.ToBase64String(
                        Encoding.ASCII.GetBytes(
                            string.Format("{0}:{1}", UserName, Password))));

                var httpResponse =
                    await
                        httpClient.PostAsync("http://ukrlegislation-itevent.rhcloud.com/restserver/user/" + id + "/", httpContent);
                if (httpResponse.Content != null)
                {
                    await httpResponse.Content.ReadAsStringAsync();
                }
            }
        }
        #endregion
        
        #region DeleteAsyncData
        public static async Task DeleteAsync(int id)
        {

            using (var httpClient = new HttpClient())
            {
                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue(
                    "Basic",
                    Convert.ToBase64String(
                        Encoding.ASCII.GetBytes(
                            string.Format("{0}:{1}", UserName, Password))));

                var httpResponse =
                    await
                        httpClient.DeleteAsync("http://ukrlegislation-itevent.rhcloud.com/restserver/user/" + id + "/");
                if (httpResponse.Content != null)
                {
                    await httpResponse.Content.ReadAsStringAsync();
                }
            }
        }
        #endregion
    }

}

