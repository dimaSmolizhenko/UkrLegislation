using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using RestSharp;
using RestSharp.Authenticators;
using RestSharp.Deserializers;

namespace UkrLegistation.Desktop.Json
{
    public static class UserJson
    {
        private const string UserName = "user";
        private const string Password = "pass";

        #region GetAsyncData
        
        public static async Task<List<T>> Get<T>(string url)
        {
            var obj = new List<T>();
            try
            {
                var client = new RestClient("http://ukrlegislation-itevent.rhcloud.com/restserver/");
                client.Authenticator = new HttpBasicAuthenticator(UserName, Password);
                var request = new RestRequest(url, Method.GET);
                request.RequestFormat = DataFormat.Json;
                var response = await client.ExecuteTaskAsync(request);
                var des = new JsonDeserializer();
                obj = des.Deserialize<List<T>>(response);
            }
            catch
            {
                var wind = new Window1();
                wind.Show();
            }
            return obj;
        }

        #endregion

        #region PostAsyncData

        public static async Task PostAsync(object obj, int id, string url)
        {

            var stringUser = await Task.Run(() => JsonConvert.SerializeObject(obj));
            var httpContent = new StringContent(stringUser, Encoding.UTF8, "application/json");

            using (var httpClient = new HttpClient())
            {
                httpClient.BaseAddress = new Uri("http://ukrlegislation-itevent.rhcloud.com/restserver/");

                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue(
                    "Basic",
                    Convert.ToBase64String(
                        Encoding.ASCII.GetBytes(
                            string.Format("{0}:{1}", UserName, Password))));

                var httpResponse =
                    await
                        httpClient.PostAsync(url + id + "/", httpContent);
                if (httpResponse.Content != null)
                {
                    await httpResponse.Content.ReadAsStringAsync();
                }
            }
        }

        #endregion

        #region DeleteAsyncData

        public static async Task DeleteAsync(int id, string url)
        {

            using (var httpClient = new HttpClient())
            {
                httpClient.BaseAddress = new Uri("http://ukrlegislation-itevent.rhcloud.com/restserver/");
                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue(
                    "Basic",
                    Convert.ToBase64String(
                        Encoding.ASCII.GetBytes(
                            string.Format("{0}:{1}", UserName, Password))));

                var httpResponse =
                    await
                        httpClient.DeleteAsync(url + id + "/");
                if (httpResponse.Content != null)
                {
                    await httpResponse.Content.ReadAsStringAsync();
                }
            }
        }

        #endregion


        


    }
}




