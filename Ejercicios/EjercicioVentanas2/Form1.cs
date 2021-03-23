using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            lst = new ArrayList();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            String texto = entrada.Text;
            if (texto.Equals("SUMAR"))
            {
                Int32 Total = 0;
                for (int i = 0; i<lst.Count;i++)
                {
              Total += (Int32)lst[i];
                }
                texto += (" "+Total);
            }
            else
            {
                try
                {
                    Int32 num = Int32.Parse(texto);
                    lst.Add(num);
                }
                catch (Exception ex)
                {
                }
           
                
            }
            salida.AppendText(texto + "\r\n");
        }

        private void salida_TextChanged(object sender, EventArgs e)
        {

        }
        
        private void clear_Click(object sender, EventArgs e)
        {
            entrada.Text="";
            salida.Text="";
        }
       ArrayList lst;
    }
}
