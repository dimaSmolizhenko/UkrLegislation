using System;
using System.Linq;
using System.Windows;
using UkrLegistation.Desktop.Json;
using UkrLegistation.Desktop.Model;
namespace UkrLegistation.Desktop
{
    /// <summary>
    /// Interaction logic for AdminWindow.xaml
    /// </summary>
    public partial class AdminWindow 
    {
        private const string UrlUser = "user/";
        private const string UrlRole = "role/";
        public AdminWindow()
        {
            InitializeComponent();
            
        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            var users = await UserJson.Get<User>(UrlUser);
            
            var user = new User()
            {
                id = users.Last().id + 1,
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
            await UserJson.PostAsync(user, user.id, UrlUser);
            DataGrid_Load(new object(), new RoutedEventArgs());
        }

        private static long ToUnixTimeNow()
        {
            TimeSpan t = DateTime.UtcNow - new DateTime(1970, 1, 1);
            var secondsSinceEpoch = (long)t.TotalSeconds;
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

        

        private async void DataGrid_Load(object sender, RoutedEventArgs e)
        {
            var users = await UserJson.Get<User>(UrlUser);
            dataGrid.ItemsSource = users;
        }
        private async void Tab_Load(object sender, RoutedEventArgs e)
        {
            var roles = await UserJson.Get<Role>(UrlRole);
            RoleBox.ItemsSource = roles;
        }

        private async void Button_Click_1(object sender, RoutedEventArgs e)
        {
            await UserJson.DeleteAsync(Convert.ToInt32(IdBox.Text), UrlUser);
            DataGrid_Load(new object(), new RoutedEventArgs());
        }

        private async void Button_Click_2(object sender, RoutedEventArgs e)
        {
            var user = new User()
            {
                id = Convert.ToInt32(IdBox.Text),
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
            await UserJson.PostAsync(user, user.id, UrlUser);
            DataGrid_Load(new object(), new RoutedEventArgs());
        }
    }
}
