using System.Windows;
using UkrLegistation.Desktop.Json;
using UkrLegistation.Desktop.Model;


namespace UkrLegistation.Desktop
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    /// 
    public partial class MainWindow 
    {

        private const string UrlUser = "user/";

        public MainWindow()
        {
            InitializeComponent();
        }



        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            var flag = false;
            var users = await UserJson.Get<User>(UrlUser);
            if (users == null)
            {
                var wind = new Window1();
                wind.Show();
            }
            else
            foreach (var user in users)
            {
                flag = false;
                if (LoginBox.Text == user.login && PasswordBox.Text == user.password &&
                    user.role.name == "ROLE_ADMIN")
                {
                    var admin = new AdminWindow();
                    admin.Show();
                    Close();
                    break;
                }
                else
                {
                    flag = true;
                }
            }
            if (flag)
            {
                var authErr = new ErrorAuthorization();
                authErr.Show();
            }
        }
    }
}
