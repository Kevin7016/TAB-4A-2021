using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        WebBrowser navegador = new WebBrowser();

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            navegador.ScriptErrorsSuppressed = true;
            navegador.DocumentCompleted += new WebBrowserDocumentCompletedEventHandler(this.datos_cargados);

        }

        private void datos_cargados(object sender, EventArgs e)
        {
            try
            {
                textBox3.Text = navegador.Document.GetElementById("nav-wrapper").InnerText;

                foreach (HtmlElement etiqueta in navegador.Document.All)
                {

                }
                textBox2.Text = navegador.Document.GetElementById("mainMenu").InnerText;

                foreach (HtmlElement etiqueta in navegador.Document.All)
                {

                }

                int a = 0;
                foreach (HtmlElement etiqueta in navegador.Document.All)
                {
                    if (etiqueta.GetAttribute("classname").Contains("g-hovercard yt-uix-sessionlink      spf-link ") && a == 0)
                    {
                        textBox2.Text = etiqueta.InnerText;
                        a += 1;
                    }
                }
                foreach (HtmlElement etiqueta in navegador.Document.GetElementsByTagName("img"))
                {
                    if (etiqueta.GetAttribute("alt").Contains(pictureBox1.Text))
                    {
                        pictureBox1.ImageLocation = etiqueta.GetAttribute("data-thumb");
                    }
                }
            }
            catch (Exception ex)
            {
            }
        }
        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            navegador.Navigate(textBox1.Text);
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
