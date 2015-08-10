﻿
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
        private List<User> users = new List<User>();
        private bool flag;
        public AdminWindow()
        {
            InitializeComponent();
            btn_Get.RaiseEvent(new RoutedEventArgs(Button.ClickEvent));
        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            var lastUser = users.Last();
            Role roleNew = new Role()
            {

                name = RoleBox.Text,
                id = RoleBox.SelectedIndex
                
            };
            User user = new User()
            {
                id = lastUser.id + 1,
                login = LoginBox.Text,
                password = PasswordBox.Text,
                fullName = FullNameBox.Text,
                registrationDate = 121212120000,
                role = roleNew
            };
            await UserJson.PostAsync(user);
            MessageBox.Show("Successfully added");
        }

        private void btn_Get_Click(object sender, RoutedEventArgs e)
        {
            UserJson.GetData(out users, out flag);
            MessageBox.Show("Data ");
        }
    }
}
