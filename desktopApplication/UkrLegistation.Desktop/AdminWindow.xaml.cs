using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using UkrLegistation.Desktop.Json;
using UkrLegistation.Desktop.Model;
namespace UkrLegistation.Desktop
{
    /// <summary>
    /// Interaction logic for AdminWindow.xaml
    /// </summary>
    public partial class AdminWindow : Window
    {
        private List<User> _users = new List<User>();
        private List<Role> _roles = new List<Role>(); 
        private bool _flag;
        public AdminWindow()
        {
            InitializeComponent();
            btn_Get.RaiseEvent(new RoutedEventArgs(Button.ClickEvent));
            RoleBox.ItemsSource = _roles;
        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            
            var lastUser = _users.Last();
            User user = new User()
            {
                id = lastUser.id,
                login = LoginBox.Text,
                password = PasswordBox.Text,
                fullName = FullNameBox.Text,
                registrationDate = ToUnixTimeNow(),
                role = new Role()
                {
                    name = RoleBox.Text,
                    id = RoleBox.SelectedIndex + 1
                }
            };
            await UserJson.PostAsync(user, user.id);
            MessageBox.Show("Successfully added");
        }

        private void btn_Get_Click(object sender, RoutedEventArgs e)
        {
            var url = "http://ukrlegislation-itevent.rhcloud.com/restserver/user/";
            UserJson.GetData(out _users, out _flag, url);
            url = "http://ukrlegislation-itevent.rhcloud.com/restserver/role/";
            RoleJson.GetData(out _roles, url);
        }
        private static long ToUnixTimeNow()
        {
            TimeSpan t = DateTime.UtcNow - new DateTime(1970, 1, 1);
            long secondsSinceEpoch = (long)t.TotalSeconds;
            var eposhMs = secondsSinceEpoch * 1000;
            var ms = 3600000 * 7;
            return eposhMs + ms;
        }

        private static DateTime FromUnixTime(long time)
        {
            var ms = 3600000 * 4;
            time -= ms;
            DateTime start = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            DateTime date = start.AddMilliseconds(time);
            return date;
        }
    }
}
