using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace practica2
{
    public partial class Form1 : Form
    {
        int x, y;
        int Xder, Xizq;
        int Yabj, Yarb;
        bool max;
        bool mover;
        bool mini;
        public Form1()
        {
            InitializeComponent();
            Xder = 974;
            Yabj = 820;
            max = false;
            mini = false;
        }

        private void areaTrabajo_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.FillRectangle(Brushes.Red,10,110,200,300);
            g.DrawRectangle(Pens.White, 10, 110, 200, 300);
            g.FillRectangle(Brushes.White, 220, 110, 200, 300);
            g.DrawRectangle(Pens.Black, 220, 110, 200, 300);
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {
            Graphics s = e.Graphics;
            s.FillEllipse(Brushes.Black, 0, 0, 50, 50);
            s.DrawRectangle(Pens.White, 0, 0, 50, 50);
        }

        private void panel2_MouseCaptureChanged(object sender, EventArgs e)
        {

        }

        private void panel2_Scroll(object sender, ScrollEventArgs e)
        {

        }

        private void areaTrabajo_MouseMove(object sender, MouseEventArgs e)
        {
            if (mover == true)
            {
                Point mouseMoveLocation = new Point(e.X, e.Y);
                x = e.X;
                y = e.Y;

                colision();
                panel2.Location = new System.Drawing.Point(x, y);
                if (x <= 180 && y <= 422)
                {
                    max = true;
                }
                if (max)
                {
                    Xder = 158;
                    Yabj = 343;
                }
                if(x >= 10 && y >= 100)
                {
                    mini = true;
                }
                if(mini)
                {
                    Xizq = 10;
                    Yarb = 100;
                }
                colision();
            }
        }
        public void colision()
        {

            if (x >= Xder)
            {
                x = Xder;
            }
            if (y >= Yabj)
            {
                y = Yabj;
            }
            if(x <= Xizq)
            {
                x = Xizq;
            }
            if(y <= Yarb)
            {
                y = Yarb;
            }
        }

        private void label2_Click(object sender, EventArgs e)
        {
            mover = true;
        }

        private void panel3_Paint(object sender, PaintEventArgs e)
        {
            Rectangle r = new Rectangle(10, 1, 75, 75);
            Graphics f = e.Graphics;
            f.FillEllipse(Brushes.Green, r);
        }

        private void panel3_Click(object sender, EventArgs e)
        {
            mover = true;
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            Console.WriteLine(e.KeyChar.ToString());
            if (e.KeyChar == 'x' || e.KeyChar == 'X')
            {
                mover = true;
            }
            if (e.KeyChar == 'c' || e.KeyChar == 'C')
            {
                x = 296;
                y = 254;
                panel2.Location = new System.Drawing.Point(x, y);
                mover = false;
                Xder = 574;
                Yabj = 520;
                max = false;
                mini = false;
            }
        }

        private void areaTrabajo_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {
            x = 296;
            y = 254;
            panel2.Location = new System.Drawing.Point(x, y);
            mover = false;
            Xder = 574;
            Yabj = 520;
            max = false;
            mini = false;
        }

        private void panel1_Click(object sender, EventArgs e)
        {
            x = 296;
            y = 254;
            panel2.Location = new System.Drawing.Point(x, y);
            mover = false;
            Xder = 574;
            Yabj = 520;
            max = false;
            mini = false;
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            Rectangle r = new Rectangle(10, 1, 75, 75);
            Graphics f = e.Graphics;
            f.FillEllipse(Brushes.Green, r);
        }

    }
}
