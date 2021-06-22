using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Practica5
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private void Button_Clicked(object sender, EventArgs e)
        {
            var isUserValid = !string.IsNullOrEmpty(txtUser.Text);
            var isPassValid = !string.IsNullOrEmpty(txtPassword.Text);
            if(isUserValid&&isPassValid&&ValidarUsuario())
            {
                Navigation.PushAsync(new LoginOKPage());
            }
            else
            {
                Navigation.PushAsync(new LoginErrorPage());
            }
        }
        public bool ValidarUsuario()
        {
            string usuario = txtUser.Text;
            string contra = txtPassword.Text;
            if (usuario.Equals("KevinM") && contra.Equals("Kev1812"))
            {
                return true;
            }
            else
                return false;
        }
    }
}
